package org.codecop.lcdnumbers

/**
 * Scales x and y of digit lines.
 */
interface DigitScaler {
    fun scale(digits: List<Digit>, scaling: Scaling): List<Digit>
}