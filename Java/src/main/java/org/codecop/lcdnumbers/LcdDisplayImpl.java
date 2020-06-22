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

    @Autowired
    private DigitsSplitter digitsSplitter;
    @Autowired
    private DigitScaler digitScaler;
    @Autowired
    private DigitPrinter digitPrinter;

    @Override
    public String toLcd(int number, Scaling scaling) {
        Objects.requireNonNull(scaling);

        List<Digit> digits = digitsSplitter.convert(number);
        List<Digit> scaled = digitScaler.scale(digits, scaling);
        return digitPrinter.render(scaled);
    }
}
