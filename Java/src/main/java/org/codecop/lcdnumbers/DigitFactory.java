package org.codecop.lcdnumbers;

import org.springframework.stereotype.Service;

/**
 * Creates (LCD) digits from patterns.
 */
@Service
public class DigitFactory {

    private final Patterns patterns;

	public DigitFactory(Patterns patterns) {
		this.patterns = patterns;
	}

	public Digit create(int digit) {
        return new Digit(digit, patterns);
    }
}
