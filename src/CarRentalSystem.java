import java.sql.SQLException;
import java.util.Scanner;
import EmployeeAccess.*;
import CustomerAccessProcess.*;
import car.*;
import Backend.UploadCars;


public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        signUpProcess signup = new signUpProcess();
        loginProcess login = new loginProcess();
        EmployeeLoginProcess employeeLoginProcess = new EmployeeLoginProcess();
        DisplayCarDetails displayCarDetails = new DisplayCarDetails();
        CarSelection carSelection = new CarSelection();
        UploadCars uploadCars = new UploadCars();
        ReservedCarDetails reservedCarDetails = new ReservedCarDetails();
        ManipulateData manipulateData = new ManipulateData();
        String name=null;

        System.out.println(" ---------- WELCOME TO CAR RENTAL SYSTEM ----------\n\n\n");
        System.out.println(" ---------- CUSTOMER OR FACULTY ----------");
        System.out.println(" Enter your choice \n 1. Customer\n 2. Faculty");

        int customerFacultyChoice = input.nextInt();
        if(customerFacultyChoice == 1){
            System.out.println(" ---------- LOGIN / SIGNUP ----------\n");
            System.out.println(" 1. SIGNUP (If you are new to this system) ");
            System.out.println(" 2. LOGIN (Already a USER)");
            System.out.println(" ENTER YOUR CHOICE (1 or 2)");
            int accessChoice = input.nextInt();

            switch(accessChoice){
                case 1:
                    signup.register();
                    break;
                case 2:
                    name = login.logIn();

                    break;
                default:
                    System.out.println("Entered Wrong Value");
            }
            while(true) {
                System.out.println(" 1. Reserve Car\n 2. Display Car Details\n 3. Change Reservation / Details\n 4. Logout");

                int option = input.nextInt();
                if (option == 1) {
                    displayCarDetails.display();
                    carSelection.databaseIntoMap();
                    carSelection.SelectCar();
                    carSelection.carReservation();
                } else if (option == 2) {
                    reservedCarDetails.showDetails();
                    reservedCarDetails.getUserPass();

                } else if (option == 3) {

                        System.out.println("1. Change No of days\n 2. Change Reserved Car\n 3.Change Reservation Date\n 4. Delete Reservation\n  Enter which one you want to change : ");
                        int choice = input.nextInt();
                        switch (choice){
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


                        }



                } else if (option == 4) {
                    System.out.println("Logged out");
                    break;
                } else {
                    System.out.println("wrong value");
                }
            }

        } else if (customerFacultyChoice == 2) {

            employeeLoginProcess.userPassCheck(); // Pass the employeeLoginEntity object

            while(true){
                System.out.println("Enter 1 for UPLOAD CARS / Enter 2 for EXIT");
                int uploadOrLogout = input.nextInt();
                if(uploadOrLogout == 1){

                    uploadCars.entry();
                }
                else if(uploadOrLogout == 2){
                    System.out.println("Logged out");
                    break;
                }
                else{
                    System.out.println("Wrong value");
                }
            }


        }
        else{
            System.out.println(" ENTERED WRONG VALUE ");

        }


    }
}
