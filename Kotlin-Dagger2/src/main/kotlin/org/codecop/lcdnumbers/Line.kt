package org.codecop.lcdnumbers

/**
 * Value Object of an LCD digit line.
 */
data class Line(private val line: String) {
    fun scaleHorizontal(repeater: ScalingRepeater, scaling: Scaling): Line {
        val chars = line.toCharArray()
        return Line(chars[0] + repeater.repeatChar(chars[1], scaling) + chars[2])
    }
    
    override fun toString() = line
}