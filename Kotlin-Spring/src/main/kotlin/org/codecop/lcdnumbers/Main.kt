package org.codecop.lcdnumbers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Main : ApplicationRunner {
    @Autowired
    private lateinit var scalingArgument: ScalingArgument

    @Autowired
    private lateinit var lcdDisplay: LcdDisplay

    override fun run(args: ApplicationArguments) {
        val nonOptionArgs = args.nonOptionArgs
        if (nonOptionArgs.size == 0) {
            println("Run this class to see LCD Numbers working:")
            println("\nRunning the generated jar:");
            println("java -jar build/libs/lcd-numbers-di-framework-kata-1.0.0-SNAPSHOT.jar 12345 2")
            println("\nRunning via Gradle:");
            println("gradlew bootRun -Pargs=12345,2");
            return
        }
        val number = nonOptionArgs[0].toInt()
        print(lcdDisplay.toLcd(number, scalingArgument.scaling))
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Main::class.java, *args)
        }
    }
}