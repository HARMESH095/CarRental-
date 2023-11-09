package car;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.Scanner;

import DatabaseConnection.MysqlConnectionCarReservationDetails;



public class CarReservationModificationProcess {
       Scanner input = new Scanner(System.in);
    ReservedCarDetailsDisplayProcess reservedCarDetails = new ReservedCarDetailsDisplayProcess();
       MysqlConnectionCarReservationDetails mysqlConnectionCarReservationDetails = new MysqlConnectionCarReservationDetails();
    public void changeReservationDate(String username) throws SQLException {
        try {
            Connection connection = mysqlConnectionCarReservationDetails.getConnection();

            try {


                if(!reservedCarDetails.DisplayCarReservations(username)){
                    System.out.println("Wrong Password");
                }

                System.out.println("Enter the reservation ID to update the date: ");
                int reservationId = input.nextInt();
                input.nextLine();

                System.out.println("Enter the new date (YYYY-MM-DD): ");
                String newDate = input.nextLine();

                String sql = "UPDATE car_reservations SET from_date = ? WHERE reg_username = ? AND reservation_id = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, newDate);
                    preparedStatement.setString(2, username);
                    preparedStatement.setInt(3, reservationId);

                    int rowsUpdated = preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Reservation date updated successfully.");
                    } else {
                        System.out.println("Failed to update reservation date. Please check the reservation ID.");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public void changeReservedCar(String username) throws SQLException {
        CarDetailsDisplayProcess carDetailsDisplayProcess = new CarDetailsDisplayProcess();
        try{
            Connection connection = mysqlConnectionCarReservationDetails.getConnection();

            try{
                System.out.println("\n Your Car Reservations \n");
                if(!reservedCarDetails.DisplayCarReservations(username)){
                    System.out.println("Wrong Password");
                }
                System.out.println("\n Choose a Car from Here \n");
                carDetailsDisplayProcess.display();
                System.out.println("Enter the new car ID for reservation: ");
                int newCarId = input.nextInt();

                String sql = "UPDATE car_reservations SET reg_car = ? WHERE reg_username = ?";
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

                if(!reservedCarDetails.DisplayCarReservations(username)){
                    System.out.println("Wrong Password");
                }
                System.out.println("Enter the new number of days: ");
                int newDays = input.nextInt();

                String sql = "UPDATE car_reservations SET days = ? WHERE reg_username = ?";

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
                if(!reservedCarDetails.DisplayCarReservations(username)){
                    System.out.println("Wrong Password");
                }
                String sql = "DELETE FROM car_reservations WHERE reg_username = ?";

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
