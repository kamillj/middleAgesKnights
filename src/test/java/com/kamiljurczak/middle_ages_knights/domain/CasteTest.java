package com.kamiljurczak.middle_ages_knights.domain;

import com.kamiljurczak.middle_ages_knights.domain.Castle;
import com.kamiljurczak.middle_ages_knights.domain.Knight;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CasteTest {

    @Test
    public void castleToStringMessage(){
        Quest quest = new Quest();
        Knight knight = new Knight();
        knight.setQuest(quest);
        Castle castle = new Castle(knight, "Castle Black");
        String except = "Znajduje się tu zamek Castle Black zamieszkały przez rycerza Lancelot (29). Ma zadnie: Uratuj księżniczkę";
        assertEquals(except, castle.toString());
    }
}
