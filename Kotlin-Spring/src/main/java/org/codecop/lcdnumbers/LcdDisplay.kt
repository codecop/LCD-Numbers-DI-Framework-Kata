package org.codecop.lcdnumbers

/**
 * Combines Converter, Scaler and Printer.
 */
interface LcdDisplay {
    fun toLcd(number: Int, scaling: Scaling): String
}