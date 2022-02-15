package koney.exceptions

import koney.Kurrency

class DivideDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "divide")