package org.codecop.lcdnumbers

import javax.inject.Inject

/**
 * Combines Converter, Scaler and Printer.
 */
class LcdDisplayImpl @Inject constructor(
    private val digitsSplitter: DigitsSplitter,
    private val digitScaler: DigitScaler,
    private val digitPrinter: DigitPrinter
) : LcdDisplay {
    override fun toLcd(number: Int, scaling: Scaling): String {
        val digits = digitsSplitter.convert(number)
        val scaled = digitScaler.scale(digits, scaling)
        return digitPrinter.render(scaled)
    }
}