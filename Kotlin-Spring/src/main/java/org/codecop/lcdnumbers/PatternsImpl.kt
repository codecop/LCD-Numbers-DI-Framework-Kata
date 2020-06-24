package org.codecop.lcdnumbers

import org.springframework.stereotype.Repository
import java.util.Arrays
import java.util.Collections
import java.util.HashMap

/**
 * Knows the initial pattern of each LCD digit.
 */
@Repository
class PatternsImpl : Patterns {
    private val lcdByDigit = mutableMapOf(
        0 to listOf(
            Line(" - "),
            Line("| |"),
            Line("   "),
            Line("| |"),
            Line(" - ")),
        1 to listOf(
            Line("   "),
            Line("  |"),
            Line("   "),
            Line("  |"),
            Line("   ")),
        2 to listOf(
            Line(" - "),
            Line("  |"),
            Line(" - "),
            Line("|  "),
            Line(" - ")),
        3 to listOf(
            Line(" - "),
            Line("  |"),
            Line(" - "),
            Line("  |"),
            Line(" - ")),
        4 to listOf(
            Line("   "),
            Line("| |"),
            Line(" - "),
            Line("  |"),
            Line("   ")),
        5 to listOf(
            Line(" - "),
            Line("|  "),
            Line(" - "),
            Line("  |"),
            Line(" - ")),
        6 to listOf(
            Line(" - "),
            Line("|  "),
            Line(" - "),
            Line("| |"),
            Line(" - ")),
        7 to listOf(
            Line(" - "),
            Line("  |"),
            Line("   "),
            Line("  |"),
            Line("   ")),
        8 to listOf(
            Line(" - "),
            Line("| |"),
            Line(" - "),
            Line("| |"),
            Line(" - ")),
        9 to listOf(
            Line(" - "),
            Line("| |"),
            Line(" - "),
            Line("  |"),
            Line(" - ")))
    
    override fun of(digit: Int): List<Line> =
        lcdByDigit.getValue(digit)
}
