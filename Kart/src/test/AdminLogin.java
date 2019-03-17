package test;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AdminLogin  extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		//PrintWriter pw=res.getWriter();
		//res.setContentType("text/html");
		String uName=req.getParameter("uname");
		String pWord=req.getParameter("pass");
		try {
			/*Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from admin where uname=? and pword=?");
			ps.setString(1,uName);
			ps.setString(2,pWord);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd=req.getRequestDispatcher("dis1");
				rd.forward(req,res);
			}//end of if
			else {
				//pw.println("Invalid UserName and password!");
				RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
				rd.include(req, res);
			}*/
			if(uName.equals("Ravi")&&pWord.equals("ravi123")){
				HttpSession session=req.getSession();
				session.setAttribute("UserName", uName);
				session.setAttribute("adminlogin","true");
				req.getRequestDispatcher("adminhome").forward(req, res);
			}else{
				req.getRequestDispatcher("AdminLogin.html").include(req, res);
			}
		}//end of try
		catch(Exception e) { e.printStackTrace();}
	}
  
}
