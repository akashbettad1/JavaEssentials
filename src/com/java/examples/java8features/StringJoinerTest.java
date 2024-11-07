package com.java.examples.java8features;

import java.util.StringJoiner;
public class StringJoinerTest {
    public static void main(String[] args) {
        StringJoiner joinNames = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter

        // Adding values to StringJoiner
        joinNames.add("Steve");
        joinNames.add("John");
        joinNames.add("Peter");
        joinNames.add("Joseph");

        System.out.println(joinNames);

        StringJoiner joinNames2 = new StringJoiner(":", "[", "]");

        joinNames2.add("Aron");
        joinNames2.add("David");
        joinNames2.add("Kane");

        StringJoiner mergeResults = joinNames.merge(joinNames2);

        System.out.println(mergeResults);

    }
}
