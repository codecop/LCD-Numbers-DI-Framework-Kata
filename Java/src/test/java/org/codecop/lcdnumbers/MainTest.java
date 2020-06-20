package org.codecop.lcdnumbers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

public class MainTest {

	@Mock
	private LcdDisplay lcdDisplay;

	private Main main;

	@BeforeEach
	void setup() {
		this.lcdDisplay = mock(LcdDisplay.class);
		this.main = new Main(lcdDisplay);
	}

	@Test
	void runWhenShowingAllDigitsAtSize2() {
		this.main.run(new DefaultApplicationArguments("1234567890", "2"));
		verify(lcdDisplay).toLcd(1234567890, Scaling.TWO);
	}

	@Test
	void runWhenShowingAllDigitsAtDefaultSize() {
		this.main.run(new DefaultApplicationArguments("1234567890"));
		verify(lcdDisplay).toLcd(1234567890, Scaling.NONE);
	}

	@Test
	@ExtendWith(OutputCaptureExtension.class)
	void runPrintsLcdOutput(CapturedOutput output) {
		given(this.lcdDisplay.toLcd(123, Scaling.NONE)).willReturn("OUTPUT123");
		this.main.run(new DefaultApplicationArguments("123"));
		assertThat(output).contains("OUTPUT123");
	}

}
