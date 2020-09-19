package org.codecop.lcdnumbers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Combines Converter, Scaler and Printer.
 */
@Service
public class LcdDisplayImpl implements LcdDisplay {

    private final DigitsSplitter digitsSplitter;
    private final DigitScaler digitScaler;
    private final DigitPrinter digitPrinter;

    public LcdDisplayImpl(DigitsSplitter digitsSplitter, DigitScaler digitScaler, DigitPrinter digitPrinter) {
        this.digitsSplitter = digitsSplitter;
        this.digitScaler = digitScaler;
        this.digitPrinter = digitPrinter;
    }

    @Override
    public String toLcd(int number, Scaling scaling) {
        List<Digit> digits = digitsSplitter.convert(number);
        List<Digit> scaled = digitScaler.scale(digits, scaling);
        return digitPrinter.render(scaled);
    }
}
