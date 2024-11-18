package com.java.examples.generics;

// Health Insurance Policy
class HealthPolicy implements Policy {
    private String policyNumber;
    private String holderName;
    private double premium;
    private String coverageDetails;

    public HealthPolicy(String policyNumber, String holderName, double premium, String coverageDetails) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premium = premium;
        this.coverageDetails = coverageDetails;
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

    public String getCoverageDetails() {
        return coverageDetails;
    }

    @Override
    public String toString() {
        return "HealthPolicy [PolicyNumber=" + policyNumber + ", HolderName=" + holderName +
                ", Premium=" + premium + ", Coverage=" + coverageDetails + "]";
    }
}


