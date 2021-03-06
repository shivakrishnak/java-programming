package com.ksk.java8.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Shiva Krishna K
 */
public class PredicateInterface {

    public static void main(String[] args) {
        //#1
        Predicate<Integer> eval = (Integer value) -> value > 3;

        System.out.println(eval.test(5));
        System.out.println("-----");

        //#2
        List<String> names = Arrays.asList("Joe", "Raju", "Scott","Qi","Frank");
        System.out.println("-----");

        names.stream()
            .filter(name -> name.length() == 5)
            .forEach(System.out::println);
        System.out.println("-----");

        //#3
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(total(numbers, (value) -> true));
        System.out.println(total(numbers, (number) -> number > 3));
        System.out.println("-----");

        //#4 - multiple filters
        Predicate<String> startsWithS = s -> s.startsWith("S");
        Predicate<String> length4 = (String name) -> name.length() == 4;
        Predicate<String> length5 = (String name) -> name.length() == 5;
        names.stream()
                .filter(startsWithS.or(length5))
                .forEach(System.out::println);
        System.out.println("-----");
        names.stream()
                .filter(length4.or(length5))
                .forEach(System.out::println);
        System.out.println("-----");
        names.stream()
                .filter(startsWithS.negate())
                .forEach(System.out::println);

    }

    private static int total(List<Integer> numbers, Predicate<Integer> selector) {

        return numbers.stream()
                        .filter(selector)
                        .mapToInt(val -> val)
                        .sum();
    }

  /*  private static int total(List<Integer> numbers, Predicate<Integer> selector) {
        int total = 0;
        for (int value:numbers) {
            if(selector.test(value))
                total+=value;
        }
        return total;
    }*/


}
