package org.codecop.lcdnumbers

import javax.inject.Inject

/**
 * Repeat objects and characters according to scaling.
 */
class ScalingRepeaterImpl @Inject constructor() : ScalingRepeater {
    override fun <T> repeat(element: T, scaling: Scaling): List<T> {
        val elements = mutableListOf<T>()
        scaling.times { elements.add(element) }
        return elements
    }
    
    override fun repeatChar(aChar: Char, scaling: Scaling): String {
        val acc = StringBuilder()
        scaling.times { acc.append(aChar) }
        return acc.toString()
    }
}