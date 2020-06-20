package org.codecop.lcdnumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LcdMainTest {

    @Autowired
    private Main lcdMain;

    @Test
    @ExtendWith(OutputCaptureExtension.class)
    public void lcdAllDigitsOfSize2(CapturedOutput output) throws IOException {
        lcdMain.run("1234567890", "2");

        assertEquals(Input.join(Input.allDigitsSize2()), output.getOut());
    }
}
