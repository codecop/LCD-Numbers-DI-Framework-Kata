package org.codecop.lcdnumbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Creates (LCD) digits from patterns.
 */
@Service
public class DigitFactoryImpl implements DigitFactory {

    private final Patterns patterns;

    public DigitFactoryImpl(Patterns patterns) {
        this.patterns = patterns;
    }

    @Override
    public Digit create(int digit) {
        return new Digit(digit, patterns);
    }
}
