package CustomerAccessProcess;

import CustomerAccessEntities.UserLoginEntity;
import Database.mySqlEntity;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class loginProcess {
    private final HashMap<String, String> UserPasswordMap = new HashMap<>();
    private final mySqlEntity mysql = new mySqlEntity();
    private final UserLoginEntity login = new UserLoginEntity();
    private final Scanner input = new Scanner(System.in);

    public String logIn() {
        System.out.println("Username : ");
        login.setUsername(input.nextLine());
        System.out.println("Passcode : ");
        login.setPassword(input.nextLine());
        String usernamefinal = null;


        try {
            mysql.setDatabaseJdbcURL("jdbc:mysql://localhost:3306/customerDetails");
            mysql.setdatabaseUsername("root");
            mysql.setDatabasePassword("Harmesh26@");

            try (Connection connection = DriverManager.getConnection(mysql.getDatabaseJdbcURL(), mysql.getDatabaseUsername(), mysql.getDatabasePassword())) {
                mysql.setInputSql("SELECT user_name, user_password FROM userdetails");
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(mysql.getInputSql())) {
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

        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }

        if (UserPasswordMap.containsKey(login.getUsername())) {
            if (login.getPassword().equals(UserPasswordMap.get(login.getUsername()))) {
                System.out.println("Successfully logged in");
                usernamefinal = login.getUsername();
            } else {
                System.out.println("Password mismatch");
                logIn();
            }
        } else {
            System.out.println("Username not found");
            logIn();
        }
        return usernamefinal;
    }





}
