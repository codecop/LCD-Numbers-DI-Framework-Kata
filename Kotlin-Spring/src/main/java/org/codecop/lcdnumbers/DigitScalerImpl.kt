package org.codecop.lcdnumbers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.ArrayList
import java.util.Objects

/**
 * Scales x and y of digit lines.
 */
@Service
class DigitScalerImpl : DigitScaler {
    @Autowired
    private lateinit var repeater: ScalingRepeater
    
    override fun scale(digits: List<Digit>, scaling: Scaling): List<Digit> {
        return digits.map { scale(it, scaling) }
    }
    
    private fun scale(digit: Digit, scaling: Scaling): Digit {
        if (scaling.none()) {
            return digit
        }
        
        val scaled = mutableListOf<Line>()
        
        var oddLine = true
        for (line in digit.lines()) {
            val scaledLine = line.scaleHorizontal(repeater, scaling)
            if (oddLine) {
                scaled.add(scaledLine)
            }
            else {
                scaled.addAll(repeater.repeat(scaledLine, scaling))
            }
            oddLine = !oddLine
        }
        return digit.scale(scaled)
    }
}