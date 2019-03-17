package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class DisServlet extends GenericServlet {
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		//RequestDispatcher rd=req.getRequestDispatcher("log");
		//rd.forward(req,res);
		//pw.println("<br><a href=\"Login.html\">AdminLogin</a>");
		//pw.println("<br><a href=\"200Login.html\">UserLogin</a>");
		//request.getRequestDispatcher("header.html").include(request, response);
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
		out.print("</style>");
		out.print("</head>");
		out.print("<body style='background: url(shop.png)'>");
		out.print("</body>");
		out.print("</html>");
		out.print("<h1> Home</h1>");
		out.print("<center><h1>My Shoping Store...!</h1></center>");
		
		out.print("<form>");
		out.println("<br/>");
		//out.print(" <input class='MyButton' onclick='AdminLogin.html' type='button' value='    Admin    '/ ");
		out.print("<center><a href=\"AdminLogin.html\">AdminLogin</a></center>");
		//out.println("</center>");
		out.print("</form>");
		out.print("  ");
		out.print("<form>");
		//out.println("<br/><br/><center>");
		//out.print(" <input class='MyButton' onclick='UserLogin.html' type='button' value='    User    '/");
		out.print("<center><a href=\"UserLogin.html\">UserLogin</a></center>");
		//out.println("</center>");
		out.print("</form>");
		//out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a> ");
			
		//request.getRequestDispatcher("footer.html").include(request, response);
		
	}

}
