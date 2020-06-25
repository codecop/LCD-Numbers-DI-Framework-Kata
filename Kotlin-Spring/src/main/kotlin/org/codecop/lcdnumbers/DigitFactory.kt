package org.codecop.lcdnumbers

/**
 * Creates (LCD) digits from patterns.
 */
interface DigitFactory {
    fun create(digit: Int): Digit
}