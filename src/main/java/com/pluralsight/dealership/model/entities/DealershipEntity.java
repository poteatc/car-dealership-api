package com.pluralsight.dealership.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dealerships")
public class DealershipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dealershipId;

    private String name; // Dealership name
    private String address; // Dealership address
    private String phone; // Dealership contact phone
    //private final ArrayList<VehicleEntity> inventory; // List of vehicles available in the dealership's inventory

    public DealershipEntity(int id, String name, String address, String phone) {
        this.dealershipId = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        //this.inventory = new ArrayList<>(); // Initialize empty inventory list
    }

    public DealershipEntity() {
        this.dealershipId = 0;
        this.name = "";
        this.address = "";
        this.phone = "";
        //this.inventory = new ArrayList<>();
    }

    public int getDealershipId() {
        return dealershipId;
    }

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

    //    // Filters inventory by price range and returns list of matching vehicles
//    public List<VehicleEntity> getVehiclesByPrice(double min, double max) {
//        return inventory.stream()
//                .filter(vehicle -> vehicle.getPrice() >= min && vehicle.getPrice() <= max)
//                .toList();
//    }
//
//    // Filters inventory by make and model and returns list of matching vehicles
//    public List<VehicleEntity> getVehiclesByMakeModel(String make, String model) {
//        return inventory.stream().filter(
//                vehicle -> vehicle.getMake().trim().equalsIgnoreCase(make)
//                        && vehicle.getModel().trim().equalsIgnoreCase(model)).toList();
//    }
//
//    // Filters inventory by year range and returns list of matching vehicles
//    public List<VehicleEntity> getVehiclesByYear(int min, int max) {
//        return inventory.stream()
//                .filter(vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max)
//                .toList();
//    }
//
//    // Filters inventory by color and returns list of matching vehicles
//    public List<VehicleEntity> getVehiclesByColor(String color) {
//        return inventory.stream()
//                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
//                .toList();
//    }
//
//    // Filters inventory by mileage range and returns list of matching vehicles
//    public List<VehicleEntity> getVehiclesByMileage(int min, int max) {
//        return inventory.stream()
//                .filter(vehicle -> vehicle.getMileage() >= min && vehicle.getMileage() <= max)
//                .toList();
//    }
//
//    // Filters inventory by vehicle type and returns list of matching vehicles
//    public List<VehicleEntity> getVehiclesByType(String vehicleType) {
//        return inventory.stream()
//                .filter(vehicle -> vehicle.getType().equalsIgnoreCase(vehicleType))
//                .toList();
//    }
//
//    // Returns entire vehicle inventory
//    public List<VehicleEntity> getAllVehicles() {
//        return inventory;
//    }
//
//    // Adds a vehicle to the inventory list
//    public void addVehicle(VehicleEntity vehicle) {
//        inventory.add(vehicle);
//    }
//
//    // Removes a vehicle from the inventory list
//    public void removeVehicle(VehicleEntity vehicle) {
//        inventory.remove(vehicle);
//    }
}
