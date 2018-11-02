package com.kamiljurczak.middle_ages_knights.services;

import com.kamiljurczak.middle_ages_knights.domain.Knight;
import com.kamiljurczak.middle_ages_knights.domain.Quest;
import com.kamiljurczak.middle_ages_knights.domain.repository.KnightRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    private final static Random random = new Random();

    public void assignRandomQuest(String knightName){
        List<Quest> allQuests = questRepository.getAllQuests();
        Quest randomQuest = allQuests.get(random.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).setQuest(randomQuest);
        questRepository.deleteQuest(randomQuest);
    }
}
