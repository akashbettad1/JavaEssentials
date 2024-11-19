package com.java.examples.Immutableclasses;

import java.util.HashMap;

public class TestImmutability {

    public static void main(String[] args) {

        HashMap<String, String> hm = new HashMap<>();
        hm.put("1", "abc");
        hm.put("2", "def");
        TestExample e = new TestExample("abc", 1, hm);

        System.out.println(e);

        e.getTestMap().put("4", "fourth");
        // Remains unchanged due to deep copy in getter
        System.out.println(e.getTestMap());

    }
}
