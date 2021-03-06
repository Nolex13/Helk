package dev.helk

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test


internal class KurrencyTest {
    @Test
    fun `currency values are right`() {
        currencies.forEach { currency ->
            currency.first shouldBe currency.second.value
        }
    }

    @Test
    fun `toString returns the currency directly`() {
        Kurrency.EUR.toString() shouldBe "EUR"
    }

    @Test
    fun `fraction digits`() {
        Kurrency.EUR.defaultFractionDigits() shouldBe 2
        Kurrency.KWD.defaultFractionDigits() shouldBe 3
        Kurrency.KMF.defaultFractionDigits() shouldBe 0
    }

    companion object {
        val currencies = setOf(
            "AFN" to Kurrency.AFN,
            "EUR" to Kurrency.EUR,
            "ALL" to Kurrency.ALL,
            "DZD" to Kurrency.DZD,
            "AOA" to Kurrency.AOA,
            "ARS" to Kurrency.ARS,
            "AMD" to Kurrency.AMD,
            "AWG" to Kurrency.AWG,
            "AZN" to Kurrency.AZN,
            "BSD" to Kurrency.BSD,
            "BHD" to Kurrency.BHD,
            "BDT" to Kurrency.BDT,
            "BBD" to Kurrency.BBD,
            "BYN" to Kurrency.BYN,
            "BZD" to Kurrency.BZD,
            "BMD" to Kurrency.BMD,
            "BTN" to Kurrency.BTN,
            "BOB" to Kurrency.BOB,
            "BAM" to Kurrency.BAM,
            "BWP" to Kurrency.BWP,
            "BRL" to Kurrency.BRL,
            "BND" to Kurrency.BND,
            "BGN" to Kurrency.BGN,
            "BIF" to Kurrency.BIF,
            "CVE" to Kurrency.CVE,
            "KHR" to Kurrency.KHR,
            "CAD" to Kurrency.CAD,
            "KYD" to Kurrency.KYD,
            "CLP" to Kurrency.CLP,
            "CNY" to Kurrency.CNY,
            "COP" to Kurrency.COP,
            "KMF" to Kurrency.KMF,
            "CDF" to Kurrency.CDF,
            "CRC" to Kurrency.CRC,
            "HRK" to Kurrency.HRK,
            "CUP" to Kurrency.CUP,
            "CZK" to Kurrency.CZK,
            "DJF" to Kurrency.DJF,
            "DOP" to Kurrency.DOP,
            "EGP" to Kurrency.EGP,
            "ERN" to Kurrency.ERN,
            "SZL" to Kurrency.SZL,
            "ETB" to Kurrency.ETB,
            "FKP" to Kurrency.FKP,
            "FJD" to Kurrency.FJD,
            "XAF" to Kurrency.XAF,
            "GMD" to Kurrency.GMD,
            "GEL" to Kurrency.GEL,
            "GHS" to Kurrency.GHS,
            "GIP" to Kurrency.GIP,
            "DKK" to Kurrency.DKK,
            "GTQ" to Kurrency.GTQ,
            "GGP" to Kurrency.GGP,
            "GNF" to Kurrency.GNF,
            "GYD" to Kurrency.GYD,
            "HTG" to Kurrency.HTG,
            "HNL" to Kurrency.HNL,
            "HKD" to Kurrency.HKD,
            "HUF" to Kurrency.HUF,
            "ISK" to Kurrency.ISK,
            "INR" to Kurrency.INR,
            "IDR" to Kurrency.IDR,
            "XDR" to Kurrency.XDR,
            "IRR" to Kurrency.IRR,
            "IQD" to Kurrency.IQD,
            "IMP" to Kurrency.IMP,
            "JMD" to Kurrency.JMD,
            "JPY" to Kurrency.JPY,
            "JEP" to Kurrency.JEP,
            "JOD" to Kurrency.JOD,
            "KZT" to Kurrency.KZT,
            "KES" to Kurrency.KES,
            "AUD" to Kurrency.AUD,
            "KWD" to Kurrency.KWD,
            "KGS" to Kurrency.KGS,
            "LAK" to Kurrency.LAK,
            "LBP" to Kurrency.LBP,
            "LSL" to Kurrency.LSL,
            "LRD" to Kurrency.LRD,
            "LYD" to Kurrency.LYD,
            "MOP" to Kurrency.MOP,
            "MGA" to Kurrency.MGA,
            "MWK" to Kurrency.MWK,
            "MYR" to Kurrency.MYR,
            "MVR" to Kurrency.MVR,
            "MRU" to Kurrency.MRU,
            "MUR" to Kurrency.MUR,
            "MXN" to Kurrency.MXN,
            "MDL" to Kurrency.MDL,
            "MNT" to Kurrency.MNT,
            "MAD" to Kurrency.MAD,
            "MZN" to Kurrency.MZN,
            "MMK" to Kurrency.MMK,
            "NAD" to Kurrency.NAD,
            "NPR" to Kurrency.NPR,
            "NIO" to Kurrency.NIO,
            "NGN" to Kurrency.NGN,
            "KPW" to Kurrency.KPW,
            "MKD" to Kurrency.MKD,
            "NOK" to Kurrency.NOK,
            "OMR" to Kurrency.OMR,
            "PKR" to Kurrency.PKR,
            "USD" to Kurrency.USD,
            "ILS" to Kurrency.ILS,
            "PGK" to Kurrency.PGK,
            "PYG" to Kurrency.PYG,
            "PEN" to Kurrency.PEN,
            "PHP" to Kurrency.PHP,
            "PLN" to Kurrency.PLN,
            "QAR" to Kurrency.QAR,
            "RON" to Kurrency.RON,
            "RUB" to Kurrency.RUB,
            "RWF" to Kurrency.RWF,
            "SHP" to Kurrency.SHP,
            "XCD" to Kurrency.XCD,
            "WST" to Kurrency.WST,
            "STN" to Kurrency.STN,
            "SAR" to Kurrency.SAR,
            "RSD" to Kurrency.RSD,
            "SCR" to Kurrency.SCR,
            "SLL" to Kurrency.SLL,
            "SGD" to Kurrency.SGD,
            "ANG" to Kurrency.ANG,
            "SBD" to Kurrency.SBD,
            "SOS" to Kurrency.SOS,
            "ZAR" to Kurrency.ZAR,
            "KRW" to Kurrency.KRW,
            "SSP" to Kurrency.SSP,
            "LKR" to Kurrency.LKR,
            "SDG" to Kurrency.SDG,
            "SRD" to Kurrency.SRD,
            "SEK" to Kurrency.SEK,
            "CHF" to Kurrency.CHF,
            "SYP" to Kurrency.SYP,
            "TWD" to Kurrency.TWD,
            "TJS" to Kurrency.TJS,
            "TZS" to Kurrency.TZS,
            "THB" to Kurrency.THB,
            "XOF" to Kurrency.XOF,
            "NZD" to Kurrency.NZD,
            "TOP" to Kurrency.TOP,
            "TTD" to Kurrency.TTD,
            "TND" to Kurrency.TND,
            "TRY" to Kurrency.TRY,
            "TMT" to Kurrency.TMT,
            "UGX" to Kurrency.UGX,
            "UAH" to Kurrency.UAH,
            "AED" to Kurrency.AED,
            "GBP" to Kurrency.GBP,
            "UYU" to Kurrency.UYU,
            "UZS" to Kurrency.UZS,
            "VUV" to Kurrency.VUV,
            "VES" to Kurrency.VES,
            "VND" to Kurrency.VND,
            "XPF" to Kurrency.XPF,
            "YER" to Kurrency.YER,
            "ZMW" to Kurrency.ZMW,
        )
    }
}