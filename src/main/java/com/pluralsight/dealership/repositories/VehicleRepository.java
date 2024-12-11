package com.pluralsight.dealership.repositories;

import com.pluralsight.dealership.model.Vehicle;
import com.pluralsight.dealership.model.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
@Repository Annotation
    Purpose
        - Marks a class as a Data Access Object (DAO).
        - It is a specialization of @Component, used for classes that directly interact with the database or other persistence mechanisms.
    Key Features
        1. Persistence Exception Translation:
            - Spring automatically applies persistence exception translation to classes annotated with @Repository.
              For example, database exceptions like SQLException are converted into Spring’s data access exceptions such as DataAccessException.
        2. Indicates Database Layer:
            - It helps organize the code by clearly distinguishing the database access layer.
 */

//@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {
    //List<VehicleEntity> getAllVehicles();

    // JPQL Query Example
    @Query("SELECT v FROM VehicleEntity v WHERE v.price BETWEEN ?1 AND ?2")
    List<VehicleEntity> getVehiclesInPriceRange(@Param("minPrice") Double min, @Param("maxPrice") Double max);

//    List<VehicleEntity> getVehiclesByMakeAndModel(String make, String model);
//    List<VehicleEntity> getVehiclesByYearRange(int start, int end);
    List<VehicleEntity> getVehiclesByColor(@Param("color") String color);
//    List<VehicleEntity> getVehiclesByMileageRange(int min, int max);
    List<VehicleEntity> getVehiclesByType(@Param("type") String type);

    // Already have saveVehicle from JpaRepository/CrudRepository using JPQL
    //void addVehicle(String vin, int year, String make, String model, String vehicleType, String color, int odometer, double price, boolean sold);

//    void removeVehicleByVin(String vin);
//    boolean vehicleExists(String vin);
//    void updateVehicleSoldStatus(String vin);
}
