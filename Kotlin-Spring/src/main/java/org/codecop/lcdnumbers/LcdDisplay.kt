package org.codecop.lcdnumbers;

/**
 * Combines Converter, Scaler and Printer.
 */
public interface LcdDisplay {

    String toLcd(int number, Scaling scaling);

}
