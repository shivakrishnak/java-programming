package com.ksk.java8.defaultmethods.rule4;

public class DefaultMethodsRule4 {
    public static void main(String[] args) {
        System.out.println("working...");
        SeaPlane plane = new SeaPlane();
        plane.steer();
    }
}

class SeaPlane extends Vehicle implements FastFly, Fly {
    @Override
    public void steer() {
        System.out.println("SeaPlane:steer");
    }
}

class Vehicle {
    /*public void steer() {
        System.out.println("FastFly:steer");
    }*/
}

interface FastFly {
    default void steer() {
        System.out.println("FastFly:steer");
    }
}

interface Fly {
    default void steer() {
        System.out.println("Fly:steer");
    }
}
