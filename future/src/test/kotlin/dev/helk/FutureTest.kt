package dev.helk

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test


internal class FutureTest {
    @Test
    fun `happy path`() {
        Future { "ciao" }.get() shouldBe "ciao"
    }

    @Test
    fun `when completable future throws error`() {
        class Error : RuntimeException("test")

        try {
            Future<String> { throw Error() }.join()
            true shouldBe false
        } catch (e: Exception) {
            e.cause shouldBe Error()
        }
    }
}