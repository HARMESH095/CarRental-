package EmployeeAccess.Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Entity.CarEntity;
import DatabaseConnection.MysqlConnectionCarDetails;

public class CarDetailsUploadProcess {
    Scanner input = new Scanner(System.in);
    CarEntity car = new CarEntity();

    public void entry() {

            try {
                System.out.println("\nUPLOAD CARS\n");

                System.out.println("Car ID: (UNIQUE ID)");
                try{
                    car.setCarId(input.nextInt());
                    input.nextLine();

                    System.out.println("\nModel: ");
                    car.setModel(input.nextLine());

                    System.out.println("\nManufacturer: ");
                    car.setMake(input.nextLine());

                    System.out.println("\nYear of make: ");
                    car.setYearOfMake(input.nextInt());
                    input.nextLine();

                    System.out.println("\nColor: ");
                    car.setColor(input.nextLine());

                    System.out.println("\nPlate Number: ('AA00AA0000' in this format)");
                    car.setPlateNumber(input.nextLine());

                    System.out.println("\nSeats: ");
                    car.setSeats(input.nextInt());
                    input.nextLine();

                    System.out.println("\nFuel type: (Petrol, Gasoline, Electric, Diesel, Natural gas, LPG)");
                    car.setFuelType(input.nextLine());

                    System.out.println("\nMileage: ");
                    car.setMileage(input.nextInt());

                    System.out.println("\nAvailability: ");
                    car.setAvailability(input.nextInt());

                    System.out.println("\nPrice per day: (In Rupees)");
                    car.setPrice(input.nextInt());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    entry();
                }

                databaseImport();

            } catch (Exception e) {
                System.out.println("Value error: " + e);
            }
        }


    public void databaseImport() {

            try {
                MysqlConnectionCarDetails mysqlConnectionCarDetails = new MysqlConnectionCarDetails();
                Connection connection = mysqlConnectionCarDetails.getConnection();
                try {
                    String sql = "INSERT INTO cardetails (carId, model, make, yearOfMake, color, plateNumber, seats, fuelType, mileage, availability, price) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, car.getCarId());
                    statement.setString(2, car.getModel());
                    statement.setString(3, car.getMake());
                    statement.setInt(4, car.getYearOfMake());
                    statement.setString(5, car.getColor());
                    statement.setString(6, car.getPlateNumber());
                    statement.setInt(7, car.getSeats());
                    statement.setString(8, car.getFuelType());
                    statement.setInt(9, car.getMileage());
                    statement.setInt(10, car.getAvailability());
                    statement.setInt(11, car.getPrice());

                    statement.executeUpdate();
                    System.out.println("Successfully updated");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } catch (Exception e) {
                System.out.println("Database connection error: " + e);
            }



    }
}
