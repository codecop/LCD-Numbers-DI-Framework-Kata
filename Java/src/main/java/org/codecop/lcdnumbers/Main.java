package org.codecop.lcdnumbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Run this class to see LCD Numbers working:
 * <code>java -jar target/lcd-numbers-di-framework-kata-1.0.0-SNAPSHOT.jar 12345 2</code>.
 */
@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private LcdDisplay lcdDisplay;

    @Override
    public void run(String... args) {

        if (args.length == 0) {
            return;
        }

        int number = Integer.parseInt(args[0]);
        Scaling scaling = args.length > 1 ? Scaling.of(Integer.parseInt(args[1])) : Scaling.NONE;

        System.out.print(lcdDisplay.toLcd(number, scaling));
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
