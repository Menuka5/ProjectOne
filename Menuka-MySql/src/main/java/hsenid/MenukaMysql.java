package hsenid;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class MenukaMysql extends HttpServlet {

//This class creates the connection between database and program. 
//Then it will check the credintials are matching or not


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); // To print on HTML page

        String name = request.getParameter("username"); //Get the username and password parameters from jsp.
        String pass = request.getParameter("password");

        boolean status = false; //To store the credintials matching

// Database connection creation 
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

//Database credintials

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "hsenid";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password); // Connecting the database
            pst = conn.prepareStatement("select * from users where username=? and password=?");
            pst.setString(1, name);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            status = rs.next(); // Status of matching password 

//Print out the HTML content according to the matching credintials.

            if (status) {
                out.println("Success!");

            } else {
                out.println("Failed!!");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Closing went wrong");
                }
                if (pst != null) {
                    try {
                        pst.close();
                    } catch (SQLException e) {
                        System.out.println("Closing went wrong");
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        System.out.println("Closing went wrong");
                    }
                }
            }

        }
    }
}


