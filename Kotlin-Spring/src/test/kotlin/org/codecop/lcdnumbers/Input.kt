package org.codecop.lcdnumbers

/**
 * Shortcut methods to get input test data.
 */

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors


fun allDigitsSize1(): List<String> {
    return read("numbers grid 3x5 - size 1.txt")
}

fun allDigitsSize2(): List<String> {
    return read("numbers grid 4x7 - size 2.txt")
}

fun allDigitsSize3(): List<String> {
    return read("numbers grid 5x9 - size 3.txt")
}

private fun read(fileName: String): List<String> {
    return Files.readAllLines(Paths.get("src/test/resources", fileName))
}

fun List<String>.joinLines() = joinToString("\n", postfix = "\n")