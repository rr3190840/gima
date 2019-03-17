package test;
//import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Collection;
import java.util.Iterator;
public class BuyServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
		HttpSession hs=request.getSession(false);
		if(hs==null) {
			RequestDispatcher rd=request.getRequestDispatcher("dis");
			rd.forward(request, response);
			return;
		}
		String uname=(String)hs.getAttribute("UserName");
		double sum=0;
		double rate=0;
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<style>");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body style='background: url(color.png)'>");
		pw.print("</body>");
		pw.print("</html>");
		pw.println("<td width='82%' align='left' valign='top'><p><font size='6'>Welcome:"+uname+"</font></p>");
		//pw.println("hello");
		//System.out.println(req.getParameter("sqty"));
		//int sQty=Integer.parseInt(request.getParameter("sqty"));
		//String pCode=request.getParameter("products");
		//pw.println(bCode);
		//pw.println(sQty);
		//String bCode=req.getParameter("bcode");
		//float bPrice=Float.parseFloat(req.getParameter("bprice"));
		//pw.println("hello");
		try {
			Connection con=DriverConnection.getConnection();
			//PreparedStatement ps=con.prepareStatement("update book6 set sqty= ?where bcode=?");
		
			/*PreparedStatement ps1=con.prepareStatement("select price from products where pcode=?");
			
			ps1.setString(1,pCode);
			ResultSet rs=ps1.executeQuery();
			if(rs!=null) {
				rs.next();
			//pw.println(rs.getString(1));
			}
			pw.println("<br>PurchasingAmount is:"+(sQty*Float.parseFloat(rs.getString(1))));*/
			
			//ps1.setString(1,bCode);
			
			Collection products=(Collection)hs.getAttribute("products");
			if(products==null) {
				pw.println("You have not added any products into cart");
			}
			else {
				Iterator i=products.iterator();
				while(i.hasNext()) {
					Product p=(Product)i.next();
					PreparedStatement ps=con.prepareStatement("update products set pqty=pqty-? where pcode=? ");
					ps.setString(2,p.getCode());
					ps.setDouble(1, p.getQty());
					int k=ps.executeUpdate();
					sum+=p.getQty()*p.getPrice();
				}
				//pw.println("<h1>Total payable Amount is: </h1>"+sum);
				if(sum>2000) {
					rate=sum;
					sum=sum-sum*(0.05);
					pw.println("<td width='82%' align='left' valign='top'><p><font size='6'>Total Amount is:"+rate+"</font></p>");
					pw.println("<br/><td width='82%' align='left' valign='top'><p><font size='6'>After Discount Amount is: "+sum+"</font></p>");
					pw.print("<br/><h1>Thank you For Shoping...!</h1>");
				}else {
				pw.println("<td width='82%' align='left' valign='top'><p><font size='6'>Total payable Amount is: "+sum+"</font></p>");
				pw.print("<br/><h1>Thank you For Shoping...!</h1>");}
			}
			//int y=ps1.executeUpdate();
			/*if(k==1 ) {
				pw.println("<br>PurchasingAmount is:"+(sQty*rs.getbPrice));
			}*/
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
