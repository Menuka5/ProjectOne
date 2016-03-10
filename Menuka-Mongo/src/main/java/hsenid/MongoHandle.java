package hsenid;

import com.mongodb.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;


public class MongoHandle extends HttpServlet{

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter(); // To write HTML contents
        String username = request.getParameter("username"); //Gets the username and password from jsp post method to these variables
        String password = request.getParameter("password");

        try {

            MongoClient mongo = new MongoClient("localhost", 27017); //create connection with Mongodb
            DB db = mongo.getDB("hsenid"); //Connect with the database
            DBCollection table = db.getCollection("users");  //get the collection
            BasicDBObject searchQuery = new BasicDBObject(); //Search object


            searchQuery.put("username", username); // Give user name and password to the query
            searchQuery.put("password", password);
            DBCursor cursor =table.find(searchQuery);


            if (cursor.hasNext()){ //checking the out put
                out.println("Success!");
            }else{
		out.println("Failed!");
	    }



        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }


    }
}
