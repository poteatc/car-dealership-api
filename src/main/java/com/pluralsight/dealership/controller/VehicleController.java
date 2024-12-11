package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.model.entities.VehicleEntity;
import com.pluralsight.dealership.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public VehicleEntity createVehicle(@RequestBody VehicleEntity vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @GetMapping
    public List<VehicleEntity> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/search/price")
    public List<VehicleEntity> getVehiclesInPriceRange(
            @RequestParam(value = "minPrice", required = false, defaultValue = "0") Double minPrice,
            @RequestParam(value = "maxPrice", required = false, defaultValue = "9999999") Double maxPrice) {
        return vehicleService.getVehiclesInPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/search/color")
    public List<VehicleEntity> getVehiclesByColor(@RequestParam String color) {
        return vehicleService.getVehiclesByColor(color);
    }

    @GetMapping("/search/type")
    public List<VehicleEntity> getVehiclesByType(@RequestParam String type) {
        return vehicleService.getVehiclesByType(type);
    }
}
