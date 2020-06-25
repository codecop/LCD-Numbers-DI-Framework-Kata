package org.codecop.lcdnumbers

/**
 * Splits into digits and converts digits to LCD digits.
 */
interface DigitsSplitter {
    fun convert(number: Int): List<Digit>
}