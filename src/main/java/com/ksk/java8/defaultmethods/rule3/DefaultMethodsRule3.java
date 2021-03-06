package com.ksk.java8.defaultmethods.rule3;

public class DefaultMethodsRule3 {
    public static void main(String[] args) {
        System.out.println("working...");
        SeaPlane plane = new SeaPlane();
        plane.takeOff();
    }
}

class SeaPlane extends Vehicle implements FastFly {
}

class Vehicle {
    public void takeOff() {
        System.out.println("Vehicle:takeOff");
    }
}

interface FastFly extends Fly {

    default void takeOff() {
        System.out.println("FastFly:takeOff");
    }
}

interface Fly {

    default void takeOff() {
        System.out.println("Fly:takeOff");
    }
}
