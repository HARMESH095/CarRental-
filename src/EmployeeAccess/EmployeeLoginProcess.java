package EmployeeAccess;

import DatabaseConnection.MysqlConnectionEmployeeCredentials;

import java.sql.Connection;
import java.sql.ResultSet;
import  java.sql.Statement;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Scanner;

public class EmployeeLoginProcess {

    Scanner input = new Scanner(System.in);
    EmployeeLoginEntity loginEntity = new EmployeeLoginEntity();
    Connection connection = null;
    HashMap<Double, String> EmployeeCredentialsMap = new HashMap<>();
    public void userPassCheck() {
        System.out.println("Employee Id : ");
        loginEntity.setEmployeeId(input.nextDouble());
        input.nextLine();
        System.out.println("Passcode : ");
        loginEntity.setPassword(input.nextLine());






            try {
                MysqlConnectionEmployeeCredentials mysqlConnectionEmployeeCredentials = new MysqlConnectionEmployeeCredentials();
                connection = mysqlConnectionEmployeeCredentials.getConnection();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        String sql =("SELECT Employee_Id, Employee_password FROM employeeCredentials");
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(sql) ) {
                    while (resultSet.next()) {
                        Double employeeId = resultSet.getDouble("Employee_Id");
                        String employeePassword = resultSet.getString("Employee_password");
                        EmployeeCredentialsMap.put(employeeId,employeePassword);
                    }
                } catch (SQLException e) {
                    System.out.println("Error while querying the database: " + e);
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
