package com.java.examples.concurrency;

public class Producer implements Runnable {
    final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0;

        while (true) {
            try {
                buffer.produce(value++);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
