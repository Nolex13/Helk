package dev.helk.koney.exceptions

import dev.helk.koney.Kurrency

open class DifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency,
    operation: String
): RuntimeException(
    "Trying to $operation two Koney with currency $firstCurrency and $secondCurrency"
)