package com.java.examples.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private final ReentrantLock lock;
    private final Condition sufficientFundsCondition;

    public BankAccount(double initialBalance, boolean fair) {
        this.balance = initialBalance;
        this.lock = new ReentrantLock(fair); // Create a fair or non-fair ReentrantLock based on the parameter
        this.sufficientFundsCondition = lock.newCondition();
    }

    // Basic lock/unlock with try-finally
    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
            sufficientFundsCondition.signalAll(); // Notify waiting threads that balance has changed
        } finally {
            lock.unlock();
        }
    }

    // Using tryLock with timeout to avoid waiting indefinitely
    public void withdrawWithTimeout(double amount) {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) { // Try to acquire lock with 1 second timeout
                try {
                    if (balance >= amount) {
                        balance -= amount;
                        System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
                    } else {
                        System.out.println("Insufficient balance for withdrawal of " + amount);
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not acquire lock to withdraw " + amount);
            }
        } catch (InterruptedException e) {
            System.out.println("Withdraw interrupted for amount: " + amount);
            Thread.currentThread().interrupt();
        }
    }

    // Using lockInterruptibly to allow the thread to be interrupted while waiting for the lock
    public void interruptibleDeposit(double amount) {
        try {
            lock.lockInterruptibly(); // Acquire lock in an interruptible manner
            try {
                balance += amount;
                System.out.println("Interruptible deposit of: " + amount + ", New Balance: " + balance);
                sufficientFundsCondition.signalAll(); // Notify waiting threads
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println("Deposit interrupted for amount: " + amount);
            Thread.currentThread().interrupt();
        }
    }

    // Using condition variables to wait until sufficient funds are available
    public void waitForSufficientFundsAndWithdraw(double amount) {
        lock.lock();
        try {
            while (balance < amount) {
                System.out.println("Waiting for sufficient funds to withdraw: " + amount);
                sufficientFundsCondition.await(); // Wait until signaled
            }
            balance -= amount;
            System.out.println("Condition met. Withdrew: " + amount + ", New Balance: " + balance);
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for sufficient funds for withdrawal of: " + amount);
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockBankExample {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(100, true); // Create an account with fairness enabled

        // Thread for a basic deposit
        Thread depositThread = new Thread(() -> account.deposit(50));

        // Thread for a timed withdrawal using tryLock with timeout
        Thread timedWithdrawalThread = new Thread(() -> account.withdrawWithTimeout(80));

        // Thread for an interruptible deposit
        Thread interruptibleDepositThread = new Thread(() -> account.interruptibleDeposit(40));

        // Thread to wait for sufficient funds before withdrawing
        Thread conditionWithdrawalThread = new Thread(() -> account.waitForSufficientFundsAndWithdraw(200));

        // Start the threads
        depositThread.start();
        timedWithdrawalThread.start();
        interruptibleDepositThread.start();
        conditionWithdrawalThread.start();

        // Wait for threads to finish
        depositThread.join();
        timedWithdrawalThread.join();
        interruptibleDepositThread.join();
        conditionWithdrawalThread.join();

        System.out.println("Final Balance: " + account.getBalance());
    }
}

