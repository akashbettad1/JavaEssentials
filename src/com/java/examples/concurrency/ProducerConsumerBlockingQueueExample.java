package com.java.examples.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Java’s java.util.concurrent package provides tools like BlockingQueue, which simplifies
 * solving the Producer-Consumer problem by handling synchronization internally.
 * BlockingQueue handles the complexity of wait() and notify() internally.
 * This approach is simpler, more reliable, and easier to understand.
 */
public class ProducerConsumerBlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(5);

        // Producer thread
        Runnable producer = () -> {
            int value = 0;
            try {
                while (true) {
                    buffer.put(value); // Automatically waits if buffer is full
                    System.out.println("Produced: " + value);
                    value++;
                    Thread.sleep(500); // Simulate time taken to produce
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Consumer Thread
        Runnable consumer = () -> {

            while(true) {
                int value = 0;
                try {
                    value = buffer.take();
                    System.out.println("Removed: " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
