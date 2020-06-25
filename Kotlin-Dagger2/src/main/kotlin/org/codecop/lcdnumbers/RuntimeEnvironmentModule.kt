package org.codecop.lcdnumbers

import dagger.Module
import dagger.Provides
import java.io.PrintWriter

@Module
open class RuntimeEnvironmentModule(private val args: Array<String>) {
    @Provides
    open fun commandLineArguments() = args
    
    @Provides
    open fun provideOutput() = PrintWriter(System.out)
}