package com.java.examples.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Reference for good source:
 * https://medium.com/javarevisited/4-essential-techniques-for-tackling-concurrency-fixing-the-concurrentmodificationexception-468d8e22b496
 */

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {

        List<String> sharedList = new CopyOnWriteArrayList<>(Arrays.asList("One", "Two", "Three"));

// Thread 1
        new Thread(() -> {
            for (String item : sharedList) {
                System.out.println(item);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

// Thread 2
        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sharedList.add("Four"); // Safe addition in a concurrent collection
        }).start();
    }
}
