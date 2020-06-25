package org.codecop.lcdnumbers

import javax.inject.Inject

/**
 * Scales x and y of digit lines.
 */
class DigitScalerImpl @Inject constructor(
    private val repeater: ScalingRepeater
) : DigitScaler {

    override fun scale(digits: List<Digit>, scaling: Scaling): List<Digit> =
        digits.map { scale(it, scaling) }
    
    private fun scale(digit: Digit, scaling: Scaling): Digit =
        if (scaling.none()) {
            digit
        }
        else {
            digit.lines
                .map { it.scaleHorizontal(repeater, scaling) }
                .mapIndexed { index, line ->
                    if (index % 2 == 1) repeater.repeat(line, scaling) else listOf(line)
                }
                .flatten()
                .let { digit.scale(it) }
        }
}