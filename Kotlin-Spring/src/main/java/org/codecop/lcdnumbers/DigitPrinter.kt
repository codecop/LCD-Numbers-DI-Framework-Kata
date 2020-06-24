package org.codecop.lcdnumbers

/**
 * Appends lines next to each other and adds line breaks.
 */
interface DigitPrinter {
    fun render(digits: List<Digit>): String
}