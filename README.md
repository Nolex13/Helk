[![Build & Test](https://github.com/Nolex13/Helk/actions/workflows/build-test.yml/badge.svg)](https://github.com/Nolex13/Helk/actions/workflows/build-test.yml)
[![Publish package to Maven Central Repository](https://github.com/Nolex13/Helk/actions/workflows/deploy.yml/badge.svg)](https://github.com/Nolex13/Helk/actions/workflows/deploy.yml)

# Helk
A simple library written in Kotlin with utils and useful functions

## Getting started
Just add the dependency to you pom.xml and enjoy
```xml
<dependency>
  <groupId>dev.helk</groupId>
  <artifactId>core</artifactId>
  <version>0.1.1</version>
</dependency>
```

## Koney (Money)
Simple money object with two properties: amount[BigDecimal] and currency[[Kurrency]](#kurrency)
The object already contains the basic operator overload for summing, subtracting, multiplying and dividing the money of the same currency directly
```kotlin
100.euro + 50.euro shouldBe 150.euro
100.euro - 60.euro shouldBe 40.euro
100.euro * 60.euro shouldBe 6000.euro
100.euro / 60.euro shouldBe 1.67.euro
```

and some conversion function from EUR to custom currency and vice versa:
```kotlin
val conversionRate = BigDecimal("0.8392")
100.euro convertTo GBP usingRate conversionRate shouldBe 83.92.gbp
100.gbp convertTo EUR usingRate conversionRate shouldBe 119.16.euro
```

There are also some handy builder like:
```kotlin
BigDecimal("10.56").euro
BigDecimal("10.56").gbp
"10.56".euro
"10.56".gbp
9.euro
9.gbp
10.56.gbp
10.56.euro
```
at the moment the only currencies available in this buidlers are `euro` and `gbp` so, if needed, fill free to open a Merge Request

Serialization and deserialization are also included by default using Jackson. Remember to register the right module using:
```
val objectMapper = ObjectMapper().registerModule(KoneyModule())
```
or
```
val objectMapper = ObjectMapper().findAndRegisterModules()
```

### <a name="kurrency"></a>Kurrency (Currency)
Simple value class that represents the currency

There are also some handy builder like:
```kotlin
EUR shouldBe Currency("EUR")
AFN shouldBe Currency("AFN")
GBP shouldBe Currency("GBP")
```
all the currencies are present under Currency.companion.*