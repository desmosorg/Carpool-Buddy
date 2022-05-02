package com.example.carpoolbuddy;

import java.util.ArrayList;

public class Car extends Vehicle
{
    private double range;

    public Car(String owner, String model, int capacity, String vehicleID, ArrayList<String> ridersUIDs, Boolean open, String vehicleType, double basePrice, double range) {
        super(owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice);
        this.range = range;
    }

    public Car(double range) {
        this.range = range;
    }

    public Car()
    {
        this.range = 0;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Car{" +
                "range=" + range +
                '}';
    }
}
