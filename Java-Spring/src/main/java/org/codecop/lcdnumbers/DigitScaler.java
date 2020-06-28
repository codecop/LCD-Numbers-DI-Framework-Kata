package org.codecop.lcdnumbers;

import java.util.List;

/**
 * Scales x and y of digit lines.
 */
public interface DigitScaler {

    List<Digit> scale(List<Digit> digits, Scaling scaling);

}
