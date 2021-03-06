package com.ksk.java8.defaultmethods.rule2;

public class DefaultMethodsRule2 {
    public static void main(String[] args) {
        System.out.println("working...");
        SeaPlane plane = new SeaPlane();
        plane.cruise();
    }
}

class SeaPlane implements FastFly {
}

interface FastFly extends Fly {
    default void cruise(){
        System.out.println("FastFly:cruise");
    }
}

interface Fly {
    default void cruise() {
        System.out.println("Fly:cruise");
    }
}

