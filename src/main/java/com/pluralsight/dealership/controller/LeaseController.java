package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.dao.JdbcLeaseContractDao;
import com.pluralsight.dealership.model.LeaseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles/leases")
public class LeaseController {
    JdbcLeaseContractDao jdbcLeaseContractDao;

    @Autowired
    public LeaseController(JdbcLeaseContractDao jdbcLeaseContractDao) {
        this.jdbcLeaseContractDao = jdbcLeaseContractDao;
    }

    @GetMapping
    public List<LeaseContract> getLeaseContracts() {
        return jdbcLeaseContractDao.getAllLeaseContracts();
    }

//    @GetMapping
//    @public List<LeaseContract> getLeaseContractsByAttributes(@RequestParam ) {
//
//    }
}
