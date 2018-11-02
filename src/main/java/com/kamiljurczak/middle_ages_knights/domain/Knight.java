package com.kamiljurczak.middle_ages_knights.domain;


public class Knight {

    private String name;
    private int age;
    private Quest quest;

    public Knight(){
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setQuest(Quest quest){
        System.out.println("Ustawiam zadanie dla rycerza");
        this.quest = quest;
    }

    public String toString(){
        return name + " (" + age + "). Ma zadnie: " + quest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Knight knight = (Knight) o;

        return age == knight.age;
    }

    @Override
    public int hashCode() {
        return age;
    }
}
