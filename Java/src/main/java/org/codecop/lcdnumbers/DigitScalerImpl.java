package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Scales x and y of digit lines.
 */
@Service
public class DigitScalerImpl implements DigitScaler {

    @Autowired
    private ScalingRepeater repeater;

    @Override
    public List<Digit> scale(List<Digit> digits, Scaling scaling) {
        Objects.requireNonNull(digits);
        Objects.requireNonNull(scaling);

        return digits.stream(). //
                map(d -> scale(d, scaling)). //
                collect(Collectors.toList());
    }

    private Digit scale(Digit digit, Scaling scaling) {
        Objects.requireNonNull(digit);
        Objects.requireNonNull(scaling);

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
