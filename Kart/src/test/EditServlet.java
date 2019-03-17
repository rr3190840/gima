package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class EditServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String pCode=req.getParameter("pcode");
		String pName=req.getParameter("pname");
		String pQty=req.getParameter("pqty");
		String Price=req.getParameter("price");
		//String pRqty=req.getParameter("prqty");
		
		try {
			Connection con=DriverConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update products set pname=?,pqty=?,price=? where pcode=?");
			
			ps.setString(1,pName);
			ps.setString(2,pQty);
			ps.setString(3,Price);
			//ps.setString(4,pRqty);
			ps.setString(4,pCode);
			
			
			int k=ps.executeUpdate();
			if(k==1) {
				pw.println("<h1>Product Updated Successfully..</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("adminhome");
				rd.include(req,res);
			}
		}//end of try
		catch(Exception e) {e.printStackTrace();}
	
	}

}
