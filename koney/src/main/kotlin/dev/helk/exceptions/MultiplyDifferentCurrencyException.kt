package dev.helk.exceptions

import dev.helk.Kurrency


class MultiplyDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "multiply")