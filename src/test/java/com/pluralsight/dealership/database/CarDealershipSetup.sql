DROP DATABASE IF EXISTS dealership;

CREATE DATABASE IF NOT EXISTS dealership;

USE dealership;

-- Drop existing tables to ensure the script can be re-run multiple times
DROP TABLE IF EXISTS Lease_Contracts;
DROP TABLE IF EXISTS Sales_Contracts;
DROP TABLE IF EXISTS Inventory;
DROP TABLE IF EXISTS Vehicles;
DROP TABLE IF EXISTS Dealerships;

-- Table 1: Dealerships
CREATE TABLE Dealerships (
    dealership_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    phone VARCHAR(12) NOT NULL
);

-- Table 2: Vehicles
CREATE TABLE Vehicles (
    VIN VARCHAR(17) PRIMARY KEY DEFAULT 0,        -- VIN is a unique identifier (not auto-increment)
    make VARCHAR(50) NOT NULL DEFAULT "",
    model VARCHAR(50) NOT NULL DEFAULT "",
    year INT NOT NULL DEFAULT 0,
    type VARCHAR(50) NOT NULL DEFAULT "",  -- e.g., SUV, Sedan, Truck
    color VARCHAR(20) NOT NULL DEFAULT "",
    mileage INT NOT NULL DEFAULT 0,
    price DECIMAL(10,2) NOT NULL DEFAULT 0.0,
    sold BOOLEAN DEFAULT FALSE          -- Track whether the vehicle is sold or not
);

-- Table 3: Inventory
CREATE TABLE Inventory (
    dealership_id INT,
    VIN VARCHAR(17),
    PRIMARY KEY (dealership_id, VIN),
    FOREIGN KEY (dealership_id) REFERENCES Dealerships(dealership_id),
    FOREIGN KEY (VIN) REFERENCES Vehicles(VIN)
);

-- Table 4: Sales Contracts
CREATE TABLE Sales_Contracts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17),                   -- Foreign key to the Vehicles table
    contract_date DATE NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    customer_email VARCHAR(100) NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    amount_paid DECIMAL(10,2) NOT NULL,
    taxes DECIMAL(10,2) NOT NULL,
    fees DECIMAL(10,2) NOT NULL,
    balance_due DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (VIN) REFERENCES Vehicles(VIN)
);

-- Table 5: Lease Contracts (Optional)
CREATE TABLE Lease_Contracts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17),                   -- Foreign key to the Vehicles table
    contract_date DATE NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    customer_email VARCHAR(100) NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    monthly_payment DECIMAL(10,2) NOT NULL,
    lease_term INT NOT NULL,           -- Lease term in months
    FOREIGN KEY (VIN) REFERENCES Vehicles(VIN)
);

-- Insert sample data into Dealerships table
INSERT INTO Dealerships (name, address, phone) VALUES
('D & B Used Cars', '111 Old Benbrook Rd', '817-555-5555'),
('Texas Auto Sales', '500 West Loop, Dallas, TX', '214-555-1234'),
('Highway Motors', '2208 Elm St, Austin, TX', '512-555-6789');

-- Insert sample data into Vehicles table
INSERT INTO Vehicles (VIN, make, model, year, type, color, mileage, price, sold) VALUES
('1FADP3F29JL123456', 'Ford', 'Focus', 2018, 'Sedan', 'Red', 25000, 14995.00, TRUE),
('2HGFB6E55KH123457', 'Honda', 'Civic', 2019, 'Sedan', 'Blue', 18000, 17995.00, TRUE),
('3N1AB7AP8EY123458', 'Nissan', 'Altima', 2017, 'Sedan', 'Black', 35000, 10995.00, TRUE),
('1GNEK13ZX2R123459', 'Chevrolet', 'Tahoe', 2020, 'SUV', 'White', 15000, 38995.00, TRUE),
('2T1BURHE0KC123460', 'Toyota', 'Corolla', 2021, 'Sedan', 'Silver', 10000, 24995.00, TRUE),
('3GCPCREC4JG123461', 'Chevrolet', 'Silverado', 2018, 'Truck', 'Gray', 27000, 32995.00, TRUE),
('1C4PJMCB4HW123462', 'Jeep', 'Cherokee', 2019, 'SUV', 'Green', 20000, 27995.00, FALSE),
('1J4BA3H14BL123463', 'Jeep', 'Wrangler', 2022, 'SUV', 'Black', 5000, 45995.00, false),
('1C6RR7FG8HS123464', 'Ram', '1500', 2020, 'Truck', 'Red', 12000, 35995.00, false),
('1HGCM82633A123465', 'Honda', 'Accord', 2021, 'Sedan', 'White', 8000, 23995.00, false),
('1N4AL3AP5GN123466', 'Nissan', 'Sentra', 2019, 'Sedan', 'Blue', 15000, 17995.00, false),
('2GCEC19T5Y1123467', 'Chevrolet', 'Colorado', 2022, 'Truck', 'Silver', 3000, 41995.00, false),
('3C3CFFAR5CT123468', 'Fiat', '500', 2020, 'Hatchback', 'Green', 7000, 16995.00, false),
('4T1BF1FK5CU123469', 'Toyota', 'Camry', 2018, 'Sedan', 'Gray', 20000, 20995.00, false),
('5YJSA1AG7BF123470', 'Tesla', 'Model S', 2021, 'Sedan', 'Black', 12000, 72995.00, false),
('WBA3C1G52EN123471', 'BMW', '3 Series', 2020, 'Sedan', 'Blue', 10000, 39995.00, false),
('1FA6P8TH8H123472', 'Ford', 'Mustang', 2022, 'Coupe', 'Yellow', 4000, 33995.00, false),
('1G1ZD5ST4LF123473', 'Chevrolet', 'Malibu', 2021, 'Sedan', 'White', 5000, 24995.00, false),
('2T3WFREV7FW123474', 'Toyota', 'RAV4', 2019, 'SUV', 'Red', 15000, 29995.00, false);

-- Insert sample data into Inventory table (linking dealerships and vehicles)
INSERT INTO Inventory (dealership_id, VIN) VALUES
(1, '1FADP3F29JL123456'),
(1, '2HGFB6E55KH123457'),
(2, '3N1AB7AP8EY123458'),
(2, '1GNEK13ZX2R123459'),
(3, '2T1BURHE0KC123460'),
(3, '3GCPCREC4JG123461'),
(1, '1C4PJMCB4HW123462'),
(2, '1J4BA3H14BL123463'),
(3, '1C6RR7FG8HS123464'),
(1, '1HGCM82633A123465'),
(2, '1N4AL3AP5GN123466'),
(3, '2GCEC19T5Y1123467'),
(1, '3C3CFFAR5CT123468'),
(2, '4T1BF1FK5CU123469'),
(3, '5YJSA1AG7BF123470'),
(1, 'WBA3C1G52EN123471'),
(2, '1FA6P8TH8H123472'),
(3, '1G1ZD5ST4LF123473'),
(1, '2T3WFREV7FW123474');

-- Insert sample data into Sales_Contracts table
INSERT INTO Sales_Contracts (VIN, contract_date, customer_name, customer_email, total_price, amount_paid, taxes, fees, balance_due) VALUES
('1FADP3F29JL123456', '2024-10-15', 'John Doe', 'john.doe@email.com', 14995.00, 5000.00, 300.00, 100.00, 10495.00),
('2HGFB6E55KH123457', '2024-09-10', 'Alice Johnson', 'alice.j@email.com', 17995.00, 7000.00, 400.00, 120.00, 11975.00),
('3N1AB7AP8EY123458', '2024-08-05', 'Bob Smith', 'bob.smith@email.com', 10995.00, 4000.00, 200.00, 90.00, 6995.00),
('1GNEK13ZX2R123459', '2024-11-01', 'Mary Lee', 'mary.lee@email.com', 38995.00, 10000.00, 800.00, 250.00, 27945.00);

-- Insert sample data into Lease_Contracts table (Optional)
INSERT INTO Lease_Contracts (VIN, contract_date, customer_name, customer_email, total_price, monthly_payment, lease_term) VALUES
('2T1BURHE0KC123460', '2024-11-01', 'Chris Brown', 'chris.b@email.com', 24995.00, 450.00, 36),
('3GCPCREC4JG123461', '2024-07-20', 'Nancy Green', 'nancy.green@email.com', 32995.00, 500.00, 48);
