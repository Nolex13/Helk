package koney.exceptions

import koney.Kurrency

class SubtractDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "subtract")