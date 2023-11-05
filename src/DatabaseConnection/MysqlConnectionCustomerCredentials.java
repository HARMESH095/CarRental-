package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnectionCustomerCredentials {
    private static final String JdbcURl = "jdbc:mysql://localhost:3306/customerDetails";
    private static final String Username = "root";
    private static final String Password = "Harmesh26@";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JdbcURl,Username,Password);
    }
}
