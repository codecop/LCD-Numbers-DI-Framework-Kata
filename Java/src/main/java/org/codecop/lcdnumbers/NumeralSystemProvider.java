package org.codecop.lcdnumbers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumeralSystemProvider {

    @Value("${numeral_systen_base}")
    private int base = 10;

    @Bean
    public NumeralSystem createNumeralSystem() {
        return new NumeralSystemImpl(base);
    }
}
