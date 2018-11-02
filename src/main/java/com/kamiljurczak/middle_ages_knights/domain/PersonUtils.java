package com.kamiljurczak.middle_ages_knights.domain;

public class PersonUtils {

    private static PersonUtils inctance = null;

    private PersonUtils(){

    }

    public PersonUtils getInstance(){
        if(inctance == null) {
            inctance = new PersonUtils();
        }
        return inctance;
    }

    public static final String operacja(Person person){
        return person.name.toUpperCase();
    }
}
