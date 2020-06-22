package org.codecop.lcdnumbers;

import java.util.List;

/**
 * Knows the initial pattern of each LCD digit.
 */
public interface Patterns {

    List<Line> of(int digit);

}
