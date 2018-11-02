package com.kamiljurczak.middle_ages_knights.domain.repository;

import com.kamiljurczak.middle_ages_knights.domain.Quest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRepository {

    final static Random random = new Random();

    List<Quest> quests = new ArrayList<>();

    public void createQuest(String description){
        quests.add(new Quest(description));
    }

    public List<Quest> getAllQuests() {
        return quests;
    }

    public void deleteQuest(Quest quest){
        quests.remove(quest);
    }

//    @Scheduled(fixedDelay = 1000) //czeka na zakończenie metody
//    @Scheduled(fixedRate = 1000) //zaczyna liczyć od rozpoczęcia wywołania metody
//    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest()
    {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratuj księżniczkę");
        descriptions.add("Weź udział w turnieju");
        descriptions.add("Zabij bandę goblinów");
        descriptions.add("Zabij smoka");

        String description = descriptions.get(random.nextInt(descriptions.size()));
        System.out.println("Utworzyłem zadanie o opisie: " + description);
        createQuest(description);
    }

    @PostConstruct
    public void init(){
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "quests=" + quests +
                '}';
    }
}
