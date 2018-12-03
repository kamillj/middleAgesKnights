package com.kamiljurczak.middle_ages_knights.domain;

import java.time.LocalDateTime;

public class Quest {

    private int id;
    private String description;
    private int reward = 100;
    protected int lenghtInSec = 10;
    private boolean started = false;
    private boolean completed = false;
    protected LocalDateTime startDate;

    public Quest() {
    }

    public Quest(int id, String description) {

        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLenght() {
        return lenghtInSec;
    }

    public void setLenght(int lenght) {
        this.lenghtInSec = lenght;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if (started) this.startDate = LocalDateTime.now();
        this.started = started;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompleted() {
        if(this.completed) return true;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime questEndDate = this.startDate.plusSeconds(this.lenghtInSec);
        boolean isAfter =  now.isAfter(questEndDate);
        if(isAfter) this.completed = true;

        return isAfter;
    }
}
