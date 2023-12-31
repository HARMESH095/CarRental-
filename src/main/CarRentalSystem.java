package main;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import EmployeeAccess.*;
import CustomerAccessProcess.*;
import car.*;
import EmployeeAccess.Backend.CarDetailsUploadProcess;

public class CarRentalSystem {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CustomerSignUpProcess signup = new CustomerSignUpProcess();
        CustomerLoginProcess login = new CustomerLoginProcess();
        EmployeeLoginProcess employeeLoginProcess = new EmployeeLoginProcess();
        CarDetailsDisplayProcess displayCarDetails = new CarDetailsDisplayProcess();
        CarReservationProcess carSelection = new CarReservationProcess();
        CarDetailsUploadProcess uploadCars = new CarDetailsUploadProcess();
        ReservedCarDetailsDisplayProcess reservedCarDetails = new ReservedCarDetailsDisplayProcess();
        CarReservationModificationProcess manipulateData = new CarReservationModificationProcess();
        String name = null;

        while (true) {
            System.out.println("\n ---------- WELCOME TO CAR RENTAL SYSTEM ----------\n");
            System.out.println(" ---------- CUSTOMER OR FACULTY ----------\n");
            System.out.println(" Enter your choice:");
            System.out.println(" 1. Customer");
            System.out.println(" 2. Faculty");
            System.out.println(" 3. Exit");

            try {
                int customerFacultyChoice = input.nextInt();


                if (customerFacultyChoice == 1) {
                    System.out.println("\n ---------- LOGIN / SIGNUP ----------\n");
                    System.out.println(" 1. SIGNUP (If you are new to this system) ");
                    System.out.println(" 2. LOGIN (Already a USER)");
                    System.out.println(" 3. Back");
                    System.out.println(" ENTER YOUR CHOICE (1 or 2)");

                    int accessChoice = input.nextInt();

                    switch (accessChoice) {
                        case 1:

                            signup.register();
                            break;
                        case 2:

                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Entered Wrong Value");
                    }

                    while (name != null) {
                        System.out.println("\n OPTIONS : \n 1. Reserve Car\n 2. Display Car Details\n 3. Change Reservation / Details\n 4. Logout");

                        int option = input.nextInt();
                        if (option == 1) {
                            System.out.println("\n ---------- Car Details ----------\n");
                            displayCarDetails.display();
                            carSelection.databaseIntoMap();
                            carSelection.SelectCar("adsad");

                        } else if (option == 2) {


                        } else if (option == 3) {
                            System.out.println("1. Change No of days\n 2. Change Reserved Car\n 3. Change Reservation Date\n 4. Delete Reservation\n Enter which one you want to change:");
                            int choice = input.nextInt();
                            switch (choice) {
                                case 1:
                                    try {
                                        manipulateData.changeNumberOfDays(name);
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;
                                case 2:
                                    try {
                                        manipulateData.changeReservedCar(name);
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;
                                case 3:
                                    try {
                                        manipulateData.changeReservationDate(name);
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;
                                case 4:
                                    try {
                                        manipulateData.deleteReservation(name);
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;
                                default:
                                    System.out.println("Entered Wrong Value");
                            }
                        } else if (option == 4) {
                            System.out.println("You have successfully logged out.");
                            name = null;
                        } else {
                            System.out.println(" ---------- Entered Wrong Value ----------");
                        }
                    }
                } else if (customerFacultyChoice == 2) {
                    if (employeeLoginProcess.userPassCheck()) {
                        System.out.println(" ");
                        while (true) {
                            System.out.println("Click enter to upload cars or type \"exit\" to logout");
                            input.nextLine();
                            String employeeChoice = input.nextLine().toLowerCase();
                            if (employeeChoice.equals("exit")) {
                                System.out.println("Logged out");
                                break;
                            } else {
                                uploadCars.entry();
                            }
                        }
                    } else {
                        System.out.println(" ");
                    }
                } else if (customerFacultyChoice == 3) {
                    break;
                } else {
                    System.out.println("Entered Wrong Value");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entered wrong Value");

            }
        }
    }





}
