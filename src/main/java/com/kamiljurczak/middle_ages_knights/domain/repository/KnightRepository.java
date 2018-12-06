package com.kamiljurczak.middle_ages_knights.domain.repository;

import com.kamiljurczak.middle_ages_knights.domain.Knight;
import org.apache.commons.lang.NotImplementedException;

import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Knight getKnightById(Integer id);

    Optional<Knight> getKnightByName(String name);

    void deleteKnight(Integer id);

    void build();

    void createKnight(Knight knight);

    default void updateKnight(int id, Knight knight) { throw new NotImplementedException(); }
}
