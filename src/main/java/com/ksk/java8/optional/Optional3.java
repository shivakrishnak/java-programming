package com.ksk.java8.optional;

import java.util.Optional;

public class Optional3 {

    public static void main(String[] args) {

        //Optional<String> name = Optional.empty();
        Optional<String> name = Optional.of("hello");
        System.out.println(name);
        if (name.isPresent()) {
            System.out.println(name.get().toUpperCase());
        } else {
            System.out.println("value is not present");
        }

        System.out.println(name.orElse("value is not present"));

        String printName = name.map(String::toUpperCase).orElse("value is not present");
        System.out.println(printName);
    }
}
