package org.codecop.lcdnumbers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Override
    public void run(String... args) {

        if (args.length == 0) {
            return;
        }

        final LcdDisplay lcdDisplay = new LcdDisplay( //
                new DigitsSplitter(new NumeralSystem(), new DigitFactory(new Patterns())), //
                new DigitScaler(new ScalingRepeater()), //
                new DigitPrinter(new Zipper()));

        int number = Integer.parseInt(args[0]);
        Scaling scaling = args.length > 1 ? Scaling.of(Integer.parseInt(args[1])) : Scaling.NONE;

        System.out.print(lcdDisplay.toLcd(number, scaling));
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
