package com.kamiljurczak.middle_ages_knights.config;

import com.kamiljurczak.middle_ages_knights.domain.repository.DBKnightRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.InMemoryKnightRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.KnightRepository;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig {

    @Bean(name = "inMemoryKnightRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo(){
        return new InMemoryKnightRepository();
    }

    @Bean(name = "dbKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo(){
        return new DBKnightRepository();
    }
}
