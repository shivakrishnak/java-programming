package com.ksk.snippets;

import java.util.HashMap;

public class TwoWayMap<U, V> {
    HashMap<U, V> firstToSecond = new HashMap<>();
    HashMap<V, U> secondToFirst = new HashMap<>();

    public void put(U first, V second) {
        firstToSecond.put(first, second);
        secondToFirst.put(second, first);
    }

    public V getFirstFromSecond(U first) {
        return firstToSecond.get(first);
    }

    public U getSecondFromFirst(V second) {
        return secondToFirst.get(second);
    }
}
