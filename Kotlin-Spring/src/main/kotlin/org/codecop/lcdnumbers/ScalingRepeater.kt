package org.codecop.lcdnumbers

/**
 * Repeat objects and characters according to scaling.
 */
interface ScalingRepeater {
    fun <T> repeat(element: T, scaling: Scaling): List<T>
    fun repeatChar(aChar: Char, scaling: Scaling): String
}