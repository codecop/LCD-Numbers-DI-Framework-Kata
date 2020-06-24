package org.codecop.lcdnumbers

import java.util.Objects

/**
 * The scale factor value.
 */
data class Scaling(private val times: Int) {
    init {
        require(times > 0) { "scaling factor must be >= 1" }
    }
    
    fun none(): Boolean {
        return times == 1
    }
    
    fun times(block: () -> Unit) {
        Objects.requireNonNull(block)
        for (i in 0 until times) {
            block()
        }
    }
    
    override fun toString() = times.toString()
    
    companion object {
        val NONE = Scaling(1)
        val TWO = Scaling(2)
        
        fun of(t: Int): Scaling {
            return Scaling(t)
        }
    }
}