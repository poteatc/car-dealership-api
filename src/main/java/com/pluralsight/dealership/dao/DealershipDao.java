package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Dealership;
import com.pluralsight.dealership.model.Vehicle;

import java.util.List;

public interface DealershipDao {
    // Create
    Dealership addDealership(Dealership dealership);
    // Read
    Dealership findDealershipById(int id);
    List<Dealership> getAllDealerships();
    // TODO : put this method in the VehicleDao instead
    List<Vehicle> findAllVehiclesByDealership(int id);

    void updateDealership(int id, Dealership dealership);

    void deleteDealership(int id);

    // Update
    //void updateDealership()

}
