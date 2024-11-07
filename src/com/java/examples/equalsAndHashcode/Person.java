package com.java.examples.equalsAndHashcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * This example illustrate the equals and hashocodes usages.
 */

/**
 * The equals method is used to compare two objects for equality.
 * By default, it behaves the same as the == operator (reference equality),
 * but it is often overridden to provide "logical equality" based on the values within an object.
 *
 * The hashCode method returns an integer representation of the memory address of the object
 * by default. This method is used in hash-based collections like HashMap, HashSet,
 * and Hashtable to place and locate objects in "buckets" efficiently.
 *
 * Contract between equals and hashCode:
 * If a.equals(b) is true, then a.hashCode() must be equal to b.hashCode().
 * If a.equals(b) is false, a and b can have the same or different hash codes.
 */

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main (String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Alice", 30);
        Person person3 = new Person("Bob", 25);

        Set<Person> people = new HashSet<>();
        people.add(person1);
        people.add(person2);  // Should not be added because it is equal to person1
        people.add(person3);

        // Display the set
        System.out.println(people);
    }
}
