package daos;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = Secrets.getURL();
    private static final String USER = Secrets.getUSER();
    private static final String PASS = Secrets.getPASS();


    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
//    public static void main(String[] args) {
//        Connection connection = ConnectionFactory.getConnection();
//    }
}
