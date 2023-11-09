package main;

import DatabaseConnection.MysqlConnectionCustomerCredentials;

import java.sql.*;
import java.util.HashMap;

public class UsernamePasswordMatch {


    public boolean check(String username , String password) {
        final HashMap<String, String> UserPasswordMap = new HashMap<>();

        try {
            MysqlConnectionCustomerCredentials mysqlConnectionCustomerCredentials = new MysqlConnectionCustomerCredentials();
            Connection connection = mysqlConnectionCustomerCredentials.getConnection();

            try {
                String sql = "SELECT user_name, user_password FROM userdetails";
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                try {
                    while (resultSet.next()) {
                        String Username = resultSet.getString("user_name");
                        String Password = resultSet.getString("user_password");
                        UserPasswordMap.put(Username, Password);
                    }
                } catch (Exception e) {
                    System.out.println("Database hashmap error");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (UserPasswordMap.containsKey(username)) {
            if (UserPasswordMap.get(username).equals(password)) {

                return true;
            } else {
                System.out.println("Incorrect Password");
                return false;
            }

        }
        else{
            System.out.println("Incorrect Username");
            return false;
        }


    }


}
