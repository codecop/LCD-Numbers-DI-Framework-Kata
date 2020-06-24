package org.codecop.lcdnumbers;

import java.util.List;
import java.util.Objects;

/**
 * Value Object of an LCD digit.
 */
public final class Digit {

    private final int digit;
    private final List<Line> lines;

    public Digit(int digit, Patterns patterns) {
        this(digit, patterns.of(digit));
    }

    private Digit(int digit, List<Line> lines) {
        Objects.requireNonNull(lines);

        this.digit = digit;
        this.lines = lines;
    }

    public List<Line> lines() {
        return lines;
    }

    public Digit scale(List<Line> scaledLines) {
        Objects.requireNonNull(scaledLines);

        int linesCount = lines.size();
        int scaledCount = scaledLines.size();
        if (scaledCount < linesCount) {
            throw new IllegalArgumentException("Scaled lines must be more than original ones: " + scaledCount + ">=" + linesCount);
        }

        return new Digit(digit, scaledLines);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Digit)) {
            return false;
        }
        Digit that = (Digit) other;
        return this.digit == that.digit;
    }

    @Override
    public int hashCode() {
        return digit;
    }

    @Override
    public String toString() {
        return Integer.toString(digit);
    }
}
