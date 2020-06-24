package org.codecop.lcdnumbers

import java.util.Objects

/**
 * The scale factor value.
 */
data class Scaling(private val times: Int) {
    
    fun none(): Boolean {
        return times == 1
    }
    
    fun times(block: Runnable) {
        Objects.requireNonNull(block)
        for (i in 0 until times) {
            block.run()
        }
    }
    
    override fun toString(): String {
        return times.toString()
    }
    
    companion object {
        @JvmField
        val NONE = Scaling(1)
    
        @JvmField
        val TWO = Scaling(2)
        
        @JvmStatic
        fun of(t: Int): Scaling {
            return Scaling(t)
        }
    }
    
    init {
        require(times > 0) { "scaling factor must be >= 1" }
    }
}