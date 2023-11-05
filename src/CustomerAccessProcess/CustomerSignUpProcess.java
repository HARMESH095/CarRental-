package CustomerAccessProcess;

import Entity.CustomerSignUpEntity;
import DatabaseConnection.MysqlConnectionCustomerCredentials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerSignUpProcess {
    private final Scanner input = new Scanner(System.in);
    private final CustomerSignUpEntity signUp = new CustomerSignUpEntity();

    public void register() {
        MysqlConnectionCustomerCredentials mySqlConnection = new MysqlConnectionCustomerCredentials();

        try {
            System.out.println("---------- SIGNUP ----------");

            System.out.print("NAME: ");
            signUp.setName(input.nextLine());

            System.out.print("GMAIL: ");
            signUp.setGmail(input.nextLine());

            System.out.print("PHONE NUMBER: ");
            signUp.setNumber(input.nextLine());

            int attempts = 3;
            while (attempts > 0) {
                try {
                    System.out.print("Enter password: ");
                    String password = input.nextLine();
                    if (!signUp.passwordValidate(password)) {
                        System.out.println("Password does not meet the criteria.");
                        continue;
                    }

                    System.out.print("Re-enter Password: ");
                    String reEnteredPassword = input.nextLine();

                    if (passwordMismatch(password, reEnteredPassword)) {
                        System.out.println("Password Not Matching. You have " + (attempts - 1) + " attempts remaining.");
                        attempts--;
                    } else {

                        try (Connection connection = mySqlConnection.getConnection()) {
                            String sql = "INSERT INTO userdetails(user_name, user_email, user_phone, user_password) VALUES (?, ?, ?, ?)";
                            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                                preparedStatement.setString(1, signUp.getName());
                                preparedStatement.setString(2, signUp.getGmail());
                                preparedStatement.setString(3, signUp.getNumber());
                                preparedStatement.setString(4, password);
                                preparedStatement.executeUpdate();
                            }
                            System.out.println(signUp.getName() + " this is your username");
                        } catch (SQLException e) {
                            System.err.println("An error occurred during registration: " + e.getMessage());
                        }
                        break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (attempts == 0) {
                System.out.println("Registration failed after 3 unsuccessful attempts.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean passwordMismatch(String password, String reEnteredPassword) {
        return !password.equals(reEnteredPassword);
    }
}
