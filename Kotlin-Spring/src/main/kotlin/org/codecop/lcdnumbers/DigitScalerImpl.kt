package org.codecop.lcdnumbers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Scales x and y of digit lines.
 */
@Service
class DigitScalerImpl : DigitScaler {
    @Autowired
    private lateinit var repeater: ScalingRepeater
    
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