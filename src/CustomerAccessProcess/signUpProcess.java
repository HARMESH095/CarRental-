package CustomerAccessProcess;
import CustomerAccessEntities.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import Database.*;
public class signUpProcess {
    mySqlEntity entries = new mySqlEntity();
    Scanner input = new Scanner(System.in);
    signUpEntity signUp = new signUpEntity();

    public void register() {
        try {
            String JdbcURL ="jdbc:mysql://localhost:3306/customerDetails";
            String Username ="root";
            String Password = "Harmesh26@";

            System.out.println("Enter your name");
            signUp.setName(input.nextLine());

            System.out.println("enter your number");
            signUp.setNumber(input.nextDouble());

            input.nextLine();

            System.out.println("Enter gmail :");
            signUp.setGmail(input.nextLine());

            passwordCheck();

            Connection connection = DriverManager.getConnection(JdbcURL, Username, Password);
            String sql = "INSERT INTO userdetails(user_name, user_email, user_phone, user_password) VALUES (?, ?, ?, ?)";
            // Now you can use the 'connection' to perform database operations
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, signUp.getname());
            preparedStatement.setString(2, signUp.getGmail());
            preparedStatement.setDouble(3, signUp.getNumber());
            preparedStatement.setString(4, signUp.getPassword());
            preparedStatement.executeUpdate();
            System.out.println("Successfully saved into database");
            preparedStatement.close();
            connection.close();
        } catch (Exception InputMismatchException) {
            System.out.println("Wrong value");
        }
    }

    public void passwordCheck() {

        System.out.println("Enter password : ");
        signUp.setPassword(input.nextLine());

        System.out.println("reEnter Password");
        signUp.setRecheck(input.nextLine());
        if (!(signUp.getPassword().equals(signUp.getRecheck()))) {
            System.out.println("Password Not Matching\nEnter Again\n");
            passwordCheck();
        } else {
            System.out.println("Successfully registered");

        }
    }
}
