

import java.io.IOException;
import java.io.PrintWriter;
//import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LaptopServlet
 */
@WebServlet("/LaptopServlet")
public class LaptopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LaptopServlet() {
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
		System.out.println("hello");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE> Insert - Test </TITLE></HEAD>");
        out.println("<BODY>");
        
        // create 2 BigInteger objects
    	/*BigInteger sno, aid;

    	// create 2 Integer objects
    	Integer i1, i2;

    	// assign values to bi1, bi2
    	sno = new BigInteger("123");
    	aid = new BigInteger("9888486986");

    	// assign the integer values of bi1, bi2 to i1, i2
    	i1 = sno.intValue();
    	i2 = aid.intValue();

    	String str1 = "Integer value of " +sno+ " is " +i1;
    	String str2 = "Integer value of " +aid+ " is " +i2;*/
        
        try 
        {
            ArrayList<Laptop> laptop;
            laptop = new ArrayList<Laptop>();
            String url = "jdbc:mysql://localhost:3306/ams";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);          
            System.out.println("Drivers Loaded");
            Connection connection = DriverManager.getConnection(url,"root","admin");
            System.out.println("Connected To DB");

            


            // Set the new instance of the episode row
            Laptop temp;
            laptop.add(temp = new Laptop(request.getParameter("an"),request.getParameter("ab"),request.getParameter("at"),request.getParameter("cpuid"),request.getParameter("floor"),request.getParameter("hdd"),request.getParameter("location"),request.getParameter("make"),request.getParameter("model"),request.getParameter("os"),request.getParameter("ram"),request.getParameter("slocation"),request.getParameter("sno"),request.getParameter("type"),request.getParameter("aid"),request.getParameter("remarks")));
            PreparedStatement editmodelment = connection.prepareStatement("insert into laptop values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            System.out.println("Query Execuited");
            // Put in database
            editmodelment.setString(1, temp.getan());
            editmodelment.setString(2, temp.getab());
            editmodelment.setString(3, temp.getat());
            editmodelment.setString(4, temp.getcpuid());
            editmodelment.setString(5, temp.getfloor());
            editmodelment.setString(6, temp.gethdd());            
            editmodelment.setString(7, temp.getlocation());
            editmodelment.setString(8, temp.getmake());
            editmodelment.setString(9, temp.getmodel());
            editmodelment.setString(10, temp.getos());
            editmodelment.setString(11,temp.getram());
            editmodelment.setString(12,temp.getslocation());
            editmodelment.setString(13,temp.getsno());
            editmodelment.setString(14,temp.gettype());
            editmodelment.setString(15,temp.getaid());
            editmodelment.setString(16,temp.getremarks());
            
            editmodelment.executeUpdate();
            System.out.println("Q2 ");
            editmodelment.close();
            connection.close();

            // Print out new entry
            int i = 0;
            while(i < laptop.size()){
            out.print(laptop.get(i).getan()+
            		"\t"+ laptop.get(i).getab()+
                    "\t"+ laptop.get(i).getat()+
                    "\t"+ laptop.get(i).getcpuid() +
                    "\t"+ laptop.get(i).getfloor()+
                    "\t"+ laptop.get(i).gethdd()+
                    "\t"+ laptop.get(i).getlocation()+
                    "\t"+ laptop.get(i).getmake()+
                    "\t"+ laptop.get(i).getmodel()+
                    "\t"+ laptop.get(i).getos()+
                    "\t"+ laptop.get(i).getram()+
                    "\t"+ laptop.get(i).getslocation()+
                    "\t"+ laptop.get(i).getsno()+
                    "\t"+ laptop.get(i).gettype()+
                    "\t"+ laptop.get(i).getaid()+
                    "\t"+ laptop.get(i).getremarks());
            		
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
