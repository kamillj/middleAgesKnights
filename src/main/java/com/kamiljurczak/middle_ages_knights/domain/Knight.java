package com.kamiljurczak.middle_ages_knights.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Knight {

    private String name;
    private int age;
    private Quest quest;

    public Knight(){
        this.name = "Lancelot";
        this.age = 29;
    }

    public Knight(String name, int age, Quest quest) {
        this.name = name;
        this.age = age;
        this.quest = quest;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Autowired
    public void setQuest(Quest quest){
        System.out.println("Ustawiam zadanie dla rycerza");
        this.quest = quest;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {

        this.age = age;
    }

    public String toString(){
        return name + " (" + age + "). Ma zadnie: " + quest;
    }
}
