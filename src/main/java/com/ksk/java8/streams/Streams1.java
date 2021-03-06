package com.ksk.java8.streams;

import java.util.*;

public class Streams1 {

    public static void main(String[] args) {
        Map<Person, Long> map = new HashMap<>();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i < 10000; i++) {
            Person p = getStudent();
            //System.out.println(p);
            map.put(p, new Random().nextLong());

        }
        System.out.println(map.size());
    }

    private static Person getStudent() {
        return new Person(getRandomString(), getRandomString(), getRandomString(), getRandomString());
    }

    private static String getRandomString() {
        return String.valueOf(new Random().nextGaussian());
    }
}


class Person {
    private String name;
    private String school;
    private String address;
    private String age;

    public Person(String name, String school, String address, String age) {
        this.name = name;
        this.school = school;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return 1223;
    }
}