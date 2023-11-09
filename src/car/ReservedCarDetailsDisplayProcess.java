package car;

import java.sql.*;
import java.util.Scanner;

import DatabaseConnection.MysqlConnectionCarReservationDetails;
import Entity.CarReservationEntity;
import main.UsernamePasswordMatch;
public class ReservedCarDetailsDisplayProcess {

    Scanner input = new Scanner(System.in);





        public boolean DisplayCarReservations(String username){

        UsernamePasswordMatch usernamePasswordMatch = new UsernamePasswordMatch();
        System.out.println("\nEnter your account passcode to Display registered vehicles\n");


        System.out.println("Password");
        String enteredPassword = input.nextLine();
        if(usernamePasswordMatch.check(username,enteredPassword)){
            display(username);
            return true;
        }
        else{
            System.out.println("Entered Wrong Password");
            return false;
        }



        }
        public void display(String username)  {

            try {
                MysqlConnectionCarReservationDetails mysqlConnectionCarReservationDetails = new MysqlConnectionCarReservationDetails();
                Connection connection = mysqlConnectionCarReservationDetails.getConnection();

                try {
                    String sql = "SELECT * FROM car_reservations WHERE reg_username = ?";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                        CarReservationEntity carReserveRegisterEntity = new CarReservationEntity();
                        preparedStatement.setString(1, username);
                        ResultSet resultSet = preparedStatement.executeQuery();


                        while (resultSet.next()) {


                            carReserveRegisterEntity.setCarReserveRegister(
                                    resultSet.getString("name"),
                                    resultSet.getString("date_of_birth"),
                                    resultSet.getString("gender").charAt(0),
                                    resultSet.getDouble("license_number"),
                                    resultSet.getString("residential_address"),
                                    resultSet.getString("number"),
                                    resultSet.getString("emergency_number"),
                                    resultSet.getString("from_date"),
                                    resultSet.getInt("days"),
                                    resultSet.getString("address"),
                                    resultSet.getString("reg_car")

                            );
                            System.out.println("\nCar reservation details for user: " + carReserveRegisterEntity.getName());

                            System.out.println("\nLICENSE NUMBER : "+ carReserveRegisterEntity.getLicenseNumber());
                            System.out.println("\nRESIDENTIAL ADDRESS : " + carReserveRegisterEntity.getResidentialAddress());
                            System.out.println("\nFROM DATE : " + carReserveRegisterEntity.getFromDate());
                            System.out.println("\nNO OF DAYS : "+ carReserveRegisterEntity.getDays());
                            System.out.println("\nTO ADDRESS : "+ carReserveRegisterEntity.getAddress());
                            System.out.println("\nREGISTERED CAR IDS : "+ carReserveRegisterEntity.getReg_car());
                            System.out.println("\n");

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
