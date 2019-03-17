package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class RegServlet1 extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String pCode=req.getParameter("pcode");
		String pName=req.getParameter("pname");
		String pQty=req.getParameter("pqty");
		String Price=req.getParameter("price");
		String pRqty=req.getParameter("prqty");
		
		try {
			Connection con=DriverConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into products values(?,?,?,?,?)");
			ps.setString(1,pCode);
			ps.setString(2,pName);
			ps.setString(3,pQty);
			ps.setString(4,Price);
			ps.setString(5,pRqty);
			
			int k=ps.executeUpdate();
			if(k==1) {
				pw.println("<h1>Product Registered Successfully..</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("adminhome");
				rd.include(req,res);
			}
		}//end of try
		catch(Exception e) {e.printStackTrace();}
	
	}

}
