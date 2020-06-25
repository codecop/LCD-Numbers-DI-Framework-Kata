package org.codecop.lcdnumbers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Splits into digits and converts digits to LCD digits.
 */
@Service
class DigitsSplitterImpl : DigitsSplitter {
    @Autowired
    private lateinit var numeralSystem: NumeralSystem
    
    @Autowired
    private lateinit var digitFactory: DigitFactory
    
    override fun convert(number: Int) =
        numeralSystem.digitsOf(number).map(digitFactory::create)
}