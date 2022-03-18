package dev.helk

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.module.SimpleDeserializers
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.module.SimpleSerializers
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.io.IOException
import java.math.BigDecimal

class KoneyModule: SimpleModule() {
    override fun getModuleName(): String = this.javaClass.simpleName

    override fun setupModule(context: SetupContext) {
        val serializers = SimpleSerializers()
        serializers.addSerializer(Koney::class.java, KoneySerializer())
        context.addSerializers(serializers)

        val deserializers = SimpleDeserializers()
        deserializers.addDeserializer(Koney::class.java, KoneyDeserializer())
        context.addDeserializers(deserializers)
    }
}

open class KoneySerializer : StdSerializer<Koney>(Koney::class.java) {
    @Throws(IOException::class)
    override fun serialize(koney: Koney, jsonGenerator: JsonGenerator, serializerProvider: SerializerProvider) {
        jsonGenerator.writeStartObject()
        jsonGenerator.writeStringField("amount", koney.amount.toPlainString())
        jsonGenerator.writeStringField("currency", koney.currency.value)
        jsonGenerator.writeEndObject()
    }
}

open class KoneyDeserializer : StdDeserializer<Koney>(Koney::class.java) {
    override fun deserialize(jsonParser: JsonParser, obj: DeserializationContext): Koney {
        val node: JsonNode = jsonParser.codec.readTree(jsonParser)
        val amount = BigDecimal(node.get("amount").asText())
        val currency: String = node.get("currency").asText()

        return Koney(amount, Kurrency(currency))
    }
}