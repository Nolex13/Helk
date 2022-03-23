package dev.helk

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MapLeftTest {
    @Test
    fun `happy path`() {
        data class AnError(override val message: String) : RuntimeException(message)
        data class AnotherError(val parentError: AnError) : RuntimeException()

        try {
            Future { throw AnError("anError") }.mapLeft {
                if (it is AnError) {
                    AnotherError(it)
                } else {
                    throw AssertionError("Error in mapLeft is not of the right type")
                }
            }.join()
            throw AssertionError("Future is not throwing exception")
        } catch (e: Exception) {
            e.cause shouldBe AnotherError(AnError("anError"))
        }
    }
}