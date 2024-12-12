package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.dao.DealershipDao;
import com.pluralsight.dealership.dao.JdbcDealershipDao;
import com.pluralsight.dealership.model.Dealership;
import com.pluralsight.dealership.model.entities.DealershipEntity;
import com.pluralsight.dealership.services.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealerships")
public class DealershipController {
    private final DealershipService dealershipService;
    private final DealershipDao jdbcDealershipDao;

    @Autowired
    public DealershipController(DealershipService dealershipService, JdbcDealershipDao jdbcDealershipDao) {
        this.dealershipService = dealershipService;
        this.jdbcDealershipDao = jdbcDealershipDao;
    }

    ///////////////////////////////////////////////////////////////////////////
    //      CRUD using JDBC SQL Queries with JdbcDealershipDao Component     //
    ///////////////////////////////////////////////////////////////////////////

    // Create
    @PostMapping("/jdbc")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Dealership createDealership(@RequestBody Dealership dealership) {
        return jdbcDealershipDao.addDealership(dealership);
    }

    // Read
    @GetMapping("/jdbc")
    public List<Dealership> findAllDealerships() {
        return jdbcDealershipDao.getAllDealerships();
    }

    @GetMapping("/jdbc/{id}")
    public Dealership findDealershipById(@PathVariable int id) {
        return jdbcDealershipDao.findDealershipById(id);
    }

    // Update
    @PutMapping("/jdbc/{id}")
    public void updateDealership(@PathVariable int id,
                                 @RequestBody Dealership dealership) {
        jdbcDealershipDao.updateDealership(id, dealership);
    }

    // Delete
    @DeleteMapping("/jdbc/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeDealership(@PathVariable int id) {
        jdbcDealershipDao.deleteDealership(id);
    }

    ///////////////////////////////////////////////////////////////////////////
    //    CRUD using JPA with Repository interface and Dealership Service    //
    ///////////////////////////////////////////////////////////////////////////

    // Create
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public DealershipEntity createDealership(@RequestBody DealershipEntity dealership) {
        return dealershipService.saveDealership(dealership);
    }

    // Read
    @GetMapping
    public List<DealershipEntity> getAllDealerships() {
        return dealershipService.getAllDealerships();
    }

    @GetMapping("/{id}")
    public DealershipEntity getDealershipById(@PathVariable int id) {
        return dealershipService.getDealershipById(id);
    }

    // Update
    @PutMapping("/{id}")
    public void updateDealership(@PathVariable int id,
                                 @RequestBody DealershipEntity dealership) {
        dealershipService.updateDealership(id, dealership);
    }

    // Delete
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDealership(@PathVariable int id) {
        dealershipService.deleteDealership(id);
    }
}
