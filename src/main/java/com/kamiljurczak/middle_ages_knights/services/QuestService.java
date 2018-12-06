package com.kamiljurczak.middle_ages_knights.services;

import com.kamiljurczak.middle_ages_knights.domain.Quest;
import com.kamiljurczak.middle_ages_knights.domain.repository.KnightRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    QuestRepository questRepository;

    private final static Random random = new Random();

    public void assignRandomQuest(String knightName){
        List<Quest> allQuests = questRepository.getAllQuests();
        Quest randomQuest = allQuests.get(random.nextInt(allQuests.size()));
        knightRepository.getKnightByName(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
//        questRepository.deleteQuest(randomQuest);
    }

    public List<Quest> getAllNotStartedQuests() {
        return questRepository.getAllQuests().stream().filter(quest -> !quest.isStarted()).collect(Collectors.toList());
    }

    @Autowired
    public void setQuestRepository(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public void updateQuest(Quest quest) {
        questRepository.updateQuest(quest);
    }

    public boolean isQuestCompleted(Quest quest){
        return quest.isCompleted();
    }
}
