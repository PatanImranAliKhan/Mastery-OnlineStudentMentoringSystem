<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Imran","root","root");
		Statement st=con.createStatement();
		String s="select * from student where rollno=102";
		ResultSet rs=st.executeQuery(s);
		rs.next();
		
	%>
	Roll no: <%= rs.getString(1) %><br>
	name: <%= rs.getString(2) %>
	Marks=<%= rs.getString(3) %>
</body>
</html>