package com.kamiljurczak.middle_ages_knights.domain.repository;

import com.kamiljurczak.middle_ages_knights.domain.Quest;
import com.kamiljurczak.middle_ages_knights.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public class QuestRepository {

    @PersistenceContext
    private EntityManager em;

    private final static Random random = new Random();

    @Transactional
    public void createQuest(String description) {
        Quest newQuest = new Quest(description);
        em.persist(newQuest);
    }

    public List<Quest> getAllQuests() {
        return em.createQuery("from Quest", Quest.class).getResultList();
    }

    public void deleteQuest(Quest quest) {
        em.remove(quest);
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    @Transactional
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratuj ksiezniczkę");
        descriptions.add("Wez udzial w turnieju");
        descriptions.add("Zabij bande goblinow");
        descriptions.add("Zabij smoka");

        String description = descriptions.get(random.nextInt(descriptions.size()));
        createQuest(description);
    }

    @Transactional
    public void updateQuest(Quest quest) {
        em.merge(quest);
    }

    public Quest getQuest(Integer id) {
        return em.find(Quest.class, id);
    }
}
