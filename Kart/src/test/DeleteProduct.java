package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.ProductsDAO;
//@WebServlet("/DeleteBabyName")
public class DeleteProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		//int id=Integer.parseInt(sid);
		ProductsDAO.delete(sid);
		
		response.sendRedirect("getProduct");
		
	}


}
