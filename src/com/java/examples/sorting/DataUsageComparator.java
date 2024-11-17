package com.java.examples.sorting;

import java.util.Comparator;

public class DataUsageComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        // Higher data usage first
        return Double.compare(o2.getDataUsage(), o1.getDataUsage());
    }
}
