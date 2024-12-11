package com.pluralsight.dealership.services;

import com.pluralsight.dealership.model.entities.VehicleEntity;
import com.pluralsight.dealership.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleEntity saveVehicle(VehicleEntity vehicleEntity) {
        return vehicleRepository.save(vehicleEntity);
    }

    public List<VehicleEntity> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<VehicleEntity> getVehiclesInPriceRange(Double min, Double max) {
        return vehicleRepository.getVehiclesInPriceRange(min, max);
    }

    public List<VehicleEntity> getVehiclesByColor(String color) {
        return vehicleRepository.getVehiclesByColor(color);
    }

    public List<VehicleEntity> getVehiclesByType(String type) {
        return vehicleRepository.getVehiclesByType(type);
    }
}
