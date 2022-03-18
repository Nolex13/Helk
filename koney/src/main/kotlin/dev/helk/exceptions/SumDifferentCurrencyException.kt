package dev.helk.exceptions

import dev.helk.Kurrency

class SumDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "sum")