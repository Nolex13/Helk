package dev.helk

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs
import org.junit.jupiter.api.Test

internal class FoldTest {
    @Test
    fun `when completable future succeed`() {
        Future { "a successfully completable future" }.fold(
            { throw RuntimeException("error") },
            { "$it folded" }
        ).join() shouldBe "a successfully completable future folded"
    }

    @Test
    fun `when completable future fails`() {
        try {
            Future<String> { throw TestError() }.fold(
                { throw AnotherTestError(it) },
                { "$it folded" }
            ).join()
            true shouldBe false

        } catch (e: Throwable) {
            if (e.cause is AnotherTestError) {
                (e.cause!! as AnotherTestError).parentError shouldBe TestError()
            } else {
                e shouldBeSameInstanceAs AnotherTestError::class
            }
        }
    }

    class TestError : Throwable("error"){
        override fun toString(): String {
            return "TestError()"
        }
    }
    data class AnotherTestError(val parentError: Throwable) : Throwable("error"){
        override fun toString(): String {
            return "AnotherTestError(parentError=$parentError)"
        }
    }
}