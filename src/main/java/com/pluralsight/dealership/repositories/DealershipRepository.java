package com.pluralsight.dealership.repositories;

import com.pluralsight.dealership.model.entities.DealershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface DealershipRepository extends JpaRepository<DealershipEntity, Integer> {
   // List<DealershipEntity> getAllDealerships();
    //DealershipEntity getDealershipById(int id);
    //DealershipEntity saveDealership(DealershipEntity dealershipEntity);
    //void updateDealership(int id, DealershipEntity dealership);
}
