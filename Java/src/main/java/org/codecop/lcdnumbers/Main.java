package org.codecop.lcdnumbers;

/**
 * Fake client code. Run this class to see LCD Numbers working:
 * <code>Main 12345 2</code>.
 */
public class Main {

    public static void main(String... args) {
        final LcdDisplay lcdDisplay = new LcdDisplay( //
                new DigitsSplitter(new NumeralSystem(), new DigitFactory(new Patterns())), //
                new DigitScaler(new ScalingRepeater()), //
                new DigitPrinter(new Zipper()));

        int number = Integer.parseInt(args[0]);
        Scaling scaling = args.length > 1 ? Scaling.of(Integer.parseInt(args[1])) : Scaling.NONE;

        System.out.print(lcdDisplay.toLcd(number, scaling));
    }
}
