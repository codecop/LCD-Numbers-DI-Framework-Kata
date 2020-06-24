package org.codecop.lcdnumbers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Objects

/**
 * Appends lines next to each other and adds line breaks.
 */
@Service
class DigitPrinterImpl : DigitPrinter {
    @Autowired
    private lateinit var zipper: Zipper
    
    override fun render(digits: List<Digit>): String {
        Objects.requireNonNull(digits)
        val linesOfAllDigits = linesOfAllDigits(digits)
        val linesSideBySide = zip(linesOfAllDigits)
        return join(linesSideBySide)
    }
    
    private fun linesOfAllDigits(digits: List<Digit>): List<List<Line>> {
        return digits.map { it.lines() }
    }
    
    private fun zip(linesOfAllDigits: List<List<Line>>): List<String> {
        return zipper.zip(linesOfAllDigits) { concat(it) }
    }
    
    private fun concat(lines: List<Line>): String {
        return lines.joinToString(separator = "") { it.toString() }
    }
    
    private fun join(lines: List<String>): String {
        return lines.joinToString(separator = NEWLINE, prefix = "", postfix = NEWLINE)
    }
    
    companion object {
        private const val NEWLINE = "\n"
    }
}