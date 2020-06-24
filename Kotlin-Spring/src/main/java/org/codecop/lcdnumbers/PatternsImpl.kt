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
    private val lcdByDigit = mutableMapOf<Int, List<Line>>()
    init {
        put(0, Line(" - "),  //
            Line("| |"),  //
            Line("   "),  //
            Line("| |"),  //
            Line(" - "))
        put(1, Line("   "),  //
            Line("  |"),  //
            Line("   "),  //
            Line("  |"),  //
            Line("   "))
        put(2, Line(" - "),  //
            Line("  |"),  //
            Line(" - "),  //
            Line("|  "),  //
            Line(" - "))
        put(3, Line(" - "),  //
            Line("  |"),  //
            Line(" - "),  //
            Line("  |"),  //
            Line(" - "))
        put(4, Line("   "),  //
            Line("| |"),  //
            Line(" - "),  //
            Line("  |"),  //
            Line("   "))
        put(5, Line(" - "),  //
            Line("|  "),  //
            Line(" - "),  //
            Line("  |"),  //
            Line(" - "))
        put(6, Line(" - "),  //
            Line("|  "),  //
            Line(" - "),  //
            Line("| |"),  //
            Line(" - "))
        put(7, Line(" - "),  //
            Line("  |"),  //
            Line("   "),  //
            Line("  |"),  //
            Line("   "))
        put(8, Line(" - "),  //
            Line("| |"),  //
            Line(" - "),  //
            Line("| |"),  //
            Line(" - "))
        put(9, Line(" - "),  //
            Line("| |"),  //
            Line(" - "),  //
            Line("  |"),  //
            Line(" - "))
    }
    
    private fun put(digit: Int, vararg lines: Line) {
        require(!lcdByDigit.containsKey(digit)) { "duplicate pattern definition for digit $digit" }
        val listOfLines = Collections.unmodifiableList(Arrays.asList(*lines))
        lcdByDigit[digit] = listOfLines
    }
    
    override fun of(digit: Int): List<Line> {
        require(lcdByDigit.containsKey(digit)) { "no pattern defined for digit $digit" }
        return lcdByDigit[digit]!!
    }
}