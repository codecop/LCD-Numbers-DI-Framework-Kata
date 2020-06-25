package org.codecop.lcdnumbers

import java.io.PrintWriter
import javax.inject.Inject

class Main @Inject constructor(
    private val args: CommandLineArguments,
    private val lcdDisplay: LcdDisplay,
    private val out : PrintWriter
) {
    fun run() {
        if (args.isHelpRequired()) {
            println("Run this class to see LCD Numbers working:")
            println("java -jar lcd-numbers-di-framework-kata.jar 12345 2")
            return
        }
        
        out.print(lcdDisplay.toLcd(args.numberToDisplay, this.args.scaling))
        out.flush()
    }
    
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            DaggerMainComponent.builder()
                .runtimeEnvironmentModule(RuntimeEnvironmentModule(args))
                .build()
                .main()
                .run()
        }
    }
}

