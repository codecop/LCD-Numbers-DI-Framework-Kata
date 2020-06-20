package org.codecop.lcdnumbers;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements ApplicationRunner {

    private final LcdDisplay lcdDisplay;

	public Main(LcdDisplay lcdDisplay) {
		this.lcdDisplay = lcdDisplay;
	}

	@Override
    public void run(ApplicationArguments args) {

        List<String> nonOptionArgs = args.getNonOptionArgs();
        if (nonOptionArgs.size() == 0) {
            System.out.println("Run this class to see LCD Numbers working:");
            System.out.println("java -jar lcd-numbers-di-framework-kata.jar 12345 2");
            return;
        }

        int number = Integer.parseInt(nonOptionArgs.get(0));
        Scaling scaling = nonOptionArgs.size() > 1 ? Scaling.of(Integer.parseInt(nonOptionArgs.get(1))) : Scaling.NONE;

        System.out.print(lcdDisplay.toLcd(number, scaling));
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
