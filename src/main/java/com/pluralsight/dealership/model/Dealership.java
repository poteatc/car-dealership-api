package com.pluralsight.dealership.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dealership {
    private final int id;
    private String name; // Dealership name
    private String address; // Dealership address
    private String phone; // Dealership contact phone

    public Dealership(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Dealership() {
        this.id = 0;
        this.name = "";
        this.address = "";
        this.phone = "";
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    //    // Filters inventory by price range and returns list of matching vehicles
//    public List<Vehicle> getVehiclesByPrice(double min, double max) {
//        return inventory.stream()
//                .filter(vehicle -> vehicle.getPrice() >= min && vehicle.getPrice() <= max)
//                .toList();
//    }
//
//    // Filters inventory by make and model and returns list of matching vehicles
//    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
//        return inventory.stream().filter(
//                vehicle -> vehicle.getMake().trim().equalsIgnoreCase(make)
//                        && vehicle.getModel().trim().equalsIgnoreCase(model)).toList();
//    }
//
//    // Filters inventory by year range and returns list of matching vehicles
//    public List<Vehicle> getVehiclesByYear(int min, int max) {
//        return inventory.stream()
//                .filter(vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max)
//                .toList();
//    }
//
//    // Filters inventory by color and returns list of matching vehicles
//    public List<Vehicle> getVehiclesByColor(String color) {
//        return inventory.stream()
//                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
//                .toList();
//    }
//
//    // Filters inventory by mileage range and returns list of matching vehicles
//    public List<Vehicle> getVehiclesByMileage(int min, int max) {
//        return inventory.stream()
//                .filter(vehicle -> vehicle.getOdometer() >= min && vehicle.getOdometer() <= max)
//                .toList();
//    }
//
//    // Filters inventory by vehicle type and returns list of matching vehicles
//    public List<Vehicle> getVehiclesByType(String vehicleType) {
//        return inventory.stream()
//                .filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
//                .toList();
//    }
//
//    // Returns entire vehicle inventory
//    public List<Vehicle> getAllVehicles() {
//        return inventory;
//    }
//
//    // Adds a vehicle to the inventory list
//    public void addVehicle(Vehicle vehicle) {
//        inventory.add(vehicle);
//    }
//
//    // Removes a vehicle from the inventory list
//    public void removeVehicle(Vehicle vehicle) {
//        inventory.remove(vehicle);
//    }
}
