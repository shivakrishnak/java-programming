package com.ksk.java8.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Shiva Krishna K
 */
public class SupplierInterface {

    public static void main(String[] args) {

        //#1
        Supplier<Integer> factory = () -> 2;

        System.out.println(factory.get());

        //#2
        List<String> names = Arrays.asList("Jack","Jill");
        System.out.println(
                names.stream()
                        .filter(name -> name.length() == 5)
                        .findFirst()
                        .orElseGet(() -> "none")

        );
    }
}
