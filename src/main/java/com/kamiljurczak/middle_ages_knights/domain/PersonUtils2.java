package com.kamiljurczak.middle_ages_knights.domain;

public enum PersonUtils2 {

    INSTANCE;

    public static final String operacja(Person person){
        return person.name.toUpperCase();
    }
}
