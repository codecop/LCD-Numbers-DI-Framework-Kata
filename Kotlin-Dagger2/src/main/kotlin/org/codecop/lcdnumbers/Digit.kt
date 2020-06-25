package org.codecop.lcdnumbers

/**
 * Value Object of an LCD digit.
 */
class Digit private constructor(
    private val digit: Int,
    val lines: List<Line>
) {
    constructor(digit: Int, patterns: Patterns) : this(digit, patterns.of(digit))
    
    fun scale(scaledLines: List<Line>): Digit {
        val linesCount = lines.size
        val scaledCount = scaledLines.size
        require(scaledCount >= linesCount) { "Scaled lines must be more than original ones: $scaledCount>=$linesCount" }
        return Digit(digit, scaledLines)
    }
    
    override fun toString() = digit.toString()
}