package koney

import dev.helk.koney.euro
import dev.helk.koney.gbp
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import dev.helk.koney.Kurrency.Companion.EUR
import dev.helk.koney.Kurrency.Companion.GBP
import dev.helk.koney.Kurrency.Companion.KWD
import dev.helk.koney.exceptions.DivideDifferentCurrencyException
import dev.helk.koney.exceptions.MultiplyDifferentCurrencyException
import dev.helk.koney.exceptions.SubtractDifferentCurrencyException
import dev.helk.koney.exceptions.SumDifferentCurrencyException
import dev.helk.koney.ofCurrency
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class KoneyTest {
    @Test
    fun `sum two money with the same currency`() {
        100.euro + 50.euro shouldBe 150.euro
    }

    @Test
    fun `sum two money with different currencies`() {
        shouldThrow<SumDifferentCurrencyException> {
            100.euro + 50.gbp shouldBe 150.euro
        }
    }

    @Test
    fun `subtract two money with the same currency`() {
        100.euro - 60.euro shouldBe 40.euro
    }

    @Test
    fun `subtract two money with different currencies`() {
        shouldThrow<SubtractDifferentCurrencyException> {
            100.euro - 60.gbp shouldBe 40.euro
        }
    }

    @Test
    fun `multiply two money with the same currency`() {
        100.euro * 60.euro shouldBe 6000.euro
    }

    @Test
    fun `multiply two money with the same currency with 3 decimals`() {
        100.567.ofCurrency(KWD) * 60.234.ofCurrency(KWD) shouldBe 6057.553.ofCurrency(KWD)
    }

    @Test
    fun `multiply two money with different currencies`() {
        shouldThrow<MultiplyDifferentCurrencyException> {
            100.euro * 60.gbp shouldBe 6000.euro
        }
    }

    @Test
    fun `divide two money with the same currency`() {
        100.euro / 60.euro shouldBe 1.67.euro
    }

    @Test
    fun `divide two money with the same currency with 3 decimals`() {
        100.567.ofCurrency(KWD) / 60.234.ofCurrency(KWD) shouldBe 1.670.ofCurrency(KWD)
    }

    @Test
    fun `divide two money with different currencies`() {
        shouldThrow<DivideDifferentCurrencyException> {
            100.euro / 60.gbp shouldBe 1.67.euro
        }
    }

    @Test
    fun `conversion from EUR to other currency`() {
        val conversionRate = BigDecimal("0.8392")
        100.euro convertTo GBP usingRate conversionRate shouldBe 83.92.gbp
    }

    @Test
    fun `conversion from EUR to other currency with 3 decimals`() {
        val conversionRate = BigDecimal("0.839212")
        100.euro convertTo KWD usingRate conversionRate shouldBe 83.921.ofCurrency(KWD)
    }

    @Test
    fun `conversion from GPB to EUR`() {
        val conversionRate = BigDecimal("0.8392")
        100.gbp convertTo EUR usingRate conversionRate shouldBe 119.16.euro
    }
}