package org.codecop.lcdnumbers

class CommandLineArguments(private val args: Array<String>) {
    fun isHelpRequired() = args.isEmpty()
    
    val numberToDisplay: Int
        get() = args[0].toInt()
    
    val scaling: Scaling
        get() = if (args.size > 1) Scaling.of(args[1].toInt()) else Scaling.NONE
}
