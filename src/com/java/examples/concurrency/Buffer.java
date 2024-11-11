package com.java.examples.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    private Queue<Integer> queue = new LinkedList<>();

    private Integer capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {

        while(queue.size() == capacity) {
            wait(); // Wait until there's space in the buffer
        }

        queue.add(value);
        System.out.println("Value add to queue: " +value);
        notifyAll(); // Notify consumers that they can consume
    }

    public synchronized void consume() throws InterruptedException {

        while (queue.isEmpty()) {
            wait(); // Wait until there's something to consume
        }
        int value = queue.poll();
        System.out.println("Item removed from queue: " +value);
        notifyAll(); // Notify producers that they can produce
    }
}
