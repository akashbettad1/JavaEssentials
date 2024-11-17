package com.java.examples.sorting;

import java.util.Comparator;

public class MonthlyBillComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return Double.compare(c1.getMonthlyBill(), c2.getMonthlyBill()); // Lower bill amount first
    }
}

