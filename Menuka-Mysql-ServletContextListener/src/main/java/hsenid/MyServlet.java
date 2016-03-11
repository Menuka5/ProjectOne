package hsenid;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This is the servlet class
 */

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); //Set output as html
        PrintWriter out = resp.getWriter();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Boolean status = false;
        String username = req.getParameter("username"); //Getting parameters from index.jsp
        String password = req.getParameter("password");

        try {
            DBConnector mydata = (DBConnector) getServletContext().getAttribute("Database"); //Receive the DBConnector object created in MyListener class
            Connection myconn = mydata.getConn();// Receiving the connection
            pst = myconn.prepareStatement("select * from users where username=? and password=?");

            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery(); //executing the query
            status = rs.next();

            if (status) {
                out.println("Success!!!");
            } else {
                out.println("Failed!");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
