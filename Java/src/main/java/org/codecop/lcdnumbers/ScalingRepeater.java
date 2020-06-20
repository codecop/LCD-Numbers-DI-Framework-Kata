package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Repeat objects and characters according to scaling.
 */
public class ScalingRepeater {

    public <T> List<T> repeat(T element, Scaling scaling) {
        Objects.requireNonNull(element);
        Objects.requireNonNull(scaling);

        List<T> elements = new ArrayList<>();
        scaling.times(() -> elements.add(element));
        return elements;
    }

    public String repeat(char aChar, Scaling scaling) {
        Objects.requireNonNull(scaling);

        StringBuilder acc = new StringBuilder();
        scaling.times(() -> acc.append(aChar));
        return acc.toString();
    }
}
