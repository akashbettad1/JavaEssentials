package com.java.examples.concurrency;

/**
 * In Java, a race condition is a situation in multi-threaded programming where two or more
 * threads access shared data concurrently, and the final outcome depends on the sequence
 * or timing of their execution.
 */

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++; // Make this method synchronised to ensure correct results.
    }

    public int getCount() {
        return count;
    }
}

public class RaceConditionExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Create two threads that increment the counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.getCount());
    }
}

