package com.java.examples.concurrency;

public class Consumer implements Runnable {

    final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
