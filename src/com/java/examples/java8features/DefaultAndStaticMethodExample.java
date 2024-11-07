package com.java.examples.java8features;

interface Vehicle {

    String getBrand();

    String speedUp();

    String slowDown();

    //
    default String turnAlarmOn() {
        return "Turning the vehicle alarm on.";
    }

    default String turnAlarmOff() {
        return "Turning the vehicle alarm off.";
    }

    // for utility methods
     static int getHorsePower(int rpm, int torque) {
        return (rpm * torque) / 5252;
    }
}

public class DefaultAndStaticMethodExample implements Vehicle {

    private String brand;

    public DefaultAndStaticMethodExample(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }

    @Override
    public String turnAlarmOff() {
        return "Turn BMW off";
    }

    public static void main(String[] args) {
        Vehicle car = new DefaultAndStaticMethodExample("BMW");

        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());

        // Default methods
        System.out.println(car.turnAlarmOn());

        // Overridden default method
        System.out.println(car.turnAlarmOff());

        // Static method
        System.out.println(Vehicle.getHorsePower(100, 100));
    }
}

