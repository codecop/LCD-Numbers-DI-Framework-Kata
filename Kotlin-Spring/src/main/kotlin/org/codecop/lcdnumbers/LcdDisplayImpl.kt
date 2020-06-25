package org.codecop.lcdnumbers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Objects

/**
 * Combines Converter, Scaler and Printer.
 */
@Service
class LcdDisplayImpl : LcdDisplay {
    @Autowired
    private lateinit var digitsSplitter: DigitsSplitter
    
    @Autowired
    private lateinit var digitScaler: DigitScaler
    
    @Autowired
    private lateinit var digitPrinter: DigitPrinter
    
    override fun toLcd(number: Int, scaling: Scaling): String {
        val digits = digitsSplitter.convert(number)
        val scaled = digitScaler.scale(digits, scaling)
        return digitPrinter.render(scaled)
    }
}