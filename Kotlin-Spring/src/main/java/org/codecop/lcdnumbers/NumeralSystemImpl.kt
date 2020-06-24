package org.codecop.lcdnumbers

/**
 * Splits a number into its digits according to its numeral system, e.g. Decimal System.
 */
class NumeralSystemImpl(private val base: Int) : NumeralSystem {
    init {
        require(base >= 2) { "Smallest base is binary; base=$base" }
    }
    
    override fun digitsOf(value: Int): List<Int> {
        require(value >= 0) { "negative number $value" }
        
        val digits = mutableListOf<Int>()
        var remainder = value
        while (remainder > 0) {
            digits.add(remainder % base)
            remainder /= base
        }
        
        return digits.reversed()
    }
}
