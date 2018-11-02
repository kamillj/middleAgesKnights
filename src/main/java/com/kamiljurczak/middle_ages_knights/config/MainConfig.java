package com.kamiljurczak.middle_ages_knights.config;

import com.kamiljurczak.middle_ages_knights.domain.Castle;
import com.kamiljurczak.middle_ages_knights.domain.Knight;
import com.kamiljurczak.middle_ages_knights.domain.Quest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ImportResource("classpath:config/castle-config.xml")
@PropertySource("classpath:castle.properties")
public class MainConfig {

//    @Value("${my.castle.name}")
//    String name;

    @Bean
    public Quest createQuest(){
        return new Quest();
    }

    @Bean
    public Knight knight(){
        Knight knight = new Knight("Lancelot", 29);
        knight.setQuest(createQuest());
        return knight;
    }

    @Bean(name="zamek", initMethod = "build", destroyMethod = "tearDown")
    @Value("${my.castle.name}")
    public Castle castle(String name){
        Castle castle = new Castle(knight());
        castle.setName(name);
        return castle;
    }
}
