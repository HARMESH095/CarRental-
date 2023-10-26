package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnectionCarDetails {

    private static final String JdbcURL = "jdbc:mysql://localhost:3306/car";
    private static final String username = "root";
    private static final String password = "Harmesh26@";

    public Connection getConnection() throws Exception{
        return DriverManager.getConnection(JdbcURL,username,password);

    }
}
