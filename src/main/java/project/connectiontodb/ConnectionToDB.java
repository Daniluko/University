package project.connectiontodb;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Daniluko
 */
public class ConnectionToDB {

    public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String USER = "SYS AS SYSDBA";
    public static final String PASS = "12345";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
