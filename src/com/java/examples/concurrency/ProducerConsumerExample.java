package com.java.examples.concurrency;

/**
 * The Producer-Consumer Problem is a classic synchronization problem in computer science
 * that involves two types of processes, the producer and the consumer, who share a common,
 * bounded resource called a buffer. The producer generates data and puts it into the
 * buffer, and the consumer takes data from the buffer for processing.
 * The challenge is to make sure that the producer doesn’t add data when the buffer is full,
 * and the consumer doesn’t take data when the buffer is empty, while ensuring that no
 * data is lost or corrupted.
 */
public class ProducerConsumerExample {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);

        Thread producerThread = new Thread(new Producer(buffer));

        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}
