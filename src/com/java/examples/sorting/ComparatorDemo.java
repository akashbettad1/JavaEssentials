package com.java.examples.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Here’s a clear textual comparison between Comparable and Comparator without using tables:
 *
 * Purpose:
 * Comparable is used to define a natural ordering for objects of a class, meaning it provides a default sort order for instances of that class.
 * Comparator is used to define custom or multiple sorting orders. It allows you to sort objects in different ways without changing their natural order.
 *
 * Implementation Location:
 * Comparable is implemented within the class itself. The class directly implements the Comparable interface and overrides its compareTo method.
 * Comparator is implemented outside the class. This can be done in a separate class, or using inline syntax like lambdas or anonymous classes.
 *
 * Method to Override:
 * Comparable requires implementing the compareTo method, which compares the current object (this) with another object of the same type.
 * Comparator requires implementing the compare method, which takes two objects as parameters and compares them with each other.
 *
 * Syntax:
 * For Comparable, the class implements Comparable<ClassName>, defining a single compareTo method to specify its natural order.
 * For Comparator, you create a class implementing Comparator<ClassName> or use Comparator.comparing with lambdas, which defines a compare method for custom ordering.
 *
 * Single vs. Multiple Sorting Options:
 * Comparable allows only one sort order since it’s defined directly within the class.
 * Comparator allows multiple sort orders by using different comparator implementations, giving more flexibility to the sorting logic.
 *
 * Modifying the Original Class:
 * Comparable requires modifying the original class by implementing the interface and adding the compareTo method.
 * Comparator does not require changes to the original class, as it can be implemented separately. This is useful when you want to sort a class in different ways without altering its code.
 *
 *  Example Usage:
 * For Comparable, you would typically use Collections.sort(list) to sort a list based on the natural order defined by compareTo.
 * For Comparator, you’d use Collections.sort(list, comparatorInstance) to sort a list based on a specific comparator implementation.
 *
 * Functional Interface:
 * Comparable is not a functional interface because it doesn’t have a functional method that takes two arguments.
 * Comparator is a functional interface, which means it can be used with lambdas in Java 8 and above.
 *
 * Flexibility:
 * Comparable provides limited flexibility since you can only define one natural order.
 * Comparator is highly flexible and allows multiple sorting strategies, making it ideal when multiple sort orders are needed for the same class.
 */

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Premium", 15.5, 75.99));
        customers.add(new Customer("Basic", 10.0, 50.00));
        customers.add(new Customer("Standard", 25.0, 65.75));
        customers.add(new Customer("Premium", 5.0, 80.00));
        customers.add(new Customer("Basic", 12.0, 40.00));

        // Sort by Plan Type
        Collections.sort(customers, new PlanTypeComparator());
        System.out.println("Sorted by Plan Type:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Sort by Data Usage in descending order
        Collections.sort(customers, new DataUsageComparator());
        System.out.println("\nSorted by Data Usage (Descending):");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Sort by Monthly Bill in ascending order
        Collections.sort(customers, new MonthlyBillComparator());
        System.out.println("\nSorted by Monthly Bill (Ascending):");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}

