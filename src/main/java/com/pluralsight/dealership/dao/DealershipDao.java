package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Dealership;
import com.pluralsight.dealership.model.Vehicle;

import java.util.List;

public interface DealershipDao {
    // Create
    void addDealership(Dealership dealership);
    // Read
    Dealership findDealershipById(int id);
    List<Dealership> getAllDealerships();
    // TODO : put this method in the VehicleDao instead
    List<Vehicle> findAllVehiclesByDealership(int id);

    // Update
    //void updateDealership()

}
