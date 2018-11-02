package com.kamiljurczak.middle_ages_knights;

import com.kamiljurczak.middle_ages_knights.domain.Castle;
import com.kamiljurczak.middle_ages_knights.domain.Knight;
import com.kamiljurczak.middle_ages_knights.domain.Quest;
import com.kamiljurczak.middle_ages_knights.domain.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    Castle castle;

    @Autowired
    Tournament tournament;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(castle);
        tournament.duel();
        System.out.println(tournament);
    }
}
