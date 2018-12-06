package com.kamiljurczak.middle_ages_knights.config;

import com.kamiljurczak.middle_ages_knights.domain.repository.DBKnightRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.InMemoryKnightRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
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

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("kamil").password("pw").roles("USER")
                .and()
                .withUser("admin").password("pw").roles("ADMIN");
    }
}
