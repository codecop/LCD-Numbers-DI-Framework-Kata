package org.codecop.lcdnumbers;

import java.util.List;
import java.util.Objects;

/**
 * Combines Converter, Scaler and Printer.
 */
public class LcdDisplay {

    private final DigitsSplitter digitsSplitter;
    private final DigitScaler digitScaler;
    private final DigitPrinter digitPrinter;

    public LcdDisplay(DigitsSplitter digitsSplitter, DigitScaler digitScaler, DigitPrinter digitPrinter) {
        Objects.requireNonNull(digitsSplitter);
        Objects.requireNonNull(digitScaler);
        Objects.requireNonNull(digitPrinter);

        this.digitsSplitter = digitsSplitter;
        this.digitScaler = digitScaler;
        this.digitPrinter = digitPrinter;
    }

    public String toLcd(int number, Scaling scaling) {
        Objects.requireNonNull(scaling);

        List<Digit> digits = digitsSplitter.convert(number);
        List<Digit> scaled = digitScaler.scale(digits, scaling);
        return digitPrinter.render(scaled);
    }
}
