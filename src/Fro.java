

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fro
 */
@WebServlet("/Fro")
public class Fro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fro() {
    	
        super();
        System.out.println("Fro--servlet");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		String url="jdbc:mysql://localhost:3306/ams";
		System.out.println("connected to assg1");
		String driver = "com.mysql.jdbc.Driver";
		System.out.println("dr load");
		String m,p;
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		try {
			Class.forName(driver);

			System.out.println("Drivers loaded");
			Connection con = DriverManager.getConnection(url,"root","admin");
			System.out.println("connected to database");
			
			String mail = request.getParameter("Email");
			String pass = request.getParameter("Password");
			System.out.println(mail);
			System.out.println(pass);
			
			Statement st = con.createStatement();
			String query = "select * from password";
			java.sql.ResultSet rs = st.executeQuery(query);
			
			while (rs.next()){
				//System.out.println(rs.getString("Username")+""+rs.getString("Password"));
				m=rs.getString("Username");
				System.out.println(m);
				p=rs.getString("Password");
				System.out.println(p);
				if(m.equals(mail)){
					
						System.out.println("success");
						out.println("<html>");
	            		out.println("<body>");
	            		out.println("<h2>Thanks" + "  " + mail+ "  " + "for submitting your request<br></h2" );
	            		out.println("Your Email and Password are matching");
	            		out.println("<a href='reg.html'>Click to continue </a>");
	            		out.println("</body></html>");
					
				}else{
					out.println("<html>");
            		out.println("<body>");
            		
            		out.println("<h3>Invalid username and passowrd</h3>");
            		out.println("<a href='front.html'>Click to continue </a>");
            		out.println("</body></html>");
				}
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpSvalueervletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		String url="jdbc:mysql://localhost:3036/ams";
		System.out.println("connected to assg1");
		String driver = "com.mysql.jdbc.Driver";
		System.out.println("dr load");
		String m,p;
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		try {
			Class.forName(driver);

			System.out.println("Drivers loaded");
			Connection con = DriverManager.getConnection(url,"root","admin");
			System.out.println("connected to database");
			
			String mail = request.getParameter("username");
			String pass = request.getParameter("password");
			System.out.println(mail);
			System.out.println(pass);
			
			Statement st = con.createStatement();
			String query = "select * from password";
			java.sql.ResultSet rs = st.executeQuery(query);
			
			while (rs.next()){
				//System.out.println(rs.getString("Username")+""+rs.getString("Password"));
				m=rs.getString("username");
				System.out.println(m);
				p=rs.getString("password");
				System.out.println(p);
				if(m.equals(mail) && p.equals(pass)){
						System.out.println("success"+ response);
						response.setContentType("text/html;charset=UTF-8");
				}
				else
				{
					System.out.println("fail");
					response.setStatus(500);
					//response.
				//response.setProperty(response.HTTP_STATUS_CODE, "500");
				    out.println("error");
				    out.close();
				    response.setContentType("text/html;charset=UTF-8");
				}
		
//		System.out.println("postttt====>");
//		response.setContentType("text/html;charset=UTF-8");
//
//        String a =request.getParameter("username");
//        System.out.println(a);
	}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

			

}
