package dev.helk.koney.exceptions

import dev.helk.koney.Kurrency

class SubtractDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "subtract")