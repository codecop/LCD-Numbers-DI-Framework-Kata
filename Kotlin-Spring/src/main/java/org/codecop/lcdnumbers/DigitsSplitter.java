package org.codecop.lcdnumbers;

import java.util.List;

/**
 * Splits into digits and converts digits to LCD digits.
 */
public interface DigitsSplitter {

    List<Digit> convert(int number);

}
