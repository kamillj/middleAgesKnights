package com.kamiljurczak.middle_ages_knights;

import com.kamiljurczak.middle_ages_knights.domain.PlayerInformation;
import com.kamiljurczak.middle_ages_knights.domain.repository.KnightRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.PlayerInformationRepository;
import com.kamiljurczak.middle_ages_knights.domain.repository.QuestRepository;
import com.kamiljurczak.middle_ages_knights.services.QuestService;
import com.kamiljurczak.middle_ages_knights.utils.Role;
import com.kamiljurczak.middle_ages_knights.utils.RoleRepository;
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

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival", 32);

        playerInformationRepository.createPlayerInformation(new PlayerInformation("kamil", "pw"));
        playerInformationRepository.createPlayerInformation(new PlayerInformation("admin", "pw"));

        Role kamilRoleUSER = new Role("kamil", "USER");
        Role adminRoleUSER = new Role("admin", "USER");
        Role adminRoleADMIN = new Role("admin", "ADMIN");

        roleRepository.persistRole(kamilRoleUSER);
        roleRepository.persistRole(adminRoleUSER);
        roleRepository.persistRole(adminRoleADMIN);

        questService.assignRandomQuest("Percival");
    }
}
