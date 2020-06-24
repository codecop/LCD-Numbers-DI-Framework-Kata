package org.codecop.lcdnumbers;

import java.util.List;

/**
 * Repeat objects and characters according to scaling.
 */
public interface ScalingRepeater {

    <T> List<T> repeat(T element, Scaling scaling);

    String repeat(char aChar, Scaling scaling);

}
