package com.java.examples.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Generic PolicyManager
class PolicyManager<T extends Policy> {
    private List<T> policies = new ArrayList<>();

    // Add a policy
    public void addPolicy(T policy) {
        policies.add(policy);
    }

    // Retrieve all policies
    public List<T> getAllPolicies() {
        return policies;
    }

    // Filter policies based on a condition
    public List<T> filterPolicies(Predicate<T> condition) {
        List<T> filtered = new ArrayList<>();
        for (T policy : policies) {
            if (condition.test(policy)) {
                filtered.add(policy);
            }
        }
        return filtered;
    }
}

