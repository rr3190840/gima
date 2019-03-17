package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class AddProductsServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		HttpSession hs=request.getSession(false);
		if(hs==null) {
			RequestDispatcher rd=request.getRequestDispatcher("dis");
			rd.forward(request,response);
			return;
		}
		String uname=(String)hs.getAttribute("UserName");
		ArrayList products=(ArrayList)hs.getAttribute("products");
		if(products==null) {
			products=new ArrayList();
			hs.setAttribute("products",products);
		}
		String[] pcodes=request.getParameterValues("products");
		for(int i=0;i<pcodes.length;i++) {
			if(request.getParameter(pcodes[i]).equals(""))
					continue;
			Product p=new Product();
			p.code=pcodes[i];
			int j=products.indexOf(p);
			if(j!=-1) {
				p=(Product)products.get(j);
				p.qty+=Double.parseDouble(request.getParameter(pcodes[i]));
				
			}
			else {
				p.name=request.getParameter(pcodes[i]+"Name");
				p.qty=Double.parseDouble(request.getParameter(pcodes[i]));
				p.price=Double.parseDouble(request.getParameter(pcodes[i]+"Price"));
				products.add(p);
				//int sQty=Integer.parseInt(request.getParameter("sqty"));
				//String pCode=request.getParameter("products");
			}
			}//end of for
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head>");
		out.println("<title>Shopping cart Example</title> ");
		out.println("</head><body style='background: url(color.png)'>");
		out.println("<table width='100%' height='90%'border='1'>");
		out.println("<tr align='center'>");
		out.println("<td height='39' colspan='2'><strong><font size='5'>MyShopping site</font></strong></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width='18%' height='500' valign='top'<p>&nbsp;</p>");
		out.println("<blockquote>");
		out.println("<p><a href='"+response.encodeURL("getproducts")+"'>view products</a></p>");
		out.println("<p><a href='"+response.encodeURL("getCart")+"'>view Cart details</a></p>");
		out.println("<p><a href='"+response.encodeURL("logout")+"'>Logout</a></p>");
		out.println("</blockquote></td>");
		out.println("<td width='82%' align='left' valign='top'><p><fontsize='6'>Welcome:"+uname+"</font></p>");
		out.println("<h2>Products Added Successfully to your cart</h2></td>");
		out.println("</tr>");
		out.println("<tr align='center'>");
		out.println("<td colspan='2'><em>&copy;copyrights 2018-19</em></td>");
		out.println("</tr>");
		out.println("/table");
		out.println("</body></html>");
		out.flush();
		out.close();
		}
	}


