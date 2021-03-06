package com.ksk.java8.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author Shiva Krishna K
 */
public class FuntionInterface {
    public static void main(String[] args) {
        /*Function<I,R> f
                R result = f.apply(i)*/
        //#1 Before
       // System.out.println(doubleIt(2));
       // System.out.println(tripleIt(2));

        //#2 with Funtion
        Function<Integer, Double> doubleIt = (Integer val) -> val * 2.0;
        Function<Integer, Double> tripleIt = (Integer val) -> val * 3.0;
        System.out.println(doubleIt.apply(5));
        System.out.println(tripleIt.apply(5));

        //#3
        List<String> names = Arrays.asList("Joe","Raju","Scott");

        names.stream()
                .map(name -> name.length())
                .forEach(System.out::println);

        Function<String,Integer> length = name -> {
            System.out.println("name");
            return name.length();
        } ;
        Function<Integer,Integer> doubleIT = size -> size * 2;


        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

        names.stream()
                .map(length.andThen(doubleIT))
                .forEach(System.out::println);
        Function<String, String> upcase = name -> {
            System.out.println("upcase");
            return name.toUpperCase();
        };

        names.stream()
                .map(upcase.andThen(length))
                .forEach(System.out::println);

        // compose is reverse of andThen
        // upcase.andThen(length) === length.compose(upcase)
        names.stream()
                .map(length.compose(upcase))
                .forEach(System.out::println);
    }

    private static double doubleIt(int val) {
        return val * 2;
    }

    private static double tripleIt(int val) {
        return val * 3;
    }
}
