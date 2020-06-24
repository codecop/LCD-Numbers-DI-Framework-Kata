package org.codecop.lcdnumbers

import org.springframework.stereotype.Service
import java.util.ArrayList
import java.util.Objects

/**
 * Repeat objects and characters according to scaling.
 */
@Service
class ScalingRepeaterImpl : ScalingRepeater {
    override fun <T> repeat(element: T, scaling: Scaling): List<T> {
        Objects.requireNonNull(element)
        Objects.requireNonNull(scaling)
        val elements: MutableList<T> = ArrayList()
        scaling.times(Runnable { elements.add(element) })
        return elements
    }
    
    override fun repeatChar(aChar: Char, scaling: Scaling): String {
        Objects.requireNonNull(scaling)
        val acc = StringBuilder()
        scaling.times(Runnable { acc.append(aChar) })
        return acc.toString()
    }
}