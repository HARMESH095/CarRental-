package Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import car.carEntity; // Import your CarEntity class
import DatabaseConnection.MysqlConnectionCarDetails;

public class UploadCars {
    Scanner input = new Scanner(System.in);
    carEntity car = new carEntity();
    Connection connection = null; // Declare a connection object

    public void entry() {


        try {
            MysqlConnectionCarDetails mysqlConnectionCarDetails = new MysqlConnectionCarDetails();
            connection = mysqlConnectionCarDetails.getConnection(); // Get the database connection
        } catch (Exception e) {
            System.out.println("Database connection error: " + e);
            return; // Exit the method if there's a connection error
        }

        while (true) {
            System.out.println("Enter car details or type 'exit' to finish.");
            String exit = input.nextLine();

            if (exit.equals("exit")) {
                break;
            }

            try {
                System.out.println("UPLOAD CARS\n\n");

                System.out.println("Car ID: ");
                car.setCarId(input.nextInt());
                input.nextLine(); // Consume the newline character
                System.out.println("Model: ");
                car.setModel(input.nextLine());
                System.out.println("Manufacturer: ");
                car.setMake(input.nextLine());
                System.out.println("Year of make: ");
                car.setYearOfMake(input.nextInt());
                input.nextLine(); // Consume the newline character
                System.out.println("Color: ");
                car.setColor(input.nextLine());
                System.out.println("Plate Number: ");
                car.setPlateNumber(input.nextLine());
                System.out.println("Seats: ");
                car.setSeats(input.nextInt());
                input.nextLine(); // Consume the newline character
                System.out.println("Fuel type: ");
                car.setFuelType(input.nextLine());
                System.out.println("Mileage: ");
                car.setMileage(input.nextInt());
                System.out.println("Availability: ");
                car.setAvailability(input.nextInt());
                System.out.println("Price per day: ");
                car.setPrice(input.nextInt());
                databaseImport();
            } catch (Exception e) {
                System.out.println("Value error: " + e);
            }
        }
    }

    public void databaseImport() {
        try {
            // Create an SQL INSERT statement
            String sql = "INSERT INTO cardetails (carId, model, make, yearOfMake, color, plateNumber, seats, fuelType, mileage, availability, price) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
    }
}
