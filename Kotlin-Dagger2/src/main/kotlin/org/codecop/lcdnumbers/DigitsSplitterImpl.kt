package org.codecop.lcdnumbers

import javax.inject.Inject

/**
 * Splits into digits and converts digits to LCD digits.
 */
class DigitsSplitterImpl @Inject constructor(
    private val numeralSystem: NumeralSystem,
    private val digitFactory: DigitFactory
) : DigitsSplitter {

    override fun convert(number: Int) =
        numeralSystem.digitsOf(number).map(digitFactory::create)

}