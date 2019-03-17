package test;

public class Product {
String code,name;
double qty,rqty,price;

public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code=code;
}
public String getName(){
	return name;
}
public void setName(String name) {
	this.name=name;
}
public double  getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price=price;
}
public double getQty() {
	return qty;
}
public void setQty(double qty) {
	this.qty=qty;
}
public double  getRQty() {
	return rqty;
}
public void setRQty(double rqty) {
	this.rqty=rqty;
}

public boolean equals(Object o) {
	if(o instanceof Product)
		return((Product)o).code.equals(code);
	else return false;
}
}
