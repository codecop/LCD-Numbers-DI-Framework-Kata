package org.codecop.lcdnumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.PrintWriter
import java.io.StringWriter

class LcdMainTest {
    val output = StringWriter()
    
    @Test
    fun lcdAllDigitsOfSize2() {
        DaggerMainComponent.builder()
            .runtimeEnvironmentModule(object : RuntimeEnvironmentModule(args = arrayOf("1234567890", "2")) {
                override fun provideOutput(): PrintWriter {
                    return PrintWriter(output, true)
                }
            })
            .build()
            .main()
            .run()
        
        assertEquals(allDigitsSize2().joinLines(), output.toString())
    }
    
    @Test
    fun lcdAllDigitsDefaultSize() {
        DaggerMainComponent.builder()
            .runtimeEnvironmentModule(object : RuntimeEnvironmentModule(args = arrayOf("1234567890")) {
                override fun provideOutput(): PrintWriter {
                    return PrintWriter(output, true)
                }
            })
            .build()
            .main()
            .run()
        
        assertEquals(allDigitsSize1().joinLines(), output.toString())
    }
}