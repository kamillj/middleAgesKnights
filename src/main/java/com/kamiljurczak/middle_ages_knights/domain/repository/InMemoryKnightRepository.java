package com.kamiljurczak.middle_ages_knights.domain.repository;

import com.kamiljurczak.middle_ages_knights.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.*;

public class InMemoryKnightRepository implements KnightRepository {

    private Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryKnightRepository() {
    }

    @Override
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);
        knight.setId(getNewId());
        knights.put(knight.getId(), knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }

    @Override
    public Optional<Knight> getKnightByName(String name) {
        Optional<Knight> knightByName = knights.values().stream().filter(knight -> knight.getName().equals(name)).findAny();
        return knightByName;
    }

    @Override
    public void deleteKnight(Integer id) {
        knights.remove(id);
    }

    @Override
    public void createKnight(Knight knight) {
        knights.put(knight.getId(), knight);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }


    @Override
    public String toString() {
        return "InMemoryKnightRepository{" +
                "knights=" + knights +
                '}';
    }

    public int getNewId() {
        if(knights.isEmpty()) return 0;
        else return knights.keySet().stream().max(Integer::max).get() + 1;
    }
}
