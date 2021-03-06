package com.ksk.snippets.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ConditionCheck {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("A", "AA");
        map.put("B", "BB");
        map.put("C", "CC");
        map.put("D", "DD");
        System.out.println(new ConditionCheck().isValid(map));
    }

    private boolean isAPresent(Map map){
        System.out.println("A");
        return map.containsKey("Aaa");
    }

    private boolean isBPresent(Map map){
        System.out.println("B");
        return map.containsKey("B");
    }

    private boolean isCPresent(Map map){
        System.out.println("CC");
        return map.containsKey("CC");
    }

    private boolean isDPresent(Map map){
        return map.containsKey("D");
    }


    private Boolean isValid(Map map) {
        return Optional.of(map)
                .filter(this::isAPresent)
                .filter(this::isBPresent)
                .map(this::isCPresent)
                .orElse(false);
    }
}
