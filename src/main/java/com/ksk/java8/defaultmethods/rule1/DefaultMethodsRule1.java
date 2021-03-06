package com.ksk.java8.defaultmethods.rule1;

public class DefaultMethodsRule1 {
    public static void main(String[] args) {
        System.out.println("working...");
        SeaPlane plane = new SeaPlane();
        plane.fly();
    }
}

class SeaPlane implements FastFly {
}

interface FastFly extends Fly {
}

interface Fly {
    default void fly() {
        System.out.println("Fly:fly");
    }
}
