package koney.exceptions

import koney.Kurrency

class SumDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "sum")