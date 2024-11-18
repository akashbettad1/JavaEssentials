package com.java.examples.generics;

// Vehicle Insurance Policy
class VehiclePolicy implements Policy {
    private String policyNumber;
    private String holderName;
    private double premium;
    private String vehicleType;

    public VehiclePolicy(String policyNumber, String holderName, double premium, String vehicleType) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premium = premium;
        this.vehicleType = vehicleType;
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

    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "VehiclePolicy [PolicyNumber=" + policyNumber + ", HolderName=" + holderName +
                ", Premium=" + premium + ", VehicleType=" + vehicleType + "]";
    }
}
