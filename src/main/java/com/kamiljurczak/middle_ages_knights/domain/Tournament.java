package com.kamiljurczak.middle_ages_knights.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Tournament {

    @Autowired
    private Map<String, Knight> knights;

    public Tournament() {
    }

    public void duel(){
//        knight.setAge(knight.getAge() + 1);
    }

    public void setKnights(Map<String, Knight> knights) {
        this.knights = knights;
    }

    public Map<String, Knight> getKnights() {
        return knights;
    }

    @Override
    public String toString(){
        return "W turnieju bierze udział rycerze " + knights.toString();
    }
}
