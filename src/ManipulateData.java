import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import Database.mySqlEntity;
import java.util.Scanner;


public class ManipulateData {
       Scanner input = new Scanner(System.in);
       mySqlEntity mySql = new mySqlEntity();



    public void changeReservationDate(String username) throws SQLException {
        mySql.setDatabaseJdbcURL("jdbc:mysql://localhost:3306/Reservation");
        mySql.setdatabaseUsername("root");
        mySql.setDatabasePassword("Harmesh26@");
        ReservedCarDetails reservedCarDetails = new ReservedCarDetails();
        reservedCarDetails.showDetails();
        reservedCarDetails.displayCarReservations(username);
        System.out.println("Enter the new date (YYYY-MM-DD): ");
        String newDate = input.nextLine();

        mySql.setInputSql("UPDATE car_reservations SET from_date = ? WHERE registered_username = ?");
        Connection connection = DriverManager.getConnection(mySql.getDatabaseJdbcURL(), mySql.getDatabaseUsername(), mySql.getDatabasePassword());

        try (PreparedStatement preparedStatement = connection.prepareStatement(mySql.getInputSql())) {
            preparedStatement.setString(1, newDate);
            preparedStatement.setString(2, username);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Reservation date updated successfully.");
            } else {
                System.out.println("Failed to update reservation date.");
            }
        }
    }
    public void changeReservedCar(String username) throws SQLException {
        mySql.setDatabaseJdbcURL("jdbc:mysql://localhost:3306/Reservation");
        mySql.setdatabaseUsername("root");
        mySql.setDatabasePassword("Harmesh26@");
        ReservedCarDetails reservedCarDetails = new ReservedCarDetails();
        reservedCarDetails.showDetails();
        reservedCarDetails.displayCarReservations(username);
        System.out.println("Enter the new car ID for reservation: ");
        int newCarId = input.nextInt();

        mySql.setInputSql("UPDATE car_reservations SET reservedCar = ? WHERE registered_username = ?");
        Connection connection = DriverManager.getConnection(mySql.getDatabaseJdbcURL(), mySql.getDatabaseUsername(), mySql.getDatabasePassword());

        try (PreparedStatement preparedStatement = connection.prepareStatement(mySql.getInputSql())) {
            preparedStatement.setInt(1, newCarId);
            preparedStatement.setString(2, username);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Reserved car updated successfully.");
            } else {
                System.out.println("Failed to update reserved car.");
            }
        }
    }
    public void changeNumberOfDays(String username) throws SQLException {
        mySql.setDatabaseJdbcURL("jdbc:mysql://localhost:3306/Reservation");
        mySql.setdatabaseUsername("root");
        mySql.setDatabasePassword("Harmesh26@");
        ReservedCarDetails reservedCarDetails = new ReservedCarDetails();
        reservedCarDetails.showDetails();
        reservedCarDetails.displayCarReservations(username);
        System.out.println("Enter the new number of days: ");
        int newDays = input.nextInt();

        mySql.setInputSql("UPDATE car_reservations SET days = ? WHERE registered_username = ?");
        Connection connection = DriverManager.getConnection(mySql.getDatabaseJdbcURL(), mySql.getDatabaseUsername(), mySql.getDatabasePassword());

        try (PreparedStatement preparedStatement = connection.prepareStatement(mySql.getInputSql())) {
            preparedStatement.setInt(1, newDays);
            preparedStatement.setString(2, username);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Number of days updated successfully.");
            } else {
                System.out.println("Failed to update number of days.");
            }
        }
    }
    public void deleteReservation(String username) throws SQLException {
        mySql.setDatabaseJdbcURL("jdbc:mysql://localhost:3306/Reservation");
        mySql.setdatabaseUsername("root");
        mySql.setDatabasePassword("Harmesh26@");
        ReservedCarDetails reservedCarDetails = new ReservedCarDetails();
        reservedCarDetails.showDetails();
        reservedCarDetails.displayCarReservations(username);
        mySql.setInputSql("DELETE FROM car_reservations WHERE registered_username = ?");
        Connection connection = DriverManager.getConnection(mySql.getDatabaseJdbcURL(), mySql.getDatabaseUsername(), mySql.getDatabasePassword());

        try (PreparedStatement preparedStatement = connection.prepareStatement(mySql.getInputSql())) {
            preparedStatement.setString(1, username);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Reservation deleted successfully.");
            } else {
                System.out.println("Failed to delete reservation.");
            }
        }
    }




}
