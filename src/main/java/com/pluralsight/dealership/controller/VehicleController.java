package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.dao.JdbcVehicleDao;
import com.pluralsight.dealership.model.Vehicle;
import com.pluralsight.dealership.model.entities.VehicleEntity;
import com.pluralsight.dealership.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;
    private final JdbcVehicleDao jdbcVehicleDao;

    @Autowired
    public VehicleController(VehicleService vehicleService, JdbcVehicleDao jdbcVehicleDao) {
        this.vehicleService = vehicleService;
        this.jdbcVehicleDao = jdbcVehicleDao;
    }

    // TODO : add JDBC implementations for API requests

    // Single Get method to find vehicle given request queries for all attributes
    @GetMapping("/jdbc")
    public List<Vehicle> findAllVehicles() {
        return jdbcVehicleDao.getAllVehicles();
    }

    // Single Get method to find vehicle given request queries for all attributes
    // RequestParams should use Wrapper classes instead of primitives to account for nullability
    @GetMapping("/jdbc/search")
    public List<Vehicle> findVehiclesWithAttributes(@RequestParam(required = false) String vin,
                                            @RequestParam(required = false) Integer year,
                                            @RequestParam(required = false) String make,
                                            @RequestParam(required = false) String model,
                                            @RequestParam(required = false) String type,
                                            @RequestParam(required = false) String color,
                                            @RequestParam(required = false) Integer mileage,
                                            @RequestParam(required = false) Double price,
                                            @RequestParam(required = false) Boolean sold) {

        List<Vehicle> vehicles = jdbcVehicleDao.getAllVehicles();
        return vehicles.stream()
                .filter(vehicle -> vin == null || vin.equals(vehicle.getVin()))
                .filter(vehicle -> year == null || year.equals(vehicle.getYear()))
                .filter(vehicle -> make == null || make.equalsIgnoreCase(vehicle.getMake()))
                .filter(vehicle -> model == null || model.equalsIgnoreCase(vehicle.getModel()))
                .filter(vehicle -> type == null || type.equalsIgnoreCase(vehicle.getType()))
                .filter(vehicle -> color == null || color.equalsIgnoreCase(vehicle.getColor()))
                .filter(vehicle -> mileage == null || mileage.equals(vehicle.getMileage()))
                .filter(vehicle -> price == null || price.equals(vehicle.getPrice()))
                .filter(vehicle -> sold == null || sold.equals(vehicle.isSold()))
                .collect(Collectors.toList());
    }

    @GetMapping("/jdbc/search/filter")
    public List<Vehicle> filterVehiclesWithAttributes(@RequestParam(required = false) Double minPrice,
                                                      @RequestParam(required = false) Double maxPrice,
                                                      @RequestParam(required = false) String make,
                                                      @RequestParam(required = false) String model,
                                                      @RequestParam(required = false) Integer minYear,
                                                      @RequestParam(required = false) Integer maxYear,
                                                      @RequestParam(required = false) String color,
                                                      @RequestParam(required = false) Integer minMiles,
                                                      @RequestParam(required = false) Integer maxMiles,
                                                      @RequestParam(required = false) String type) {

        List<Vehicle> vehicles = jdbcVehicleDao.getAllVehicles();
        return vehicles.stream()
                .filter(vehicle -> minPrice == null || vehicle.getPrice() >= minPrice)
                .filter(vehicle -> maxPrice == null || vehicle.getPrice() <= maxPrice)
                .filter(vehicle -> make == null || make.equalsIgnoreCase(vehicle.getMake()))
                .filter(vehicle -> model == null || model.equalsIgnoreCase(vehicle.getModel()))
                .filter(vehicle -> minYear == null || vehicle.getPrice() >= minYear)
                .filter(vehicle -> maxYear == null || vehicle.getPrice() <= maxYear)
                .filter(vehicle -> color == null || color.equalsIgnoreCase(vehicle.getColor()))
                .filter(vehicle -> minMiles == null || vehicle.getMileage() >= minMiles)
                .filter(vehicle -> maxMiles == null || vehicle.getMileage() <= maxMiles)
                .filter(vehicle -> type == null || type.equalsIgnoreCase(vehicle.getType()))
                .collect(Collectors.toList());
    }

    ///////////////////////////////////////////////////////////////////////////
    //    CRUD using JPA with Repository interface and Dealership Service    //
    ///////////////////////////////////////////////////////////////////////////

    // Create
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public VehicleEntity createVehicle(@RequestBody VehicleEntity vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    // TODO : add rest of getters for filtering vehicles by attributes
    // Read
    @GetMapping
    public List<VehicleEntity> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/search/filter")
    public List<VehicleEntity> getFilteredVehicles(@RequestParam(required = false) Double minPrice,
                                                   @RequestParam(required = false) Double maxPrice,
                                                   @RequestParam(required = false) String make,
                                                   @RequestParam(required = false) String model,
                                                   @RequestParam(required = false) Integer minYear,
                                                   @RequestParam(required = false) Integer maxYear,
                                                   @RequestParam(required = false) String color,
                                                   @RequestParam(required = false) Integer minMiles,
                                                   @RequestParam(required = false) Integer maxMiles,
                                                   @RequestParam(required = false) String type) {
        return vehicleService.getAllVehicles().stream()
                .filter(vehicle -> minPrice == null || vehicle.getPrice() >= minPrice)
                .filter(vehicle -> maxPrice == null || vehicle.getPrice() <= maxPrice)
                .filter(vehicle -> make == null || make.equalsIgnoreCase(vehicle.getMake()))
                .filter(vehicle -> model == null || model.equalsIgnoreCase(vehicle.getModel()))
                .filter(vehicle -> minYear == null || vehicle.getPrice() >= minYear)
                .filter(vehicle -> maxYear == null || vehicle.getPrice() <= maxYear)
                .filter(vehicle -> color == null || color.equalsIgnoreCase(vehicle.getColor()))
                .filter(vehicle -> minMiles == null || vehicle.getMileage() >= minMiles)
                .filter(vehicle -> maxMiles == null || vehicle.getMileage() <= maxMiles)
                .filter(vehicle -> type == null || type.equalsIgnoreCase(vehicle.getType()))
                .collect(Collectors.toList());
    }

    @GetMapping("/search/price")
    public List<VehicleEntity> getVehiclesInPriceRange(
            @RequestParam(value = "minPrice", required = false, defaultValue = "0") Double minPrice,
            @RequestParam(value = "maxPrice", required = false, defaultValue = "9999999") Double maxPrice) {
        return vehicleService.getVehiclesInPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/search/color/{color}")
    public List<VehicleEntity> getVehiclesByColor(@PathVariable String color) {
        return vehicleService.getVehiclesByColor(color);
    }

    @GetMapping("/search/type/{type}")
    public List<VehicleEntity> getVehiclesByType(@PathVariable String type) {
        return vehicleService.getVehiclesByType(type);
    }
}
