package org.codecop.lcdnumbers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Shortcut methods to get input test data.
 */
public class Input {

    public static List<String> allDigitsSize1() throws IOException {
        return read("numbers grid 3x5 - size 1.txt");
    }

    public static List<String> allDigitsSize2() throws IOException {
        return read("numbers grid 4x7 - size 2.txt");
    }

    public static List<String> allDigitsSize3() throws IOException {
        return read("numbers grid 5x9 - size 3.txt");
    }

    private static List<String> read(String fileName) throws IOException {
        return Files.readAllLines(Paths.get("src/test/resources", fileName));
    }

    public static String join(List<String> lines) {
        return lines.stream().collect(Collectors.joining("\n")) + "\n";
    }

}
