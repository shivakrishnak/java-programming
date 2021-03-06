package com.ksk.java8.optional;

import java.util.Optional;

public class Optional2 {

    public static void main(String[] args) {

        try {
            //"ofNullable" is safer than "of" in case if there is possibility that value can be null
            Optional<Object> nullVal = Optional.of(null);
            System.out.println(nullVal); //Exception
        } catch (Exception ex) {
            System.out.println("> NullPointerException");
        }

        Optional<Object> nullable = Optional.ofNullable(null);
        System.out.println(nullable);
        System.out.println(nullable.isPresent());
        System.out.println(nullable.orElse("value is not present")); //if name is null then else is printed
        System.out.println(nullable.orElseGet(() -> "value is not found"));
        System.out.println(nullable.orElseThrow(() -> new IllegalArgumentException("value not found")));

    }
}
