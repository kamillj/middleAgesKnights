package com.kamiljurczak.middle_ages_knights.config;

import com.kamiljurczak.middle_ages_knights.domain.Knight;
import com.kamiljurczak.middle_ages_knights.domain.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
//@ImportResource("classpath:config/castle-config.xml")
public class MainConfig {

    @Value("${my.castle.name}")
    String name;

    @Autowired
    Quest quest;

    @Bean(name = "lancelot")
    @Primary
    public Knight lancelot(){
        Knight lancelot = new Knight("Lancelot", 29);
        lancelot.setQuest(quest);
        return lancelot;
    }

    @Bean(name = "percival")
    public Knight createKnightBean(){
        Knight percival = new Knight("Percival", 25);
        percival.setQuest(quest);
        return percival;
    }
}
