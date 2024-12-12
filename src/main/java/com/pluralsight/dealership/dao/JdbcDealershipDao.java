package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Dealership;
import com.pluralsight.dealership.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDealershipDao implements DealershipDao {
    private final DataSource dataSource;

    @Autowired
    public JdbcDealershipDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Dealership addDealership(Dealership dealership) {
        String query = """
                INSERT INTO dealerships (name, address, phone)
                VALUES (?,?,?)
                """;
        String getLastInsertId = """
                SELECT last_insert_id() as ID
                """;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(1, dealership.getId());
            preparedStatement.setString(1, dealership.getName());
            preparedStatement.setString(2, dealership.getAddress());
            preparedStatement.setString(3, dealership.getPhone());

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows updated...");

            preparedStatement = connection.prepareStatement(getLastInsertId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int newDealershipId = rs.getInt("ID");
                return findDealershipById(newDealershipId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
        // Doesn't work if multiple dealerships have the same name
        //return getDealershipByName(dealership.getName());
    }

    public Dealership getDealershipByName(String dealershipName) {
        String query = """
                SELECT * FROM dealerships
                WHERE name = ?
                """;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dealershipName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int dealership_id = rs.getInt("dealership_id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");

                return new Dealership(dealership_id, name, address, phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Dealership findDealershipById(int id) {
        String query = """
                SELECT *
                FROM dealerships
                WHERE dealership_id = ?
                """;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int dealership_id = rs.getInt("dealership_id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");

                return new Dealership(dealership_id, name, address, phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Dealership> getAllDealerships() {
        List<Dealership> dealerships = new ArrayList<>();

        String query = """
                SELECT * FROM dealerships
                """;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int dealership_id = rs.getInt("dealership_id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");

                Dealership v = new Dealership(dealership_id, name, address, phone);
                dealerships.add(v);
            }
            return dealerships;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> findAllVehiclesByDealership(int id) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = """
                SELECT dealership_id, inventory.VIN, vehicles.year year, vehicles.make make, vehicles.model model 
                FROM inventory
                JOIN vehicles ON inventory.VIN = vehicles.VIN
                WHERE dealership_id = ?;
                """;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String vehicleType = "";
                String color = "";
                int odometer = 0;
                double price = 0.0;
                boolean sold = false;

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicles.add(v);
            }
            return vehicles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateDealership(int id, Dealership dealership) {
        String query = """
                UPDATE dealerships
                SET name = ?, address = ?, phone = ?
                WHERE dealership_id = ?
                """;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dealership.getName());
            preparedStatement.setString(2, dealership.getAddress());
            preparedStatement.setString(3, dealership.getPhone());
            preparedStatement.setInt(4, id);

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows updated...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteDealership(int id) {
        String query = """
                DELETE FROM dealerships
                WHERE dealership_id = ?
                """;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows updated...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
