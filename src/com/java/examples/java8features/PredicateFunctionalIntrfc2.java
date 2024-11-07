package com.java.examples.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateFunctionalIntrfc2 {

    public static void main(String[] args) {
        Predicate<Integer> greaterThan6 = x -> x > 6;
        Predicate<Integer> lessThan10 = x -> x < 10;

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> collect = list.stream().filter(greaterThan6.and(lessThan10)).collect(Collectors.toList());

        System.out.println(collect);
    }
}
