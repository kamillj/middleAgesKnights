package com.kamiljurczak.middle_ages_knights.utils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String role;

    public Role() {
    }

    public Role(String userName, String userRole) {
        this.username = userName;
        this.role = userRole;
    }
}
