package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Scales x and y of digit lines.
 */
public class DigitScaler {

    private final ScalingRepeater repeater;

    public DigitScaler(ScalingRepeater repeater) {
        this.repeater = repeater;
    }

    public List<Digit> scale(List<Digit> digits, Scaling scaling) {
        return digits.stream(). //
                map(d -> scale(d, scaling)). //
                collect(Collectors.toList());
    }

    private Digit scale(Digit digit, Scaling scaling) {
        if (scaling.none()) {
            return digit;
        }

        List<Line> scaled = new ArrayList<>();

        boolean oddLine = true;
        for (Line line : digit.lines()) {
            Line scaledLine = line.scaleHorizontal(repeater, scaling);
            if (oddLine) {
                scaled.add(scaledLine);
            } else {
                scaled.addAll(repeater.repeat(scaledLine, scaling));
            }
            oddLine = !oddLine;
        }

        return digit.scale(scaled);
    }
}
