package car;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

import DatabaseConnection.MysqlConnectionCarReservationDetails;
import Entity.CarReservationEntity;
public class ReservedCarDetailsDisplayProcess {
    private final HashMap<String, String> UserPasswordMap = new HashMap<>();
    Scanner input = new Scanner(System.in);

    public void showDetails(){
        try {
        MysqlConnectionCarReservationDetails mysqlConnectionCarReservationDetails = new MysqlConnectionCarReservationDetails();
        Connection connection = mysqlConnectionCarReservationDetails.getConnection();

        try{
            String sql ="SELECT reg_username, reg_password FROM car_reservations";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            try{
                while(resultSet.next()){
                    String username = resultSet.getString("reg_username");
                    String password = resultSet.getString("reg_password");
                    UserPasswordMap.put(username,password);
                }
            }catch (Exception e){
                System.out.println("Database hashmap error");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public void getUserPass(){
        System.out.println("Enter Registered Username and passcode to Display registered vehicles\n");
        System.out.println("USERNAME : ");
        String enteredUsername = input.nextLine();
        System.out.println("Password");
        String enteredPassword = input.nextLine();

        try{
            if(UserPasswordMap.containsKey(enteredUsername)){
                if(UserPasswordMap.get(enteredUsername).equals(enteredPassword)){
                    displayCarReservations(enteredUsername);
                }else{
                    System.out.println("Incorrect Password");
                }

                }

            } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        }
        public void displayCarReservations(String username) throws SQLException {

            try {
                MysqlConnectionCarReservationDetails mysqlConnectionCarReservationDetails = new MysqlConnectionCarReservationDetails();
                Connection connection = mysqlConnectionCarReservationDetails.getConnection();

                try {
                    String sql = "SELECT * FROM car_reservations WHERE reg_username = ?";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                        CarReservationEntity carReserveRegisterEntity = new CarReservationEntity();
                        preparedStatement.setString(1, username);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        System.out.println("Car reservation details for user: " + username);
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
