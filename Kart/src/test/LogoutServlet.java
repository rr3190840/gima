package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	HttpSession hs=request.getSession(false);
    if(hs!=null)
    	out.println("<h1>You are successfully logged out</h1>");
    	hs.invalidate();
    RequestDispatcher rd=request.getRequestDispatcher("Dis.jsp");
    rd.include(request,response);

}
}
