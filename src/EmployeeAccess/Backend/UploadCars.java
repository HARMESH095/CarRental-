package EmployeeAccess.Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Entity.carEntity; // Import your CarEntity class
import DatabaseConnection.MysqlConnectionCarDetails;

public class UploadCars {
    Scanner input = new Scanner(System.in);
    carEntity car = new carEntity();

    public void entry() {



            try {
                System.out.println("\nUPLOAD CARS\n");

                System.out.println("Car ID: ");
                try{
                    car.setCarId(input.nextInt());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
                input.nextLine(); // Consume the newline character

                System.out.println("\nModel: ");
                try{
                    car.setModel(input.nextLine());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

                System.out.println("\nManufacturer: ");
                try{
                    car.setMake(input.nextLine());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

                System.out.println("\nYear of make: ");
                try{
                    car.setYearOfMake(input.nextInt());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
                input.nextLine(); // Consume the newline character

                System.out.println("\nColor: ");
                try{
                    car.setColor(input.nextLine());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

                System.out.println("\nPlate Number: ");
                try{
                    car.setPlateNumber(input.nextLine());
                }catch (IllegalArgumentException e ){
                    System.out.println(e.getMessage());
                }

                System.out.println("\nSeats: ");
                try{
                    car.setSeats(input.nextInt());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
                input.nextLine();

                System.out.println("\nFuel type: ");
                try {
                    car.setFuelType(input.nextLine());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

                System.out.println("\nMileage: ");
                try {
                    car.setMileage(input.nextInt());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

                System.out.println("\nAvailability: ");
                car.setAvailability(input.nextInt());

                System.out.println("\nPrice per day: ");
                try {
                    car.setPrice(input.nextInt());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
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

                    // Create a PreparedStatement to execute the SQL statement
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

                    // Execute the INSERT statement
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
