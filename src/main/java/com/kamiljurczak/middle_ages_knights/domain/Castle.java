package com.kamiljurczak.middle_ages_knights.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@PropertySource("classpath:castle.properties")
public class Castle {

    @Value("${my.castle.name:East Watch}")
    private String name;

    Knight knight;

    @Autowired
    public Castle(Knight knight) {
        this.knight = knight;
    }

    Castle(Knight knight, String name) {
        this.knight = knight;
        this.name = name;
    }

    @PostConstruct
    public void build(){
        System.out.println("Wybudowano zamek " + name);
    }

    @PreDestroy
    public  void tearDown(){
        System.out.println("Zaraz wyburzymy zamek " + name);
    }

    @Override
    public String toString(){
        return  "Znajduje się tu zamek " + this.name + " zamieszkały przez rycerza " + knight;
    }
}
