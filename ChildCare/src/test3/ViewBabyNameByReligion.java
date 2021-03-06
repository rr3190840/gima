package test3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.Baby;
import test2.BabyDao;
@WebServlet("/ViewBabyNameByReligion")
public class ViewBabyNameByReligion extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String religion=request.getParameter("religion");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Baby by "+religion.toUpperCase()+"</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navigation.html").include(request, response);
		out.print(" <a href='ViewBabyNameBySex?sex=boy&religion=hindu' class='btn btn-primary' role='button'>HinduBabyBoy</a> ");
		out.print(" <a href='ViewBabyNameBySex?sex=boy&religion=muslim' class='btn btn-primary' role='button'>MuslimBabyBoy</a> ");
		out.print(" <a href='ViewBabyNameBySex?sex=boy&religion=sikh' class='btn btn-primary' role='button'>SikhBabyBoy</a> ");
		out.print(" <a href='ViewBabyNameBySex?sex=boy&religion=christian' class='btn btn-primary' role='button'>ChristianBabyBoy</a> ");
		out.print(" <a href='ViewBabyNameBySex?sex=girl&religion=hindu' class='btn btn-primary' role='button'>HinduBabyGirl</a> ");
		out.print(" <a href='ViewBabyNameBySex?sex=girl&religion=muslim' class='btn btn-primary' role='button'>MuslimBabyGirl</a> ");
		out.print(" <a href='ViewBabyNameBySex?sex=girl&religion=sikh' class='btn btn-primary' role='button'>SikhBabyGirl</a> ");
		request.getRequestDispatcher("atoz.html").include(request, response);
		
		out.println("<h1>View Baby Names by "+religion.toUpperCase()+"</h1>");
		List<Baby> list=BabyDao.getRecordsByReligion(religion);
		
		out.print("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Meaning</th><th>Sex</th><th>Religion</th></tr>");
		for(Baby b:list){
			out.println("<tr><td>"+b.getId()+"</td><td>"+b.getName()+"</td><td>"+b.getMeaning()+"</td><td>"+b.getSex()+"</td><td>"+b.getReligion()+"</td></tr>");
		}
		out.println("</table>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}


}
