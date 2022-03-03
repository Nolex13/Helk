package dev.helk.koney.exceptions

import dev.helk.koney.Kurrency

class MultiplyDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "multiply")