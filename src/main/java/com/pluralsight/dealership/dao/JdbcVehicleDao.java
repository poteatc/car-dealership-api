package com.pluralsight.dealership.dao;

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
public class JdbcVehicleDao implements VehicleDao {
    private final DataSource dataSource;

    @Autowired
    public JdbcVehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    @Override
//    public Vehicle findVehicleByVin() {
//        return null;
//    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = "select * from vehicles";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String vehicleType = rs.getString("type");
                String color = rs.getString("color");
                int odometer = rs.getInt("mileage");
                double price = rs.getDouble("price");
                boolean sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicles.add(v);
            }
            return vehicles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> getVehiclesInPriceRange(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = """
        select *
        from vehicles
        where price between ? and ?
        """;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, min);
            preparedStatement.setDouble(2, max);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String vehicleType = rs.getString("type");
                String color = rs.getString("color");
                int odometer = rs.getInt("mileage");
                double price = rs.getDouble("price");
                boolean sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicles.add(v);
            }
            return vehicles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> getVehiclesByMakeAndModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = """
        select *
        from vehicles
        where make = ? and model = ?
        """;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, make);
            preparedStatement.setString(2, model);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String vmake = rs.getString("make");
                String vmodel = rs.getString("model");
                String vehicleType = rs.getString("type");
                String color = rs.getString("color");
                int odometer = rs.getInt("mileage");
                double price = rs.getDouble("price");
                boolean sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, vmake, vmodel, vehicleType, color, odometer, price, sold);
                vehicles.add(v);
            }
            return vehicles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> getVehiclesByYearRange(int start, int end) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = """
        select *
        from vehicles
        where year between ? and ?
        """;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, end);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String vehicleType = rs.getString("type");
                String color = rs.getString("color");
                int odometer = rs.getInt("mileage");
                double price = rs.getDouble("price");
                boolean sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicles.add(v);
            }
            return vehicles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = """
        select *
        from vehicles
        where color = ?
        """;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, color);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String vehicleType = rs.getString("type");
                String vcolor = rs.getString("color");
                int odometer = rs.getInt("mileage");
                double price = rs.getDouble("price");
                boolean sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, vcolor, odometer, price, sold);
                vehicles.add(v);
            }
            return vehicles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> getVehiclesByMileageRange(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = """
        select *
        from vehicles
        where mileage between ? and ?
        """;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, min);
            preparedStatement.setInt(2, max);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String vehicleType = rs.getString("type");
                String color = rs.getString("color");
                int odometer = rs.getInt("mileage");
                double price = rs.getDouble("price");
                boolean sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicles.add(v);
            }
            return vehicles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = """
        select *
        from vehicles
        where type = ?
        """;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, type);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String vin = rs.getString("VIN");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String vehicleType = rs.getString("type");
                String color = rs.getString("color");
                int odometer = rs.getInt("mileage");
                double price = rs.getDouble("price");
                boolean sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicles.add(v);
            }
            return vehicles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addVehicle(String vin, int year, String make, String model, String vehicleType, String color, int odometer, double price, boolean sold) {
        String query = """
            insert into vehicles (VIN, year, make, model, type, color, mileage, price, sold)
            values (?,?,?,?,?,?,?,?,?)
        """;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vin);
            preparedStatement.setInt(2, year);
            preparedStatement.setString(3, make);
            preparedStatement.setString(4, model);
            preparedStatement.setString(5, vehicleType);
            preparedStatement.setString(6, color);
            preparedStatement.setInt(7, odometer);
            preparedStatement.setDouble(8, price);
            preparedStatement.setBoolean(9, sold);
            int rows = preparedStatement.executeUpdate();
            // confirm the update
            System.out.printf("Rows updated %d\n", rows);
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void removeVehicleByVin(String vin) {
        String query = """
               delete from vehicles
               where VIN = ?
           """;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vin);
            int rows = preparedStatement.executeUpdate();
            // confirm the deletion
            System.out.printf("Rows updated %d\n", rows);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean vehicleExists(String vin) {
        String query = """
                    select VIN from vehicles
                    where VIN = ?
                """;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vin);
            // confirm the deletion
            //System.out.printf("Rows updated %d\n", rows);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void updateVehicleSoldStatus(String vin) {
        String query = """
                    update vehicles
                    set sold = 1
                    where VIN = ?
                """;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vin);
            // confirm the deletion
            //System.out.printf("Rows updated %d\n", rows);
            int rows = preparedStatement.executeUpdate();
            // confirm the deletion
            System.out.printf("Rows updated %d\n", rows);


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
