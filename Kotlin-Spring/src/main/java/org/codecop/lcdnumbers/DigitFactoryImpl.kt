package org.codecop.lcdnumbers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Creates (LCD) digits from patterns.
 */
@Service
class DigitFactoryImpl : DigitFactory {
    @Autowired
    private lateinit var patterns: Patterns
    
    override fun create(digit: Int) = Digit(digit, patterns)
}