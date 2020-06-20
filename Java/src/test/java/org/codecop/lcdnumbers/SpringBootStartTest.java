package org.codecop.lcdnumbers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(args = { "1234567890", "2" })
@ExtendWith(OutputCaptureExtension.class)
public class SpringBootStartTest {

    @Test
    public void lcdAllDigitsOfSize2(CapturedOutput output) throws IOException {
        assertThat(output.getOut(), endsWith(Input.join(Input.allDigitsSize2())));
    }
}
