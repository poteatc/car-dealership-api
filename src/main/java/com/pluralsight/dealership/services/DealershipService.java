package com.pluralsight.dealership.services;

import com.pluralsight.dealership.model.entities.DealershipEntity;
import com.pluralsight.dealership.repositories.DealershipRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealershipService {
    private final DealershipRepository dealershipRepository;

    @Autowired
    public DealershipService(DealershipRepository dealershipRepository) {
        this.dealershipRepository = dealershipRepository;
    }

    public DealershipEntity saveDealership(DealershipEntity dealershipEntity) {
        return dealershipRepository.save(dealershipEntity);
    }

    public List<DealershipEntity> getAllDealerships() {
        return dealershipRepository.findAll();
    }

    public DealershipEntity getDealershipById(Integer id) {
        return dealershipRepository.findById(id).get();
    }

//    public void deleteDealership(DealershipEntity dealershipEntity) {
//        dealershipRepository.delete(dealershipEntity);
//    }

    public void updateDealership(int id, DealershipEntity updatedDealership) {
        DealershipEntity dealership = dealershipRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dealership not found"));

        // Update Dealership Entity Fields
        dealership.setName(updatedDealership.getName());
        dealership.setAddress(updatedDealership.getAddress());
        dealership.setPhone(updatedDealership.getPhone());

        dealershipRepository.save(dealership);
    }

    public void deleteDealership(int id) {
        dealershipRepository.deleteById(id);
    }
}
