package com.kamiljurczak.middle_ages_knights.domain;

public class Quest {

    private String description;

    public Quest() {
        this.description = "Uratuj księżniczkę";
    }

    @Override
    public String toString(){
        return description;
    }
}
