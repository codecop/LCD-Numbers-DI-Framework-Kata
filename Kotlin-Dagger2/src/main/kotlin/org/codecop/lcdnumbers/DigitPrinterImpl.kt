package org.codecop.lcdnumbers

import javax.inject.Inject

/**
 * Appends lines next to each other and adds line breaks.
 */
class DigitPrinterImpl @Inject constructor(private val zipper: Zipper) : DigitPrinter {
    
    override fun render(digits: List<Digit>): String {
        val linesOfAllDigits = linesOfAllDigits(digits)
        val linesSideBySide = zip(linesOfAllDigits)
        return join(linesSideBySide)
    }
    
    private fun linesOfAllDigits(digits: List<Digit>): List<List<Line>> {
        return digits.map { it.lines }
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