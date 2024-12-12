package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.model.entities.DealershipEntity;
import com.pluralsight.dealership.services.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealerships")
public class DealershipController {
    private final DealershipService dealershipService;

    @Autowired
    public DealershipController(DealershipService dealershipService) {
        this.dealershipService = dealershipService;
    }

    // Create
    @PostMapping
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

    @DeleteMapping("/{id}")
    public void deleteDealership(@PathVariable int id) {
        dealershipService.deleteDealership(id);
    }
}
