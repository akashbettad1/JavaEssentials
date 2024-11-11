package com.java.examples.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * In Java, ReentrantLock is a part of the java.util.concurrent.locks package that
 * provides a more flexible and powerful locking mechanism compared to the traditional
 * synchronized keyword. It is a type of explicit lock that offers better control over the locking process,
 * including advanced features such as fairness policies, try-locking, and interruptible locking.
 *
 * Key Features of ReentrantLock
 * Reentrant Behavior:
 * Like synchronized blocks, ReentrantLock is reentrant, meaning that if a thread acquires the lock, it can acquire it again without deadlocking itself. This is useful for recursive method calls within the same thread.
 * The lock keeps track of the number of times it has been acquired, and it must be released the same number of times to be fully unlocked.
 *
 * Fairness Option:
 * ReentrantLock can be created with a fairness policy, which ensures that the longest-waiting thread gets the lock first (if fairness is set to true).
 * By default, ReentrantLock uses a non-fair policy, meaning threads may compete for the lock without regard for the order they requested it, potentially resulting in better performance but less predictability.
 *
 * Interruptible Lock Acquisition:
 * Threads waiting to acquire a ReentrantLock can be interrupted. This means a thread can be interrupted while it waits for the lock, which can be helpful in applications that require a quick response or handling of interrupted tasks.
 *
 * Try-Lock:
 * With ReentrantLock, you can try to acquire the lock without blocking indefinitely by using tryLock(). This method returns true if the lock is acquired and false if it is not. You can also specify a timeout, so the thread can stop trying after a certain period.
 */

class Counter2 {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++;
        } finally {
            lock.unlock(); // Ensure the lock is always released
        }
    }

    public int getCount() {
        return count;
    }
}


public class ReEntrantLockExample {
    public static void main(String[] args) throws InterruptedException {

        Counter2 counter2 = new Counter2();

        // Create two threads that increment the counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter2.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter2.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter2.getCount());
    }
}


