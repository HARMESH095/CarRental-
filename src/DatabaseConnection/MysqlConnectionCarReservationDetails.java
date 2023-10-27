package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnectionCarReservationDetails {
    private static final String JdbcURL = "jdbc:mysql://localhost:3306/Reservation";
    private static final String username ="root";
    private static final String password ="Harmesh26@";

    public Connection getConnection()throws Exception{
        return DriverManager.getConnection(JdbcURL,username,password);
    }
}
