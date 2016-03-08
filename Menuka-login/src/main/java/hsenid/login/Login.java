package hsenid.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//This class check the given credintials are matching with the embedded details.

public class Login extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); // To write HTML contents

        String username = request.getParameter("username"); //Gets the username and password from jsp post method to these variables
        String password = request.getParameter("password");

        if (username.equals("Admin") && password.equals("Admin123")){ //Checking whether password is matching or not.
            out.println("Successful!");
        }else{
            out.println("Failed!!!");
        }



    }

}
