package com.java.examples.java8features;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Streams methods - map, filter, collect, toList, toSet, toMap, count, distinct, limit
 * findAny, allMatch, anyMatch, noneMatch, reduce etc.
 * Good to read
 *  1. sequential and parallel streams
 *  2. Intermediate and terminal operations
 */

class User {
    private String name;
    private Integer id;
    private BigDecimal salary;

    public User(String name, Integer id, BigDecimal salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
public class StreamsExample {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();

        userList.add( new User("abc", 1, new BigDecimal(12000)));
        userList.add( new User("def", 2, new BigDecimal(12000)));
        userList.add( new User("ghi", 3, new BigDecimal(12000)));
        userList.add( new User("xyz", 4, new BigDecimal(12000)));

        List<String> userNames =  userList.stream().map(u -> u.getName().toUpperCase()).collect(Collectors.toList());
        System.out.println(userNames);

        // map, collect()
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect);

        // filter, map, findAny()
        String name = userList.stream()
                .filter(x -> 1 == x.getId())
                .map(User::getName)
                .findAny()
                .orElse("");

        System.out.println("name : " + name);

        // forEach()
        collect.forEach(System.out::println);
    }
}
