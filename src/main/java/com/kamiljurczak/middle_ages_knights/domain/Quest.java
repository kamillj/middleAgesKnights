package com.kamiljurczak.middle_ages_knights.domain;

public class Quest {

    private String description;

    private Quest() {}

    public Quest(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return description;
    }
}
