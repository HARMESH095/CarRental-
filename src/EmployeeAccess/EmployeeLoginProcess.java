package EmployeeAccess;

import Database.mySqlEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import  java.sql.Statement;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Scanner;

public class EmployeeLoginProcess {

    Scanner input = new Scanner(System.in);
    EmployeeLoginEntity loginEntity = new EmployeeLoginEntity();
    mySqlEntity mysql = new mySqlEntity();
    HashMap<Double, String> EmployeeCredentialsMap = new HashMap<>();
    public void userPassCheck() {
        System.out.println("Employee Id : ");
        loginEntity.setEmployeeId(input.nextDouble());
        input.nextLine();
        System.out.println("Passcode : ");
        loginEntity.setPassword(input.nextLine());



        try {
            mysql.setDatabaseJdbcURL("jdbc:mysql://localhost:3306/employee");
            mysql.setdatabaseUsername("root");
            mysql.setDatabasePassword("Harmesh26@");

            try (Connection connection = DriverManager.getConnection(mysql.getDatabaseJdbcURL(), mysql.getDatabaseUsername(), mysql.getDatabasePassword())) {
                mysql.setInputSql("SELECT Employee_Id, Employee_password FROM employeeCredentials");
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(mysql.getInputSql())) {
                    while (resultSet.next()) {
                        Double employeeId = resultSet.getDouble("Employee_Id");
                        String employeePassword = resultSet.getString("Employee_password");
                        EmployeeCredentialsMap.put(employeeId,employeePassword);
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

        if (EmployeeCredentialsMap.containsKey(loginEntity.getEmployeeId())) {
            if (loginEntity.getPassword().equals(EmployeeCredentialsMap.get(loginEntity.getEmployeeId()))) {
                System.out.println("Successfully logged in");
            } else {
                System.out.println("Password mismatch");
            }
        } else {
            System.out.println("Username not found");
        }
    }
}
