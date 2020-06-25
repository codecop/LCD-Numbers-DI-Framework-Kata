package org.codecop.lcdnumbers

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.system.CapturedOutput
import org.springframework.boot.test.system.OutputCaptureExtension

@SpringBootTest(args = ["1234567890", "2"])
@ExtendWith(OutputCaptureExtension::class)
class SpringBootStartTest {
    @Test
    fun lcdAllDigitsOfSize2(output: CapturedOutput) {
        MatcherAssert.assertThat(output.out, Matchers.endsWith(allDigitsSize2().joinLines()))
    }
}