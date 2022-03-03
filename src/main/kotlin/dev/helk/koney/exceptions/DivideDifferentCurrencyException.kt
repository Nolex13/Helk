package dev.helk.koney.exceptions

import dev.helk.koney.Kurrency

class DivideDifferentCurrencyException(
    firstCurrency: Kurrency,
    secondCurrency: Kurrency
) : DifferentCurrencyException(firstCurrency, secondCurrency, "divide")