package com.kamiljurczak.middle_ages_knights.config;

import com.kamiljurczak.middle_ages_knights.domain.Knight;
import com.kamiljurczak.middle_ages_knights.domain.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
//@ImportResource("classpath:config/castle-config.xml")
public class MainConfig {

//    @Value("${my.castle.name}")
//    String name;

//    @Autowired
//    Quest quest;
//
//    @Bean
//    @Scope("prototype")
//    public Knight knight(){
//        Knight knight = new Knight("Lancelot", 29);
//        knight.setQuest(createQuest());
//        return knight;
//    }
}
