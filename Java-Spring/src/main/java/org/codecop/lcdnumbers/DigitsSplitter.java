package org.codecop.lcdnumbers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * Splits into digits and converts digits to LCD digits.
 */
public class DigitsSplitter {

    private final NumeralSystem numeralSystem;
    private final DigitFactory digitFactory;

    public DigitsSplitter(NumeralSystem numeralSystem, DigitFactory digitFactory) {
        this.numeralSystem = numeralSystem;
        this.digitFactory = digitFactory;
    }

    public List<Digit> convert(int number) {
        List<Integer> numeralDigits = numeralSystem.digitsOf(number);

        return numeralDigits.stream(). //
                map(digitFactory::create). //
                collect(Collectors.toList());
    }
}