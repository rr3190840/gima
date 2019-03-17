package test;
import java.sql.*;
import java.util.*;

//import com.javatpoint.bean.Baby;
public class ProductsDAO {
public Collection getProducts() {
	try {
		Connection con=DriverConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from products");
		ArrayList products=new ArrayList();
		while(rs.next()) {
			Product p=new Product();
			p.code=rs.getString(1);
			p.name=rs.getString(2);
			p.qty=rs.getDouble(3);
			p.price=rs.getDouble(4);
			products.add(p);
			
		}
		return products;
		
	}//end of try
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return null;
}
public static List<Product> getRecordsByStart(String start){
	String start1=start.toLowerCase();
	List<Product> list=new ArrayList<Product>();
	try{
		Connection con=DriverConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from products where pcode like '"+start1+"%' ");
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Product b=new Product();
			b.setCode(rs.getString(1));
			b.setName(rs.getString(2));
			b.setQty(rs.getDouble(3));
			b.setPrice(rs.getDouble(4));
			//b.setRQty(rs.getDouble(5));
			list.add(b);
			
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return list;
}
public static int delete(String id){
	int status=0;
	try{
		Connection con=DriverConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from products where pcode=?");
		ps.setString(1,id);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
