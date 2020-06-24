package org.codecop.lcdnumbers

import org.codecop.lcdnumbers.Scaling.Companion.of
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Repository

@Repository
class ScalingArgument {
    // This could be a @Configuration but then I cannot mock the Scaling in Main.
    @Autowired
    private lateinit var args: ApplicationArguments
    
    @get:Bean
    val scaling: Scaling
        get() {
            val nonOptionArgs = args.nonOptionArgs
            return if (nonOptionArgs.size > 1) of(nonOptionArgs[1].toInt()) else Scaling.NONE
        }
}