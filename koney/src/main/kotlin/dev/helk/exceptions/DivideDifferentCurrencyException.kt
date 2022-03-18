package dev.helk.exceptions

import dev.helk.Kurrency


class DivideDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "divide")