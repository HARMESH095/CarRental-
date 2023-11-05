package car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.CarEntity;

public class CarDetailsDisplayProcess {
    public void display() {
        try {
            String JdbcURL = "jdbc:mysql://localhost:3306/car";
            String Username = "root";
            String Password = "Harmesh26@";

            Connection connection = DriverManager.getConnection(JdbcURL, Username, Password);

            String sql = "SELECT * FROM cardetails";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();


            CarEntity carDetails = new CarEntity();
            while (resultSet.next()) {
                carDetails.setCarId(resultSet.getInt("carId"));
                carDetails.setModel(resultSet.getString("model"));
                carDetails.setMake(resultSet.getString("make"));
                carDetails.setYearOfMake(resultSet.getInt("yearOfMake"));
                carDetails.setColor(resultSet.getString("color"));
                carDetails.setPlateNumber(resultSet.getString("plateNumber"));
                carDetails.setSeats(resultSet.getInt("seats"));
                carDetails.setFuelType(resultSet.getString("fuelType"));
                carDetails.setMileage(resultSet.getInt("mileage"));
                carDetails.setAvailability(resultSet.getInt("availability"));
                carDetails.setPrice(resultSet.getInt("price"));


                System.out.println("Car ID: " + carDetails.getCarId());
                System.out.println("Model: " + carDetails.getModel());
                System.out.println("Manufacturer: " + carDetails.getMake());
                System.out.println("Year of make: " + carDetails.getYearOfMake());
                System.out.println("Color: " + carDetails.getColor());
                System.out.println("Plate Number: " + carDetails.getPlateNumber());
                System.out.println("Seats: " + carDetails.getSeats());
                System.out.println("Fuel Type: " + carDetails.getFuelType());
                System.out.println("Mileage: " + carDetails.getMileage());
                System.out.println("Availability: " + carDetails.getAvailability());
                System.out.println("Price per day: " + carDetails.getPrice());
                System.out.println();
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

