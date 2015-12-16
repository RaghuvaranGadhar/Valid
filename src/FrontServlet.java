

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/FrontServlet")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE> Insert - Test </TITLE></HEAD>");
        out.println("<BODY>");
        try 
        {
            ArrayList<Front> front;
            front = new ArrayList<Front>();
            String url = "jdbc:mysql://localhost:3306/ams";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);          
            System.out.println("Drivers Loaded");
            Connection connection = DriverManager.getConnection(url,"root","admin");
            System.out.println("Connected To DB");

            


            // Set the new instance of the episode row
            Front temp;
            front.add(temp = new Front(request.getParameter("username"),request.getParameter("password")));
            PreparedStatement editStatement =  (PreparedStatement) connection.prepareStatement("insert into validation values(?,?)");
            System.out.println("Query Execuited");
            // Put in database
            editStatement.setString(1, temp.getusername());
            editStatement.setString(2, temp.getpassword());

            editStatement.executeUpdate();
            System.out.println("Q2 ");
            editStatement.close();
            connection.close();

            // Print out new entry
            int i = 0;
            while(i < front.size()){
            out.print(front.get(i).getusername()+
                    "\t"+ front.get(i).getpassword());

            out.print("<br>");
            i++;
            }
        	
        } 
        catch (Exception e) 
        {
            out.println("Error" + e);
        }
        out.println("<H3> Basic Insert Servlet </H3>");
        out.println("Result...");
        out.println("</BODY></HTML>");
	}

}
