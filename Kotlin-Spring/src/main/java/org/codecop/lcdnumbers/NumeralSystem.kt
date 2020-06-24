package org.codecop.lcdnumbers

/**
 * Splits a number into its digits according to its numeral system, e.g. Decimal System.
 */
interface NumeralSystem {
    fun digitsOf(value: Int): List<Int>
}