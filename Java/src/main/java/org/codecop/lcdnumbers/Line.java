package org.codecop.lcdnumbers;

import java.util.Objects;

/**
 * Value Object of an LCD digit line.
 */
public final class Line {

    private final String line;

    public Line(String line) {
        this.line = line;
    }

    public Line scaleHorizontal(ScalingRepeater repeater, Scaling scaling) {
        char[] chars = line.toCharArray();
        return new Line(chars[0] + repeater.repeat(chars[1], scaling) + chars[2]);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Line)) {
            return false;
        }
        Line that = (Line) other;
        return this.line.equals(that.line);
    }

    @Override
    public int hashCode() {
        return line.hashCode();
    }

    @Override
    public String toString() {
        return line;
    }
}
