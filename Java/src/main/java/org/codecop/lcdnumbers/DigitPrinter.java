package org.codecop.lcdnumbers;

import java.util.List;

/**
 * Appends lines next to each other and adds line breaks.
 */
public interface DigitPrinter {

    String render(List<Digit> digits);

}
