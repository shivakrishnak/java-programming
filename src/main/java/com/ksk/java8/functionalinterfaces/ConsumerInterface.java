package com.ksk.java8.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Shiva Krishna K
 */
public class ConsumerInterface {

    public static void main(String[] args) {
        //#Consumer
        Consumer<Integer> printIt = (Integer val) -> System.out.println(val);

        printIt.accept(2);

        //#Consumer used in  in Java API
        List<Integer> numbers = Arrays.asList(1,2,3);

        //Parameter in forEach is a consumer - it performs side effect operation - it can lead certain issues with concurrency
        numbers.forEach(val -> System.out.println(val * 2));

    }
}
