package dev.helk

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LetTest {
    @Test
    fun `Happy path`() {
        Future { "a simple future" }.let {
            it shouldBe "a simple future"
        } shouldBe Unit
    }
}