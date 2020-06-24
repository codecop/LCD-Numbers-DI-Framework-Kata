package org.codecop.lcdnumbers

import java.util.Objects

/**
 * Value Object of an LCD digit.
 */
class Digit private constructor(
    private val digit: Int,
    private val lines: List<Line>
) {
    constructor(digit: Int, patterns: Patterns) : this(digit, patterns.of(digit))
    
    fun lines(): List<Line> {
        return lines
    }
    
    fun scale(scaledLines: List<Line>): Digit {
        val linesCount = lines.size
        val scaledCount = scaledLines.size
        require(scaledCount >= linesCount) { "Scaled lines must be more than original ones: $scaledCount>=$linesCount" }
        return Digit(digit, scaledLines)
    }
    
    override fun toString(): String {
        return digit.toString()
    }
}