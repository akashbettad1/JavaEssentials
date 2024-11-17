package com.java.examples.sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person>{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person p) {
        return this.name.compareTo(p.name);
        // this.age - p.age; // for sorting based on age.
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ComparableDemo {

    public static void main (String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Person(30, "Peter"));
        list.add(new Person(32, "Johnson"));
        list.add(new Person(31, "Sam"));
        list.add(new Person(22, "Rick"));
        list.add(new Person(40, "Niel"));
        list.add(new Person(62, "Aryan"));

        Collections.sort(list);

        list.forEach( p -> System.out.println(p.getName() + " " + p.getAge()));
    }
}
