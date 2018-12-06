package com.kamiljurczak.middle_ages_knights.domain.repository;

import com.kamiljurczak.middle_ages_knights.domain.PlayerInformation;
import com.kamiljurczak.middle_ages_knights.domain.Quest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class PlayerInformationRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createPlayerInformation(PlayerInformation playerInformation) {

        PlayerInformation playerInf = new PlayerInformation();

        em.persist(playerInf);
    }

    public PlayerInformation getFirst() {
        return em.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }
}
