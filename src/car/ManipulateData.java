package car;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.Scanner;

import DatabaseConnection.MysqlConnectionCarReservationDetails;
import car.ReservedCarDetails;

public class ManipulateData {
       Scanner input = new Scanner(System.in);
       MysqlConnectionCarReservationDetails mysqlConnectionCarReservationDetails = new MysqlConnectionCarReservationDetails();
    public void changeReservationDate(String username) throws SQLException {
        try{
            Connection connection = mysqlConnectionCarReservationDetails.getConnection();

            try{
                ReservedCarDetails reservedCarDetails = new ReservedCarDetails();
                reservedCarDetails.showDetails();
                reservedCarDetails.displayCarReservations(username);
                System.out.println("Enter the new date (YYYY-MM-DD): ");
                String newDate = input.nextLine();

                String sql = "UPDATE car_reservations SET from_date = ? WHERE registered_username = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql) ){
                    preparedStatement.setString(1, newDate);
                    preparedStatement.setString(2, username);
                    int rowsUpdated = preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Reservation date updated successfully.");
                    } else {
                        System.out.println("Failed to update reservation date.");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

    }
    public void changeReservedCar(String username) throws SQLException {
        try{
            Connection connection = mysqlConnectionCarReservationDetails.getConnection();

            try{
                ReservedCarDetails reservedCarDetails = new ReservedCarDetails();
                reservedCarDetails.showDetails();
                reservedCarDetails.displayCarReservations(username);
                System.out.println("Enter the new car ID for reservation: ");
                int newCarId = input.nextInt();

                String sql = "UPDATE car_reservations SET reservedCar = ? WHERE registered_username = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                    preparedStatement.setInt(1, newCarId);
                    preparedStatement.setString(2, username);
                    int rowsUpdated = preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Reserved car updated successfully.");
                    } else {
                        System.out.println("Failed to update reserved car.");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void changeNumberOfDays(String username) throws SQLException {
        try{
            Connection connection = mysqlConnectionCarReservationDetails.getConnection();

            try{
                ReservedCarDetails reservedCarDetails = new ReservedCarDetails();
                reservedCarDetails.showDetails();
                reservedCarDetails.displayCarReservations(username);
                System.out.println("Enter the new number of days: ");
                int newDays = input.nextInt();

                String sql = "UPDATE car_reservations SET days = ? WHERE registered_username = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, newDays);
                    preparedStatement.setString(2, username);
                    int rowsUpdated = preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Number of days updated successfully.");
                    } else {
                        System.out.println("Failed to update number of days.");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteReservation(String username) throws SQLException {
        try {
            Connection connection = mysqlConnectionCarReservationDetails.getConnection();

            try{
                ReservedCarDetails reservedCarDetails = new ReservedCarDetails();
                reservedCarDetails.showDetails();
                reservedCarDetails.displayCarReservations(username);
                String sql = "DELETE FROM car_reservations WHERE registered_username = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, username);
                    int rowsDeleted = preparedStatement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Reservation deleted successfully.");
                    } else {
                        System.out.println("Failed to delete reservation.");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }




}
