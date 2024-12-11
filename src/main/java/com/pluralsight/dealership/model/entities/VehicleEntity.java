package com.pluralsight.dealership.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final String vin;

    private final int year;
    private final String make;
    private final String model;
    private final String type;
    private final String color;
    private final int mileage;
    private final double price;
    private final boolean sold;

    public VehicleEntity(String vin, int year, String make, String model, String type, String color, int mileage, double price, boolean sold) {
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

    public VehicleEntity() {
        this.vin = "vin";
        this.year = 0;
        this.make = "make";
        this.model = "model";
        this.type = "vehicleType";
        this.color = "color";
        this.mileage = 0;
        this.price = 0;
        this.sold = false;
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

    @Override
    public String toString() {
        return String.format("%-21s %-10s %-10s %-10d %-10s %-10s %-10d %10.2f %10b",
                vin, make, model, year, type, color, mileage, price, sold);
    }
}
