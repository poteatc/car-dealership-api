package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.SalesContract;
import com.pluralsight.dealership.model.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface SalesDao {
    double taxRate = 0.04;
    double feeRate = 0.01;
    void addSalesContract(String vin, LocalDate date, String name, String email, double price, double amount,
                          double taxes, double fees, double balanceDue);

    double calculateTaxes(double price);
    double calculateFees(double price);
    double calculateBalanceDue(double price, double taxes, double fees, double amountPaid);
    Vehicle getVehicleByVin(String vin);
    List<Vehicle> getVehiclesSold();
    List<SalesContract> getAllSalesContracts();

}
