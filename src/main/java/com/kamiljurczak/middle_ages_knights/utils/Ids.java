package com.kamiljurczak.middle_ages_knights.utils;

import java.util.Set;

public class Ids {

    public static int getNewId(Set<Integer> keysSoFar) {
        if(keysSoFar.isEmpty()) return 0;
        else {
            Integer integer = keysSoFar.stream().max(Integer::compareTo).get();
            return integer + 1;
        }
    }
}
