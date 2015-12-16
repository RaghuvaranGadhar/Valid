

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class DesktopServlet
 */
@WebServlet("/DesktopServlet")
public class DesktopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesktopServlet() {
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
            ArrayList<Desktop> desktop;
            desktop = new ArrayList<Desktop>();
            String url = "jdbc:mysql://localhost:3306/ams";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);          
            System.out.println("Drivers Loaded");
            Connection connection = DriverManager.getConnection(url,"root","admin");
            System.out.println("Connected To DB");

            


            // Set the new instance of the episode row
            Desktop temp;
            desktop.add(temp = new Desktop(request.getParameter("asid"),request.getParameter("an"),request.getParameter("ab"),request.getParameter("at"),request.getParameter("cpuid"),request.getParameter("floor"),request.getParameter("hdd"),request.getParameter("location"),request.getParameter("make"),request.getParameter("model"),request.getParameter("os"),request.getParameter("ram"),request.getParameter("slocation"),request.getParameter("sno"),request.getParameter("type")));
            PreparedStatement editmodelment = connection.prepareStatement("insert into desktop values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            System.out.println("Query Execuited");
            // Put in database
            editmodelment.setString(1, temp.getasid());
            editmodelment.setString(2, temp.getan());
            editmodelment.setString(3, temp.getab());
            editmodelment.setString(4, temp.getat());
            editmodelment.setString(5, temp.getcpuid());
            editmodelment.setString(6, temp.getfloor());
            editmodelment.setString(7, temp.gethdd());            
            editmodelment.setString(8, temp.getlocation());
            editmodelment.setString(9, temp.getmake());
            editmodelment.setString(10, temp.getmodel());
            editmodelment.setString(11, temp.getos());
            editmodelment.setString(12,temp.getram());
            editmodelment.setString(13,temp.getslocation());
            editmodelment.setString(14,temp.getsno());
            editmodelment.setString(15,temp.gettype());
            
            editmodelment.executeUpdate();
            System.out.println("Q2 ");
            editmodelment.close();
            connection.close();

            // Print out new entry
            int i = 0;
            while(i < desktop.size()){
            out.print(desktop.get(i).getasid()+
            		"\t"+ desktop.get(i).getan()+
            		"\t"+ desktop.get(i).getab()+
                    "\t"+ desktop.get(i).getat()+
                    "\t"+ desktop.get(i).getcpuid() +
                    "\t"+ desktop.get(i).getfloor()+
                    "\t"+ desktop.get(i).gethdd()+
                    "\t"+ desktop.get(i).getlocation()+
                    "\t"+ desktop.get(i).getmake()+
                    "\t"+ desktop.get(i).getmodel()+
                    "\t"+ desktop.get(i).getos()+
                    "\t"+ desktop.get(i).getram()+
                    "\t"+ desktop.get(i).getslocation()+
                    "\t"+ desktop.get(i).getsno()+
                    "\t"+ desktop.get(i).gettype());
            		
            out.print("<br>");
            i++;
            }
        	
        } 
        catch (Exception e) 
        {
            out.println("Error" + e);
        }
        out.println("<H3> Details Inserted Successfully </H3>");
        out.println("Result...");
        out.println("</BODY></HTML>");
	}

}







