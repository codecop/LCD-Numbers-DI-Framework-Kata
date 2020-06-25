package org.codecop.lcdnumbers

import javax.inject.Inject

/**
 * Creates (LCD) digits from patterns.
 */
class DigitFactoryImpl @Inject constructor(private val patterns: Patterns) : DigitFactory {
    override fun create(digit: Int) = Digit(digit, patterns)
}