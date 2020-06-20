package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Splits a number into its digits according to its numeral system, e.g. Decimal System.
 */
public class NumeralSystem {

    private final int base;

    public NumeralSystem() {
        this(10);
    }

    public NumeralSystem(int base) {
        if (base < 2) {
            throw new IllegalArgumentException("Smallest base is binary; base=" + base);
        }

        this.base = base;
    }

    public List<Integer> digitsOf(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("negative number " + value);
        }

        List<Integer> digits = new ArrayList<>();

        int remainder = value;
        while (remainder > 0) {
            digits.add(remainder % base);
            remainder /= base;
        }
        Collections.reverse(digits);

        return digits;
    }
}