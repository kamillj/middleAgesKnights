package com.kamiljurczak.middle_ages_knights.domain.repository;

import com.kamiljurczak.middle_ages_knights.domain.Knight;
import jdk.jshell.spi.ExecutionControl;

import javax.annotation.PostConstruct;
import java.util.Collection;

public interface KnightRepository {

    void createKnight(String name, int age) throws ExecutionControl.NotImplementedException;

    Collection<Knight> getAllKnights();

    Knight getKnight(String name);

    void deleteKnight(String name);

    void build();
}
