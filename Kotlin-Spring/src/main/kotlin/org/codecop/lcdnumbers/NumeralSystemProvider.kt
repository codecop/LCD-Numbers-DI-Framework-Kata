package org.codecop.lcdnumbers

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class NumeralSystemProvider {
    @Value("\${numeral_system_base}")
    private val base = 0;

    @Bean
    fun createNumeralSystem(): NumeralSystem {
        return NumeralSystemImpl(base)
    }
}