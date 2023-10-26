package CustomerAccessProcess;

import CustomerAccessEntities.SignUpEntity;
import DatabaseConnection.MysqlConnectionUserDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUpProcess {
    private final Scanner input = new Scanner(System.in);
    private final SignUpEntity signUp = new SignUpEntity();

    public void register() {
        MysqlConnectionUserDetails mySqlConnection = new MysqlConnectionUserDetails();

        System.out.println("---------- SIGNUP ----------");
        System.out.print("NAME: ");
        signUp.setName(input.nextLine());

        System.out.print("GMAIL: ");
        signUp.setGmail(input.nextLine());

        System.out.print("PHONE NUMBER: ");
        signUp.setNumber(input.nextDouble());
        input.nextLine();

        int attempts = 3; // Set the number of password input attempts
        while (attempts > 0) {
            System.out.print("Enter password: ");
            String password = input.nextLine();

            System.out.print("Re-enter Password: ");
            String reEnteredPassword = input.nextLine();

            if (password(password, reEnteredPassword)) {
                System.out.println("Password Not Matching. You have " + (attempts - 1) + " attempts remaining.");
                attempts--;
            } else {
                // Passwords match, continue with registration
                try (Connection connection = mySqlConnection.getConnection()) {
                    String sql = "INSERT INTO userdetails(user_name, user_email, user_phone, user_password) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, signUp.getName());
                        preparedStatement.setString(2, signUp.getGmail());
                        preparedStatement.setDouble(3, signUp.getNumber());
                        preparedStatement.setString(4, signUp.getPassword());
                        preparedStatement.executeUpdate();
                    }
                    System.out.println("Successfully saved into the database");
                } catch (SQLException e) {
                    System.err.println("An error occurred during registration: " + e.getMessage());
                }
                break; // Registration is successful, exit the loop
            }
        }
        if (attempts == 0) {
            System.out.println("Registration failed after 3 unsuccessful attempts.");
        }
    }

    public boolean password(String password, String reEnteredPassword) {
        return !password.equals(reEnteredPassword);
    }
}
