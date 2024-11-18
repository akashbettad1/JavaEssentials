package com.java.examples.generics;

// Life Insurance Policy
class LifePolicy implements Policy {
    private String policyNumber;
    private String holderName;
    private double premium;
    private double sumAssured;

    public LifePolicy(String policyNumber, String holderName, double premium, double sumAssured) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premium = premium;
        this.sumAssured = sumAssured;
    }

    @Override
    public String getPolicyNumber() {
        return policyNumber;
    }

    @Override
    public String getHolderName() {
        return holderName;
    }

    @Override
    public double getPremium() {
        return premium;
    }

    public double getSumAssured() {
        return sumAssured;
    }

    @Override
    public String toString() {
        return "LifePolicy [PolicyNumber=" + policyNumber + ", HolderName=" + holderName +
                ", Premium=" + premium + ", SumAssured=" + sumAssured + "]";
    }
}

