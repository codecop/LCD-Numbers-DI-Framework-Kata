package org.codecop.lcdnumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LcdMainTest {

    @Mock
    private ApplicationArguments args;

    @Autowired
    private Main lcdMain;

    @Test
    @ExtendWith(OutputCaptureExtension.class)
    public void lcdAllDigitsOfSize2(CapturedOutput output) throws IOException {
        when(args.getNonOptionArgs()).thenReturn(Arrays.asList("1234567890", "2"));

        lcdMain.run(args);

        assertEquals(Input.join(Input.allDigitsSize2()), output.getOut());
    }

    @Test
    @ExtendWith(OutputCaptureExtension.class)
    public void lcdAllDigitsDefaultSize(CapturedOutput output) throws IOException {
        when(args.getNonOptionArgs()).thenReturn(Arrays.asList("1234567890"));

        lcdMain.run(args);

        assertEquals(Input.join(Input.allDigitsSize1()), output.getOut());
    }
}
