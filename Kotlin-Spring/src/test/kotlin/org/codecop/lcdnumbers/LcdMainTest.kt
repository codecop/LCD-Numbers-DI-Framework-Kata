package org.codecop.lcdnumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.system.CapturedOutput
import org.springframework.boot.test.system.OutputCaptureExtension
import java.util.Arrays

@SpringBootTest
class LcdMainTest {
    @MockBean
    private lateinit var args: ApplicationArguments
    
    @Autowired
    private lateinit var lcdMain: Main
    
    @Test
    @ExtendWith(OutputCaptureExtension::class)
    fun lcdAllDigitsOfSize2(output: CapturedOutput) {
        Mockito.`when`(args.nonOptionArgs).thenReturn(Arrays.asList("1234567890", "2"))
        
        lcdMain.run(args)
        
        assertEquals(allDigitsSize2().joinLines(), output.out)
    }
    
    @Test
    @ExtendWith(OutputCaptureExtension::class)
    fun lcdAllDigitsDefaultSize(output: CapturedOutput) {
        Mockito.`when`(args.nonOptionArgs).thenReturn(Arrays.asList("1234567890"))
        
        lcdMain.run(args)
        
        assertEquals(allDigitsSize1().joinLines(), output.out)
    }
}