package com.kamiljurczak.middle_ages_knights.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Entity
public class PlayerInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    private String password;

    private boolean enabled;

    private int gold = 0;

    public PlayerInformation() {
    }

    public PlayerInformation(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
