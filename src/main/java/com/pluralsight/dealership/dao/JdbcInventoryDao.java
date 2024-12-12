//package com.pluralsight.dealership.dao;
//
//import com.pluralsight.dealership.model.Vehicle;
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class JdbcInventoryDao implements InventoryDao {
//    private DataSource dataSource;
//
//    @Autowired
//    public JdbcInventoryDao(DataSource dataSource) {
//        this.dataSource = new BasicDataSource();
//    }
//
//    @Override
//    public Map<Integer, List<Vehicle>> getInventoryByDealershipId(int id) {
//        return Map.of();
//    }
//}
