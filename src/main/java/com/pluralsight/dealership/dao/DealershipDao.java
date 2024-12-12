package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Dealership;
import com.pluralsight.dealership.model.Vehicle;

import java.util.List;
import java.util.Map;

public interface DealershipDao {
    // Create
    Dealership addDealership(Dealership dealership);
    // Read
    Dealership findDealershipById(int id);
    List<Dealership> getAllDealerships();
    //Map<Integer, List<Vehicle>> getDealershipInventoryById(int id);
    Map<Dealership, List<Vehicle>> getDealershipInventoryById(int id);

    void updateDealership(int id, Dealership dealership);

    void deleteDealership(int id);
    boolean dealershipExists(int id);

}
