package koney

import koney.Kurrency.Companion.EUR
import koney.Kurrency.Companion.GBP
import koney.exceptions.DivideDifferentCurrencyException
import koney.exceptions.MultiplyDifferentCurrencyException
import koney.exceptions.SubtractDifferentCurrencyException
import koney.exceptions.SumDifferentCurrencyException
import java.math.BigDecimal
import java.math.RoundingMode.HALF_UP

/**
 * Koney (Money)
 */
data class Koney(
    val amount: BigDecimal,
    val currency: Kurrency
) {
    operator fun plus(money: Koney) =
        if (this.currency == money.currency) {
            Koney(
                amount + money.amount,
                currency
            )
        } else {
            throw SumDifferentCurrencyException(this.currency, money.currency)
        }

    operator fun minus(money: Koney) =
        if (this.currency == money.currency) {
            Koney(
                amount - money.amount,
                currency
            )
        } else {
            throw SubtractDifferentCurrencyException(this.currency, money.currency)
        }

    operator fun times(money: Koney) =
        if (this.currency == money.currency) {
            Koney(
                (amount * money.amount).setScale(2, HALF_UP),
                currency
            )
        } else {
            throw MultiplyDifferentCurrencyException(this.currency, money.currency)
        }

    operator fun div(money: Koney) =
        if (this.currency == money.currency) {
            Koney(
                amount.divide(money.amount, 2, HALF_UP),
                currency
            )
        } else {
            throw DivideDifferentCurrencyException(this.currency, money.currency)
        }

    infix fun convertTo(currency: Kurrency): MoneyConverter =
        if (currency == EUR) {
            MoneyToEuroCurrencyConverter(
                this, currency
            )
        } else {
            MoneyToOtherCurrencyConverter(
                this, currency
            )
        }
}

interface MoneyConverter {
    infix fun usingRate(conversionRate: BigDecimal): Koney
}

private class MoneyToOtherCurrencyConverter(
    private val actualMoney: Koney,
    private val newCurrency: Kurrency
) : MoneyConverter {
    override infix fun usingRate(conversionRate: BigDecimal): Koney =
        Koney(
            (actualMoney.amount * conversionRate).setScale(2, HALF_UP),
            newCurrency
        )
}

private class MoneyToEuroCurrencyConverter(
    private val actualMoney: Koney,
    private val newCurrency: Kurrency
) : MoneyConverter {
    override infix fun usingRate(conversionRate: BigDecimal): Koney =
        Koney(
            actualMoney.amount / conversionRate,
            newCurrency
        )
}

infix fun BigDecimal.ofCurrency(currency: Kurrency): Koney =
    Koney(this, currency)

infix fun String.ofCurrency(currency: Kurrency): Koney =
    Koney(this.toBigDecimal().setScale(2, HALF_UP), currency)

infix fun Double.ofCurrency(currency: Kurrency): Koney =
    Koney(this.toBigDecimal().setScale(2, HALF_UP), currency)

infix fun Int.ofCurrency(currency: Kurrency): Koney =
    Koney(this.toBigDecimal().setScale(2, HALF_UP), currency)

val BigDecimal.euro get() = this.ofCurrency(EUR)
val String.euro get() = this.ofCurrency(EUR)
val String.gbp get() = this.ofCurrency(GBP)
val Int.gbp get() = this.ofCurrency(GBP)
val Double.gbp get() = this.ofCurrency(GBP)
val Double.euro get() = this.ofCurrency(EUR)
val Int.euro get() = this.ofCurrency(EUR)