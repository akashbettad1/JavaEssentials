package com.java.examples.generics;

import java.util.List;

public class PolicyMain {
    public static void main(String[] args) {
        // Create a PolicyManager for Health Policies
        PolicyManager<HealthPolicy> healthManager = new PolicyManager<>();
        healthManager.addPolicy(new HealthPolicy("H123", "John Doe", 500.0, "Comprehensive"));
        healthManager.addPolicy(new HealthPolicy("H124", "Jane Doe", 300.0, "Basic"));

        // Create a PolicyManager for Life Policies
        PolicyManager<LifePolicy> lifeManager = new PolicyManager<>();
        lifeManager.addPolicy(new LifePolicy("L101", "Alice", 1000.0, 50000.0));
        lifeManager.addPolicy(new LifePolicy("L102", "Bob", 1200.0, 100000.0));

        // Create a PolicyManager for Vehicle Policies
        PolicyManager<VehiclePolicy> vehicleManager = new PolicyManager<>();
        vehicleManager.addPolicy(new VehiclePolicy("V201", "Charlie", 800.0, "Car"));
        vehicleManager.addPolicy(new VehiclePolicy("V202", "Dave", 600.0, "Motorbike"));

        // Retrieve and display all health policies
        System.out.println("All Health Policies:");
        for (HealthPolicy policy : healthManager.getAllPolicies()) {
            System.out.println(policy);
        }

        // Filter health policies with premium above $400
        System.out.println("\nHealth Policies with Premium > $400:");
        List<HealthPolicy> expensiveHealthPolicies = healthManager.filterPolicies(p -> p.getPremium() > 400);
        for (HealthPolicy policy : expensiveHealthPolicies) {
            System.out.println(policy);
        }

        // Retrieve and display all life policies
        System.out.println("\nAll Life Policies:");
        for (LifePolicy policy : lifeManager.getAllPolicies()) {
            System.out.println(policy);
        }

        // Filter life policies with sum assured above $50,000
        System.out.println("\nLife Policies with Sum Assured > $50,000:");
        List<LifePolicy> highCoverageLifePolicies = lifeManager.filterPolicies(p -> p.getSumAssured() > 50000);
        for (LifePolicy policy : highCoverageLifePolicies) {
            System.out.println(policy);
        }
    }
}

