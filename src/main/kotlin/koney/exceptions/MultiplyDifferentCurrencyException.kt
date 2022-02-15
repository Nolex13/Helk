package koney.exceptions

import koney.Kurrency

class MultiplyDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "multiply")