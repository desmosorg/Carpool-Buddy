package com.example.carpoolbuddy;

import java.util.ArrayList;

public class Motorcycle extends Vehicle
{
    private double range;
    private String motorcycleType;


    public Motorcycle(String owner, String model, int capacity, String vehicleID, ArrayList<String> ridersUIDs, Boolean open, String vehicleType, double basePrice, double range, String motorcycleType) {
        super(owner, model, capacity, vehicleID, ridersUIDs, open, vehicleType, basePrice);
        this.range = range;
        this.motorcycleType = motorcycleType;
    }

    public Motorcycle(String owner, String model, int capacity, String vehicleID, ArrayList<String> ridersUIDs, double basePrice) {
        super(owner, model, capacity, vehicleID, ridersUIDs, true, Constants.MOTORCYCLE, basePrice);
        this.range = range;
        this.motorcycleType = Constants.MOTORCYCLE_TYPE;
    }

    public Motorcycle(double range, String motorcycleType) {
        this.range = range;
        this.motorcycleType = motorcycleType;
    }

    public Motorcycle()
    {
        this.range = 0;
        this.motorcycleType = "";
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public String getMotorcycleType() {
        return motorcycleType;
    }

    public void setMotorcycleType(String motorcycleType) {
        this.motorcycleType = motorcycleType;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "range=" + range +
                ", motorcycleType='" + motorcycleType + '\'' +
                '}';
    }
}
