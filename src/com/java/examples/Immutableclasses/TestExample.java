package com.java.examples.Immutableclasses;

import java.util.HashMap;
import java.util.Map;

/**
 * To create an immutable class in Java, you need to follow these general principles:
 * Declare the class as final, so it can’t be extended.
 * Make all the fields private so that direct access is not allowed.
 * Don’t provide setter methods for variables.
 * Make all mutable fields final so that a field’s value can be assigned only once.
 * Initialize all fields using a constructor method performing deep copy.
 * Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
 *
 * Note: There should be no setters or in simpler terms, there should be no option to
 * change the value of the instance variable.
 *
 * Ex : String, Byte, Boolean, Integer and all wrapper classes are immutable classes
 * Usage: Used in Multithreading, hashmap keys and for caching purpose.
 */

final class TestExample {

    private final String name;

    private final int id;

    private final HashMap<String, String> testMap;

    // Deep copy in constructor.
    public TestExample(String name, int id, HashMap<String, String> testMap) {
        this.name = name;
        this.id = id;

        HashMap<String, String> tempMap = new HashMap<>();

        for (Map.Entry<String, String>  entry: testMap.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.testMap = tempMap;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Return a copy instead of actual object.
    public HashMap<String, String> getTestMap() {
        // Creating Map with HashMap reference
        HashMap<String, String> tempMap = new HashMap<>();

        for (Map.Entry<String, String> entry :
                this.testMap.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }

    @Override
    public String toString() {
        return "TestExample{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", testMap=" + testMap +
                '}';
    }
}
