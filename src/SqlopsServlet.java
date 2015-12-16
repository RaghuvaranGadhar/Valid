

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SqlopsServlet
 */
@WebServlet("/SqlopsServlet")
public class SqlopsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SqlopsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Object> list = new ArrayList<Object>();
		
		response.setContentType("text/html");  
		PrintWriter notout = response.getWriter();  

		/*String rollno=request.getParameter("roll");  
		int roll=Integer.valueOf(rollno);*/  

		 try{
	            //String n =request.getParameter("eid");
	            //System.out.println("Printed N"+n);
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root", "admin");
	            System.out.println("Connected");
	            PreparedStatement ps = con.prepareStatement("select * from laptop");
	            //ps.setString(1, n);
	            ResultSet rs = ps.executeQuery();
	            System.out.println("Query");  

	            if(rs.next())
	             {
	                {
	                    String an = rs.getString(1);
	                    String ab = rs.getString(2);
	                    String at = rs.getString(3);
	                    String cpuid = rs.getString(4);
	                    String floor = rs.getString(5);
	                    String hdd = rs.getString(6);
	                    String location = rs.getString(7);
	                    String make = rs.getString(8);
	                    String model = rs.getString(9);
	                    String os = rs.getString(10);
	                    String ram = rs.getString(11);
	                    String slocation = rs.getString(12);
	                    String sno = rs.getString(13);
	                    String type = rs.getString(14);
	                    String aid = rs.getString(15);
	                    String remarks = rs.getString(16);

	                    list.add(an);
	                    list.add(ab);
	                    list.add(at);
	                    list.add(cpuid);
	                    list.add(floor);
	                    list.add(hdd);
	                    list.add(location);
	                    list.add(make);
	                    list.add(model);
	                    list.add(os);
	                    list.add(ram);
	                    list.add(slocation);
	                    list.add(sno);
	                    list.add(type);
	                    list.add(aid);
	                    list.add(remarks);

	                    System.out.println("list::" +list); 
	                }

	                request.setAttribute("nList", list);

	                System.out.println("valid User no.");
	                /*RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
	                rd.include(request, response);*/
	            }
	            else
	            {   
	                System.out.println("invalid User no.");
	                /*RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
	                rd.include(request, response);*/
	            }
	        }catch(NumberFormatException nfe)
	        {
	            System.out.println("ONLY INTEGER VALUE ALLOWED");
	            System.out.println("PLEASE ENTER ONLY INTEGER");
	            /*RequestDispatcher rd = request.getRequestDispatcher("NumberFormatException.jsp");
	            rd.include(request, response);*/
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            notout.close();
	        }
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
