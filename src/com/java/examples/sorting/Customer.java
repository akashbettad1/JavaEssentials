package com.java.examples.sorting;

public class Customer {
    private String planType;
    private double dataUsage;
    private double monthlyBill;

    public Customer(String planType, double dataUsage, double monthlyBill) {
        this.planType = planType;
        this.dataUsage = dataUsage;
        this.monthlyBill = monthlyBill;
    }

    public String getPlanType() {
        return planType;
    }

    public double getDataUsage() {
        return dataUsage;
    }

    public double getMonthlyBill() {
        return monthlyBill;
    }

    @Override
    public String toString() {
        return "Customer{planType='" + planType + "', dataUsage=" + dataUsage + ", monthlyBill=" + monthlyBill + "}";
    }
}

