package hsenid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This is database connection creating class
 */

public class DBConnector {
    public static Connection conn; // This static so we can change value in any method


    public DBConnector(String url, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password); // creating the db connection

        } catch (ClassNotFoundException e) { //Handling the exceptions
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn; //returning the created connection
    }
}
