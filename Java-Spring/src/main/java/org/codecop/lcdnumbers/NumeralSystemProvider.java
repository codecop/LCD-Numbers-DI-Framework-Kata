package org.codecop.lcdnumbers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumeralSystemProvider {

    @Value("${numeral_system_base}")
    private int base;

    @Bean
    public NumeralSystem createNumeralSystem() {
        return new NumeralSystemImpl(base);
    }
}
