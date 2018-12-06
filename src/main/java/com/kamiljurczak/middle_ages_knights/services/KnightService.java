package com.kamiljurczak.middle_ages_knights.services;

import com.kamiljurczak.middle_ages_knights.domain.Knight;
import com.kamiljurczak.middle_ages_knights.domain.PlayerInformation;
import com.kamiljurczak.middle_ages_knights.domain.repository.KnightRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.PlayerInformationRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    public List<Knight> getAllKnights(){
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void createKnight(Knight knight){
        knightRepository.createKnight(knight);
    }

    public Knight getKnightById(Integer id){
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {
        Predicate<Knight> knightPredicate = knight -> {
            if(knight.getQuest() != null) {
                return knight.getQuest().isCompleted();
            } else {
                return false;
            }
        };
        int sum = knightRepository.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        knightRepository.getAllKnights().stream().filter(knightPredicate)
                .forEach(knight -> knight.setQuest(null));

        return sum;
    }

    @Transactional
    public void getMyGold(){
        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight -> {
            if (knight.getQuest() != null) {
                boolean isCompleted = knight.getQuest().isCompleted();
                if(isCompleted) questRepository.updateQuest(knight.getQuest());
            }
        });

        PlayerInformation playerInformation = playerInformationRepository.getFirst();
        int currentGold = playerInformation.getGold();
        playerInformation.setGold(currentGold + collectRewards());
    }
}
