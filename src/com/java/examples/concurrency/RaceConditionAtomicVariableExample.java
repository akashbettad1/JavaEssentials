package com.java.examples.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Java provides atomic classes in the java.util.concurrent.atomic package,
 * such as AtomicInteger, which supports atomic operations without the need for explicit
 * synchronization. The count operation is  atomic. It involves three stepsn and all done at
 * once:
 * Read the current value of count.
 * Increment the value.
 * Write the new value back to count.
 *
 * Note : Reference for good source : https://hemanthcse1.medium.com/atomic-variables-in-java-6af069454258
 */

class Counter1 {
    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet(); // Atomic increment
    }

    public int getCount() {
        return count.get();
    }
}

public class RaceConditionAtomicVariableExample {
        public static void main(String[] args) throws InterruptedException {

            Counter1 counter1 = new Counter1();

            // Create two threads that increment the counter
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    counter1.increment();
                }
            });

            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    counter1.increment();
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Final Count: " + counter1.getCount());
        }
    }
