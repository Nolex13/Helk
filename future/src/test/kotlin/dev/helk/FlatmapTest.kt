package dev.helk

import io.kotest.matchers.shouldBe
import java.math.BigDecimal
import org.junit.jupiter.api.Test

internal class FlatmapTest {
    @Test
    fun `flatmap returning a different type value`() {
        val aStringReturnType = "a string return type"
        val aNumberReturnType = 9
        Future { aStringReturnType }.flatMap {
            Future { aNumberReturnType}
        }.let { it shouldBe 9 }
    }

    @Test
    fun `flatmap more Futures together`() {
        Future { "13.4" }
            .flatMap { stringValue ->
                Future{BigDecimal(stringValue)}.flatMap { bigDecimalValue ->
                    Future { bigDecimalValue.toDouble() }
                }
            }.let {
                it shouldBe 13.4
            }
    }
}