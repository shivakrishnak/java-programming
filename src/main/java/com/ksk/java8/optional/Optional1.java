package com.ksk.java8.optional;

import java.util.Optional;

/*
 * Optional: Used to represent a value that may or may not present
 */
public class Optional1 {

    public static void main(String[] args) {

        Optional<String> empty = Optional.empty(); //returns an empty instance(String in this case)
        System.out.println(empty);
        System.out.println(empty.isPresent());
        //System.out.println(empty.isEmpty()); //present in java-11
    }
}
