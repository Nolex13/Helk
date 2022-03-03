package dev.helk.koney.exceptions

import dev.helk.koney.Kurrency

class SumDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "sum")