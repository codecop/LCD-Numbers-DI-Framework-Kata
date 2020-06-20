package org.codecop.lcdnumbers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Run this class to see LCD Numbers working:
 * <code>java -jar target/lcd-numbers-di-framework-kata-1.0.0-SNAPSHOT.jar 12345 2</code>.
 */
@SpringBootApplication
public class Main implements ApplicationRunner {

    @Autowired
    private LcdDisplay lcdDisplay;

    @Override
    public void run(ApplicationArguments args) {

        List<String> nonOptionArgs = args.getNonOptionArgs();
        if (nonOptionArgs.size() == 0) {
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
