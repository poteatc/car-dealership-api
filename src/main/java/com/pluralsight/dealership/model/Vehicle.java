package com.pluralsight.dealership.model;

import jakarta.persistence.Entity;

@Entity
public class Vehicle {
    private final String vin;
    private final int year;
    private final String make;
    private final String model;
    private final String type;
    private final String color;
    private final int mileage;
    private final double price;

    private final boolean sold;

    public Vehicle(String vin, int year, String make, String model, String type, String color, int mileage, double price, boolean sold) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.sold = sold;
    }

    public String getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSold() {
        return sold;
    }


    @Override
    public String toString() {
        return String.format("%-21s %-10s %-10s %-10d %-10s %-10s %-10d %10.2f %10b",
                vin, make, model, year, type, color, mileage, price, sold);
    }

    //int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price
    public String toCSVFormat() {
        return String.format("%s|%d|%s|%s|%s|%s|%d|%.2f",
                vin, year, make, model, type, color, mileage, price);
    }
}
