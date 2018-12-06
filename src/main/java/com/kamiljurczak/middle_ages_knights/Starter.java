package com.kamiljurczak.middle_ages_knights;

import com.kamiljurczak.middle_ages_knights.domain.PlayerInformation;
import com.kamiljurczak.middle_ages_knights.domain.repository.KnightRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.PlayerInformationRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.QuestRepository;
import com.kamiljurczak.middle_ages_knights.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival", 32);

        playerInformationRepository.createPlayerInformation(new PlayerInformation());

        questService.assignRandomQuest("Percival");
    }
}
