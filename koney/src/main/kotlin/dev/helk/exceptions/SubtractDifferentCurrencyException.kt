package dev.helk.exceptions

import dev.helk.Kurrency

class SubtractDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "subtract")