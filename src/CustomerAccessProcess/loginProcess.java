package CustomerAccessProcess;

import CustomerAccessEntities.UserLoginEntity;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

import DatabaseConnection.MysqlConnectionUserDetails;

public class loginProcess {
    private final HashMap<String, String> UserPasswordMap = new HashMap<>();
    private final UserLoginEntity login = new UserLoginEntity();
    private final Scanner input = new Scanner(System.in);

    public String logIn() {
        System.out.println("Username : ");
        login.setUsername(input.nextLine());
        System.out.println("Passcode : ");
        login.setPassword(input.nextLine());
        String usernamefinal = null;


        try {
            MysqlConnectionUserDetails mysqlConnectionUserDetails = new MysqlConnectionUserDetails();
            Connection connection = mysqlConnectionUserDetails.getConnection();

            String sql = "SELECT user_name, user_password FROM userdetails";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String username = resultSet.getString("user_name");
                    String password = resultSet.getString("user_password");
                    UserPasswordMap.put(username, password);
                }
            } catch (SQLException e) {
                System.out.println("Error while querying the database: " + e);
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
