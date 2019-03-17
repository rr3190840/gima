package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet{
UserDAO ud;
public void init() {
ud=new UserDAO();
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{
	PrintWriter out=response.getWriter();
	String uname=request.getParameter("uname");
	String pass=request.getParameter("pass");
	ud=new UserDAO();
	if(ud.validate(uname,pass)) {
		//start session
		HttpSession hs=request.getSession();
		hs.setAttribute("UserName", uname);
		RequestDispatcher rd=request.getRequestDispatcher("home");
		rd.forward(request,response);
	}//end of if
	else {
		out.println("<h1> Invalid UserName and PassWord..!</h1>");
		RequestDispatcher rd=request.getRequestDispatcher("UserLogin.html");
		rd.include(request,response);
		
	}
}
}
