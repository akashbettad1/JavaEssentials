package com.java.examples.sorting;

import java.util.Comparator;

public class PlanTypeComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getPlanType().compareTo(o2.getPlanType());
    }
}
