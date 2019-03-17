<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>div.box{width:200px;height:250px;border:2px solid Black;padding:10px;float:center}</style>
</head>
<body>
<%out.print("<h1> Home</h1>");
out.print("<center><h1>My Shoping Store...!</h1></center>");
 %>
<div class="box">
  <a href="AdminLogin.html">
  <img src="resources/images/Admin.jpg"/>
  </a>
  <h3>AdminLogin</h3>
  </div>
  <div class="box">
  <a href="UserLogin.html">
  <img src="resources/images/User.jpg"/>
  </a>
  <h3>UserLogin</h3>
  </div>
<%@include file="Home.html" %>

</body>
</html>