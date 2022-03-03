package dev.helk.koney

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class KoneyModuleTest {
    private val objectMapper = ObjectMapper().findAndRegisterModules()

    @Test
    fun `serialize and deserialize correctly`() {
        val money = "10.55".euro
        val json = objectMapper.writeValueAsString(money)
        objectMapper.readValue(json, Koney::class.java) shouldBe money
    }
}