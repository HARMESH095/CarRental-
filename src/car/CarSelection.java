package car;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import DatabaseConnection.MysqlConnectionCarDetails;


public class CarSelection {
    ArrayList<Integer> SelectedCars = new ArrayList<>();
    Map<Integer, List<carEntity>> carMap = new HashMap<>(); // Use carEntity in the map
    CarReserveRegisterEntity carReserveRegisterEntity = new CarReserveRegisterEntity();
    Scanner input = new Scanner(System.in);
    private final HashMap<String, String> UserPasswordMap = new HashMap<>();

    public void databaseIntoMap(){
        MysqlConnectionCarDetails mysqlConnectionCarDetails = new MysqlConnectionCarDetails();


        try {
            Connection connection = mysqlConnectionCarDetails.getConnection();



            try {
                String sql ="SELECT * FROM cardetails";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    carEntity car = new carEntity();
                    car.setCarDetails(
                            resultSet.getInt("CarId"),
                            resultSet.getString("model"),
                            resultSet.getString("make"),
                            resultSet.getInt("yearOfMake"),
                            resultSet.getString("color"),
                            resultSet.getString("plateNumber"),
                            resultSet.getInt("seats"),
                            resultSet.getString("fuelType"),
                            resultSet.getInt("mileage"),
                            resultSet.getInt("availability"),
                            resultSet.getInt("price")
                    );

                    int carId = car.getCarId();
                    if (carMap.containsKey(carId)) {
                        carMap.get(carId).add(car);
                    } else {
                        List<carEntity> carList = new ArrayList<>();
                        carList.add(car);
                        carMap.put(carId, carList);
                    }
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            }catch (Exception e) {
                System.out.println("Problem entering details into map error: "+ e);

            }


        }catch (Exception e) {
            System.out.println("Problem connecting with database error : "+ e);
        }





    }

    public void SelectCar(){


        while (true) {
            System.out.println("Enter the Unique carId mentioned on above of car for Selection");
            int carChoiceId = input.nextInt();

            if (carMap.containsKey(carChoiceId)) {
                SelectedCars.add(carChoiceId);
                System.out.println("Car registered.");
            } else {
                System.out.println("Car not found.");
            }

            System.out.println("Do you want to add more (yes/no)?");
            String response = input.next();

            if ("no".equalsIgnoreCase(response)) {
                break; // Exit the loop if the user doesn't want to add more cars.
            }
        }


    }

    public void carReservation() {
        StringBuilder reservedCar = new StringBuilder();
        for (Integer carId : SelectedCars) {
            reservedCar.append(carId).append(",");
        }
        System.out.println("Enter Details for registration");
        try {

            System.out.println("Enter your Full name : ");
            input.nextLine();
            carReserveRegisterEntity.setName(input.nextLine());
            System.out.println("DATE OF BIRTH : ");
            carReserveRegisterEntity.setDateOfBirth(input.nextLine());
            System.out.println("GENDER (M/F): ");
            char gender = input.nextLine().charAt(0);
            carReserveRegisterEntity.setGender(gender);
            System.out.println("LICENSE NUMBER : ");
            carReserveRegisterEntity.setLicenseNumber(input.nextDouble());
            input.nextLine(); // Consume the newline character
            System.out.println("RESIDENTIAL ADDRESS : ");
            carReserveRegisterEntity.setResidentialAddress(input.nextLine());
            System.out.println("PHONE NUMBER : ");
            carReserveRegisterEntity.setNumber(input.nextDouble());
            input.nextLine(); // Consume the newline character
            System.out.println("EMERGENCY NUMBER : ");
            carReserveRegisterEntity.setEmergencyNumber(input.nextDouble());
            input.nextLine(); // Consume the newline character
            System.out.println("FROM WHEN YOU NEED CAR DATE : ");
            carReserveRegisterEntity.setFromDate(input.nextLine());
            System.out.println("HOW MANY DAYS RENT: ");
            carReserveRegisterEntity.setDays(input.nextInt());
            input.nextLine(); // Consume the newline character
            System.out.println("Enter the address where you will use the vehicle: ");
            carReserveRegisterEntity.setAddress(input.nextLine());
            System.out.println("Enter Your username to complete the registration");
            System.out.println("USERNAME : ");
            carReserveRegisterEntity.setUsername(input.nextLine());
            System.out.println("PASSWORD : ");
            carReserveRegisterEntity.setPassword(input.nextLine());

            try{
                mySql.setDatabaseJdbcURL("jdbc:mysql://localhost:3306/customerDetails");
                mySql.setdatabaseUsername("root");
                mySql.setDatabasePassword("Harmesh26@");
                try (Connection connection = DriverManager.getConnection(mySql.getDatabaseJdbcURL(), mySql.getDatabaseUsername(), mySql.getDatabasePassword())) {
                    mySql.setInputSql("SELECT user_name, user_password FROM userdetails");
                    try (Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(mySql.getInputSql())) {
                        while (resultSet.next()) {
                            String username = resultSet.getString("user_name");
                            String password = resultSet.getString("user_password");
                            UserPasswordMap.put(username, password);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error while querying the database: " + e);
                    }
                } catch (SQLException e) {
                    System.out.println("Failed to connect to the MySQL database: " + e);
                }
                if (UserPasswordMap.containsKey(carReserveRegisterEntity.getUsername())) {
                    if (carReserveRegisterEntity.getPassword().equals(UserPasswordMap.get(carReserveRegisterEntity.getUsername()))) {
                        System.out.println("Successfully logged in");
                    } else {
                        System.out.println("Password mismatch");
                        }
                } else {
                    System.out.println("Username not found");

                }


            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            String reservedCarString = reservedCar.toString();
            mySql.setDatabaseJdbcURL("jdbc:mysql://localhost:3306/Reservation");
            mySql.setdatabaseUsername("root");
            mySql.setDatabasePassword("Harmesh26@");
            Connection connection = DriverManager.getConnection(mySql.getDatabaseJdbcURL(), mySql.getDatabaseUsername(), mySql.getDatabasePassword());

            mySql.setInputSql("INSERT INTO car_reservations (name, date_of_birth, gender, license_number, residential_address, number, emergency_number, from_date, days, address, reservedCar,registered_username, registered_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");

            PreparedStatement preparedStatement = connection.prepareStatement(mySql.getInputSql());
            preparedStatement.setString(1, carReserveRegisterEntity.getName());
            preparedStatement.setString(2, carReserveRegisterEntity.getDateOfBirth());
            preparedStatement.setString(3, String.valueOf(carReserveRegisterEntity.getGender()));
            preparedStatement.setDouble(4, carReserveRegisterEntity.getLicenseNumber());
            preparedStatement.setString(5, carReserveRegisterEntity.getResidentialAddress());
            preparedStatement.setDouble(6, carReserveRegisterEntity.getNumber());
            preparedStatement.setDouble(7, carReserveRegisterEntity.getEmergencyNumber());
            preparedStatement.setString(8, carReserveRegisterEntity.getFromDate());
            preparedStatement.setInt(9, carReserveRegisterEntity.getDays());
            preparedStatement.setString(10, carReserveRegisterEntity.getAddress());
            preparedStatement.setString(11, reservedCarString);
            preparedStatement.setString(12,carReserveRegisterEntity.getUsername());
            preparedStatement.setString(13,carReserveRegisterEntity.getPassword());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Car reservation successful for " + carReserveRegisterEntity.getName());
            } else {
                System.out.println("Car reservation failed.");
            }

            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error connecting with the database: " + e);
        }

        try {
            mySql.setDatabaseJdbcURL("jdbc:mysql://localhost:3306/car");
            mySql.setdatabaseUsername("root");
            mySql.setDatabasePassword("Harmesh26@");
            Connection connection = DriverManager.getConnection(mySql.getDatabaseJdbcURL(), mySql.getDatabaseUsername(), mySql.getDatabasePassword());

            // Check if the selected cars are available
            boolean allCarsAvailable = true;
            int totalAmount = 0;
            for (Integer carId : SelectedCars) {
                // Check if the car is available in the database
                String checkAvailabilitySql = "SELECT availability, price FROM cardetails WHERE CarId = ?";
                PreparedStatement availabilityStatement = connection.prepareStatement(checkAvailabilitySql);
                availabilityStatement.setInt(1, carId);
                ResultSet availabilityResult = availabilityStatement.executeQuery();

                if (availabilityResult.next()) {
                    int availability = availabilityResult.getInt("availability");
                    int price = availabilityResult.getInt("price");

                    if (availability > 0) {
                        totalAmount += price;
                        // Subtract availability of the selected car
                        availability--;
                        // Update the availability in the database
                        String updateAvailabilitySql = "UPDATE cardetails SET availability = ? WHERE CarId = ?";
                        PreparedStatement updateAvailabilityStatement = connection.prepareStatement(updateAvailabilitySql);
                        updateAvailabilityStatement.setInt(1, availability);
                        updateAvailabilityStatement.setInt(2, carId);
                        updateAvailabilityStatement.executeUpdate();
                    } else {
                        allCarsAvailable = false;
                    }
                } else {
                    allCarsAvailable = false;
                }
            }

            if (allCarsAvailable) {
                System.out.println("Car reservation successful for " + carReserveRegisterEntity.getName());
                System.out.println("Total amount: Rupees " + totalAmount);
            } else {
                System.out.println("Car reservation failed. Some selected cars are not available.");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Error connecting with the database: " + e);
        }
    }

}


