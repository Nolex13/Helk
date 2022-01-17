package money

import money.Currency.Companion.EUR
import money.Currency.Companion.USD
import java.math.BigDecimal

@JvmInline
value class Currency(
    val value: String
) {
    companion object {
        val EUR = Currency("EUR")
        val USD = Currency("USD")
    }
}

data class Money(
    val amount: BigDecimal,
    val currency: Currency
) {
    operator fun plus(money: Money) =
        if (this.currency == money.currency) {
            Money(
                amount + money.amount,
                currency
            )
        } else {
            throw RuntimeException()
        }

    operator fun minus(money: Money) =
        if (this.currency == money.currency) {
            Money(
                amount - money.amount,
                currency
            )
        } else {
            throw RuntimeException()
        }

    operator fun times(money: Money) =
        if (this.currency == money.currency) {
            Money(
                amount * money.amount,
                currency
            )
        } else {
            throw RuntimeException()
        }

    operator fun div(money: Money) =
        if (this.currency == money.currency) {
            Money(
                amount / money.amount,
                currency
            )
        } else {
            throw RuntimeException()
        }

    infix fun convertTo(currency: Currency): MoneyConverter =
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

interface MoneyConverter{
    infix fun usingRate(conversionRate: BigDecimal): Money
}

private class MoneyToOtherCurrencyConverter(
    private val actualMoney: Money,
    private val newCurrency: Currency
): MoneyConverter {
    override infix fun usingRate(conversionRate: BigDecimal): Money =
        Money(
            actualMoney.amount * conversionRate,
            newCurrency
        )
}

private class MoneyToEuroCurrencyConverter(
    private val actualMoney: Money,
    private val newCurrency: Currency
): MoneyConverter {
    override infix fun usingRate(conversionRate: BigDecimal): Money =
        Money(
            actualMoney.amount / conversionRate,
            newCurrency
        )
}

fun test() {
    ("10.59".euro convertTo USD usingRate BigDecimal("2")) - "10.23".euro
}

infix fun BigDecimal.ofCurrency(currency: Currency): Money =
    Money(this, currency)

infix fun String.ofCurrency(currency: Currency): Money =
    Money(this.toBigDecimal(), currency)

infix fun Int.ofCurrency(currency: Currency): Money =
    Money(this.toBigDecimal(), currency)

val BigDecimal.euro get() = this.ofCurrency(EUR)
val String.euro get() = this.ofCurrency(EUR)