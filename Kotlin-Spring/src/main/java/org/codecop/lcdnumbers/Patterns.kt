package org.codecop.lcdnumbers

/**
 * Knows the initial pattern of each LCD digit.
 */
interface Patterns {
    fun of(digit: Int): List<Line>
}