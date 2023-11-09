package main;

import CustomerAccessProcess.CustomerLoginProcess;
import CustomerAccessProcess.CustomerSignUpProcess;
import EmployeeAccess.Backend.CarDetailsUploadProcess;
import EmployeeAccess.EmployeeLoginEntity;
import EmployeeAccess.EmployeeLoginProcess;
import car.CarDetailsDisplayProcess;
import car.CarReservationModificationProcess;
import car.CarReservationProcess;
import car.ReservedCarDetailsDisplayProcess;
import main.input;

import java.sql.SQLException;
import java.util.Scanner;

public class Options {
    Scanner input = new Scanner(System.in);

    public void CustomerFaculty() {
        String username= "username";
        label:
        while(true) {
            System.out.println("\n ---------- WELCOME TO CAR RENTAL SYSTEM ----------\n");
            System.out.println(" ---------- CUSTOMER OR FACULTY ----------\n");
            System.out.println(" Enter your choice:");
            System.out.println(" 1. Customer");
            System.out.println(" 2. Faculty");
            System.out.println(" 3. Exit");

            try{

                String customerFacultyChoice = input.nextLine();

                switch (customerFacultyChoice) {
                    case "1":
                        username = Customer(username);
                        break;
                    case "2":
                        Faculty();
                        break;
                    case "3":
                        break label;
                    default:
                        System.out.println("\n !!!!!!!!!! You Have Entered Wrong Value !!!!!!!!!! \n");
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println("\n !!!!!!!!!! You Have Entered Wrong Value !!!!!!!!!! \n");
            }
        }
    }

    public void Faculty() {
        EmployeeLoginEntity employeeLoginEntity = new EmployeeLoginEntity();
        EmployeeLoginProcess employeeLoginProcess = new EmployeeLoginProcess();
        CarDetailsUploadProcess uploadCars = new CarDetailsUploadProcess();


            if (employeeLoginProcess.userPassCheck()) {


                while(true) {
                    System.out.println("\n Click enter to upload cars or type \"exit\" to logout");
                    employeeLoginEntity.setEmployeeChoice(input.nextLine());

                    if (employeeLoginEntity.getEmployeeChoice().equals("exit")) {
                        System.out.println("Logged out");
                        CustomerFaculty();
                        break;

                    } else if (employeeLoginEntity.getEmployeeChoice().equals("entry")) {
                        uploadCars.entry();
                        break;
                    } else {
                        System.out.println("\n !!!!!!!!!! You Have Entered Wrong Value !!!!!!!!!! \n");
                    }
                }

            } else {
                System.out.println(" bye");
            }

    }


    public String Customer(String username){
        CustomerSignUpProcess signup = new CustomerSignUpProcess();
        CustomerLoginProcess login = new CustomerLoginProcess();
        labelCustomer:
        while(true) {

            System.out.println("\n ---------- LOGIN / SIGNUP ----------\n");
            System.out.println(" 1. SIGNUP (If you are new to this system) ");
            System.out.println(" 2. LOGIN (Already a USER)");
            System.out.println(" 3. Back");
            System.out.println(" ENTER YOUR CHOICE (1 or 2 or 3)");

            String accessChoice = input.nextLine();

            switch (accessChoice) {
                case "1":
                    signup.register();
                    username = null;

                    break;
                case "2":
                    login.logIn();
                    break;
                case "3":
                    username = null;
                    CustomerFaculty();
                    break labelCustomer;
                default:
                    System.out.println("\n !!!!!!!!!! You Have Entered Wrong Value !!!!!!!!!! \n");
                    break;
            }
        }
        return username;
    }

    public void ModificationSelection(String username)  {

        CarReservationModificationProcess manipulateData = new CarReservationModificationProcess();

        System.out.println("1. Change No of days\n 2. Change Reserved Car\n 3. Change Reservation Date\n 4. Delete Reservation\n Enter which one you want to change:");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                try {
                    manipulateData.changeNumberOfDays(username);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                try {
                    manipulateData.changeReservedCar(username);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                try {
                    manipulateData.changeReservationDate(username);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 4:
                try{
                    manipulateData.deleteReservation(username);
                }catch (SQLException e){
                    throw new RuntimeException(e);
                }


                break;
            default:
                System.out.println("Entered Wrong Value");
        }

    }


    public void Option(String username){
        CarDetailsDisplayProcess displayCarDetails = new CarDetailsDisplayProcess();
        CarReservationProcess carSelection = new CarReservationProcess();
        ReservedCarDetailsDisplayProcess reservedCarDetails = new ReservedCarDetailsDisplayProcess();
        input input1 = new input();
        while(true) {
            System.out.println("\n OPTIONS : \n 1. Reserve a Car\n 2. Display Reserved Car Details\n 3. Change Reservation / Details\n 4. Logout");
            try {
                input1.setOptionChoice(input.nextLine());

                if (input1.getOptionChoice().equals("1")) {
                    System.out.println("\n ---------- Car Details ----------\n");
                    carSelection.SelectCar(username);
                } else if (input1.getOptionChoice().equals("2")) {
                    reservedCarDetails.DisplayCarReservations(username);
                } else if (input1.getOptionChoice().equals("3")) {
                    ModificationSelection(username);
                } else if (input1.getOptionChoice().equals("4")) {
                    System.out.println("You have successfully logged out.");
                    username = null;
                    break;
                } else {
                    System.out.println(" ---------- Entered Wrong Value ----------");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }






}
