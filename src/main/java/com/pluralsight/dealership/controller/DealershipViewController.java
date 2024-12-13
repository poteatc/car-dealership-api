package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.dao.DealershipDao;
import com.pluralsight.dealership.model.Dealership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DealershipViewController {
    private final DealershipDao jdbcDealershipDao;
    //private List<Dealership> dealerships;

    @Autowired
    public DealershipViewController(DealershipDao jdbcDealershipDao) {
        this.jdbcDealershipDao = jdbcDealershipDao;
        //this.dealerships = jdbcDealershipDao.getAllDealerships();
    }

    @GetMapping("/dealerships")
    public String getProducts(Model model) {
        model.addAttribute("dealerships", jdbcDealershipDao.getAllDealerships());
        return "dealership_list"; // Matches the file name 'dealership_list.html'
    }

    @PostMapping("/addDealership")
    public String addProduct(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("address") String address,
                             @RequestParam("phone") String phone,
                             Model model) {

        // Create a new product and add it to the list
        Dealership dealership = new Dealership(id, name, address, phone);
        jdbcDealershipDao.addDealership(dealership);

        // Update the model with the updated product list
        model.addAttribute("dealerships", jdbcDealershipDao.getAllDealerships());

        // Redirect to the product list page
        return "redirect:/dealerships";
    }
}
