package org.codecop.lcdnumbers;

import java.util.List;

/**
 * Splits a number into its digits according to its numeral system, e.g. Decimal System.
 */
public interface NumeralSystem {

    List<Integer> digitsOf(int value);

}
