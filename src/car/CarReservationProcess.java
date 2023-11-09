package car;

import java.sql.*;
import java.util.*;

import DatabaseConnection.MysqlConnectionCarDetails;
import main.UsernamePasswordMatch;
import DatabaseConnection.MysqlConnectionCarReservationDetails;
import Entity.CarReservationEntity;
import Entity.CarEntity;


public class CarReservationProcess {
    ArrayList<Integer> SelectedCars = new ArrayList<>();
    Map<Integer, List<CarEntity>> carMap = new HashMap<>();
    CarReservationEntity carReserveRegisterEntity = new CarReservationEntity();
    Scanner input = new Scanner(System.in);


    public void databaseIntoMap(){
        MysqlConnectionCarDetails mysqlConnectionCarDetails = new MysqlConnectionCarDetails();


        try {
            Connection connection = mysqlConnectionCarDetails.getConnection();



            try {
                String sql ="SELECT * FROM cardetails";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    CarEntity car = new CarEntity();
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
                        List<CarEntity> carList = new ArrayList<>();
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

    public void SelectCar(String username){
        CarDetailsDisplayProcess carDetailsDisplayProcess = new CarDetailsDisplayProcess();
        databaseIntoMap();
        carDetailsDisplayProcess.display();


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

                if (response.equals("no")) {
                    carReservation(username);
                    break;
                }

        }


    }

    public void carReservation(String username) {
        UsernamePasswordMatch usernamePasswordMatch = new UsernamePasswordMatch();
        StringBuilder reservedCar = new StringBuilder();

        for (Integer carId : SelectedCars) {
            reservedCar.append(carId).append(" ");
        }
        if (reservedCar.isEmpty()) {
            System.out.println("You didn't reserve any car");

        } else {
            while(true) {



                    System.out.println("Enter Details for registration");
                    try {
                        try {



                            System.out.println(" Enter your Full name : ");
                            carReserveRegisterEntity.setName(input.nextLine());

                            System.out.println(" DATE OF BIRTH ( FORMAT : YYYY-MM-DD ) :");
                            carReserveRegisterEntity.setDateOfBirth(input.nextLine());

                            System.out.println(" GENDER (M/F): ");
                            char gender = input.nextLine().charAt(0);
                            carReserveRegisterEntity.setGender(gender);

                            System.out.println(" LICENSE NUMBER : ");
                            carReserveRegisterEntity.setLicenseNumber(input.nextDouble());

                            input.nextLine();

                            System.out.println(" RESIDENTIAL ADDRESS : ");
                            carReserveRegisterEntity.setResidentialAddress(input.nextLine());

                            System.out.println(" PHONE NUMBER : ");
                            carReserveRegisterEntity.setNumber(input.nextLine());

                            System.out.println(" EMERGENCY NUMBER : ");
                            carReserveRegisterEntity.setEmergencyNumber(input.nextLine());

                            System.out.println(" DATE FROM WHEN YOU NEED CAR ( FORMAT : YYYY-MM-DD ) : ");
                            carReserveRegisterEntity.setFromDate(input.nextLine());

                            System.out.println(" HOW MANY DAYS RENT: ");
                            carReserveRegisterEntity.setDays(input.nextInt());

                            input.nextLine();

                            System.out.println(" Enter the address where you will use the vehicle: ");
                            carReserveRegisterEntity.setAddress(input.nextLine());

                            System.out.println("\n Enter Your Password to complete the registration");

                            System.out.println(" PASSWORD : ");
                            carReserveRegisterEntity.setPassword(input.nextLine());
                            break;

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }

                }

                if (usernamePasswordMatch.check(username, carReserveRegisterEntity.getPassword())) {


                    String reservedCarString = reservedCar.toString();
                    try {
                        MysqlConnectionCarReservationDetails mysqlConnectionCarReservationDetails = new MysqlConnectionCarReservationDetails();
                        Connection connection = mysqlConnectionCarReservationDetails.getConnection();
                        try {
                            String sql = "INSERT INTO car_reservations (name, date_of_birth, gender, license_number, residential_address, number, emergency_number, from_date, days, address, reg_car,reg_username, reg_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";

                            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setString(1, carReserveRegisterEntity.getName());
                            preparedStatement.setString(2, carReserveRegisterEntity.getDateOfBirth());
                            preparedStatement.setString(3, String.valueOf(carReserveRegisterEntity.getGender()));
                            preparedStatement.setDouble(4, carReserveRegisterEntity.getLicenseNumber());
                            preparedStatement.setString(5, carReserveRegisterEntity.getResidentialAddress());
                            preparedStatement.setString(6, carReserveRegisterEntity.getNumber());
                            preparedStatement.setString(7, carReserveRegisterEntity.getEmergencyNumber());
                            preparedStatement.setString(8, carReserveRegisterEntity.getFromDate());
                            preparedStatement.setInt(9, carReserveRegisterEntity.getDays());
                            preparedStatement.setString(10, carReserveRegisterEntity.getAddress());
                            preparedStatement.setString(11, reservedCarString);
                            preparedStatement.setString(12, carReserveRegisterEntity.getUsername());
                            preparedStatement.setString(13, carReserveRegisterEntity.getPassword());

                            int rowsInserted = preparedStatement.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("Car reservation successful for " + carReserveRegisterEntity.getName());
                            } else {
                                System.out.println("Car reservation failed.");
                            }

                            preparedStatement.close();
                            connection.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }


                    try {
                        MysqlConnectionCarDetails mysqlConnectionCarDetails = new MysqlConnectionCarDetails();
                        Connection connection = mysqlConnectionCarDetails.getConnection();

                        boolean allCarsAvailable = true;
                        int totalAmount = 0;
                        for (Integer carId : SelectedCars) {

                            String checkAvailabilitySql = "SELECT availability, price FROM cardetails WHERE CarId = ?";
                            PreparedStatement availabilityStatement = connection.prepareStatement(checkAvailabilitySql);
                            availabilityStatement.setInt(1, carId);
                            ResultSet availabilityResult = availabilityStatement.executeQuery();

                            if (availabilityResult.next()) {
                                int availability = availabilityResult.getInt("availability");
                                int price = availabilityResult.getInt("price");

                                if (availability > 0) {
                                    totalAmount += price;

                                    availability--;

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
                }else{
                    System.out.println("Wrong");
                }
            }
            }
        }





