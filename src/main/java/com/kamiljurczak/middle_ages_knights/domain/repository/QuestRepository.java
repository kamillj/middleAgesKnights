package com.kamiljurczak.middle_ages_knights.domain.repository;

import com.kamiljurczak.middle_ages_knights.domain.Quest;
import com.kamiljurczak.middle_ages_knights.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class QuestRepository {

    private final static Random random = new Random();

    private Map<Integer, Quest> quests = new HashMap<>();

    private void createQuest(String description){
        Integer newId = Ids.getNewId(quests.keySet());
        Quest quest = new Quest(newId, description);
        quests.put(newId, quest);
    }

    public List<Quest> getAllQuests() {
        return new ArrayList<>(quests.values());
    }

    public void deleteQuest(Quest quest){
        quests.remove(quest.getId());
    }

//    @Scheduled(fixedDelay = 1000) //czeka na zakończenie metody
//    @Scheduled(fixedRate = 1000) //zaczyna liczyć od rozpoczęcia wywołania metody
//    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest()
    {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratuj ksiezniczkę");
        descriptions.add("Wez udzial w turnieju");
        descriptions.add("Zabij bande goblinow");
        descriptions.add("Zabij smoka");

        String description = descriptions.get(random.nextInt(descriptions.size()));
        createQuest(description);
    }

    public void updateQuest(Quest quest) {
        quests.put(quest.getId(), quest);
    }

    public Quest getQuest(Integer id) {
        return quests.get(id);
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
