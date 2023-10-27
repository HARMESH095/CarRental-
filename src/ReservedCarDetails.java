import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class ReservedCarDetails {
    mySqlEntity mySql = new mySqlEntity();
    private final HashMap<String, String> UserPasswordMap = new HashMap<>();
    Scanner input = new Scanner(System.in);


    public void showDetails(){
        try {
        mySql.setDatabaseJdbcURL("jdbc:mysql://localhost:3306/Reservation");
        mySql.setdatabaseUsername("root");
        mySql.setDatabasePassword("Harmesh26@");


        Connection connection = DriverManager.getConnection(mySql.getDatabaseJdbcURL(), mySql.getDatabaseUsername(), mySql.getDatabasePassword());
        mySql.setInputSql("SELECT registered_username, registered_password FROM car_reservations");
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(mySql.getInputSql());

        try{
            while(resultSet.next()){
                String username = resultSet.getString("registered_username");
                String password = resultSet.getString("registered_password");
                UserPasswordMap.put(username,password);
            }
        }catch (Exception e){
            System.out.println("Database hashmap error");
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void getUserPass(){
        System.out.println("Enter Registered Username and passcode to Display registered vehicles\n");
        System.out.println("USERNAME : ");
        String enteredUsername = input.nextLine();
        System.out.println("Password");
        String enteredPassword = input.nextLine();

        try{
            if(UserPasswordMap.containsKey(enteredUsername)){
                if(UserPasswordMap.get(enteredUsername).equals(enteredPassword)){
                    displayCarReservations(enteredUsername);
                }else{
                    System.out.println("Incorrect Password");
                }

                }

            } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        }
        public void displayCarReservations(String username) throws SQLException {
            mySql.setInputSql("SELECT * FROM car_reservations WHERE registered_username = ?");
            Connection connection = DriverManager.getConnection(mySql.getDatabaseJdbcURL(), mySql.getDatabaseUsername(), mySql.getDatabasePassword());

            try (PreparedStatement preparedStatement = connection.prepareStatement(mySql.getInputSql())) {
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();

                System.out.println("Car reservation details for user: " + username);
                while (resultSet.next()) {
                    // Display car reservation details (adjust column names as needed)
                    String name = resultSet.getString("name");
                    String dateOfBirth = resultSet.getString("date_of_birth");
                    // Retrieve and display other columns as needed
                    System.out.println("Name: " + name);
                    System.out.println("Date of Birth: " + dateOfBirth);
                    // Display other details
                }
            }
    }


}
