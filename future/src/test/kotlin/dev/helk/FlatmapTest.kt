package dev.helk

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FlatmapTest {
    @Test
    fun `flatmap returning a different type value`() {
        val aStringReturnType = "a string return type"
        val aNumberReturnType = 9
        Future { aStringReturnType }.flatMap {
            aNumberReturnType
        }.join() shouldBe 9
    }
}