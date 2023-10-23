package Database;

import CustomerAccessEntities.signUpEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mySql {
    signUpEntity signUp = new signUpEntity();


    public void getConnection(){
        try {
            String JdbcURL ="jdbc:mysql://localhost:3306/customerDetails";
            String Username ="root";
            String Password = "Harmesh26@";

            Connection connection = DriverManager.getConnection(JdbcURL, Username, Password);
            String name = signUp.getname();
            String email = signUp.getGmail();
            double phone = signUp.getNumber();
            String password = signUp.getPassword();

            String sql = "INSERT INTO userdetails(user_name, user_email, user_phone, user_password) VALUES (?, ?, ?, ?)";
            // Now you can use the 'connection' to perform database operations
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setDouble(3, phone);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
            // Don't forget to close the connection when done
            System.out.println("Successfully saved nto database");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}



