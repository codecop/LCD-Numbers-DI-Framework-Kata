package org.codecop.lcdnumbers;

import java.util.List;

/**
 * Combines Converter, Scaler and Printer.
 */
public class LcdDisplay {

    private final DigitsSplitter digitsSplitter;
    private final DigitScaler digitScaler;
    private final DigitPrinter digitPrinter;

    public LcdDisplay(DigitsSplitter digitsSplitter, DigitScaler digitScaler, DigitPrinter digitPrinter) {
        this.digitsSplitter = digitsSplitter;
        this.digitScaler = digitScaler;
        this.digitPrinter = digitPrinter;
    }

    public String toLcd(int number, Scaling scaling) {
        List<Digit> digits = digitsSplitter.convert(number);
        List<Digit> scaled = digitScaler.scale(digits, scaling);
        return digitPrinter.render(scaled);
    }
}
