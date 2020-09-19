package org.codecop.lcdnumbers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class ScalingArgument {
    // This could be a @Configuration but then I cannot mock the Scaling in Main.

    private final ApplicationArguments args;

    public ScalingArgument(ApplicationArguments args) {
        this.args = args;
    }

    @Bean
    public Scaling getScaling() {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        Scaling scaling = nonOptionArgs.size() > 1 ? Scaling.of(Integer.parseInt(nonOptionArgs.get(1))) : Scaling.NONE;
        return scaling;
    }
}
