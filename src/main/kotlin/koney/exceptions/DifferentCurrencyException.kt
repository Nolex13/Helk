package koney.exceptions

import koney.Kurrency

open class DifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency,
    operation: String
): RuntimeException(
    "Trying to $operation two Koney with currency $firstCurrency and $secondCurrency"
)