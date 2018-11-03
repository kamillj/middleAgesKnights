package com.kamiljurczak.middle_ages_knights.domain.repository;

import com.kamiljurczak.middle_ages_knights.domain.Knight;
import jdk.jshell.spi.ExecutionControl;

import javax.annotation.PostConstruct;
import java.util.Collection;

public class DBKnightRepository implements KnightRepository{

    @Override
    public void createKnight(String name, int age) {
        System.out.println("Używam bazy danych");
        try {
            throw new ExecutionControl.NotImplementedException("Not implemented");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Knight> getAllKnights(){
        System.out.println("Używam bazy danych");
        try {
            throw new ExecutionControl.NotImplementedException("Not implemented");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Knight getKnight(String name){
        System.out.println("Używam bazy danych");
        try {
            throw new ExecutionControl.NotImplementedException("Not implemented");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteKnight(String name){
        System.out.println("Używam bazy danych");
        try {
            throw new ExecutionControl.NotImplementedException("Not implemented");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @PostConstruct
    public void build(){
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public void createKnight(Knight knight) {
        System.out.println("Używam bazy danych");
        try {
            throw new ExecutionControl.NotImplementedException("Not implemented");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
    }


}
