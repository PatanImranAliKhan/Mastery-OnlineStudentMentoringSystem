package Admin;

import Database.DBConnection;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse responce) throws ServletException, IOException
	{
		try {
			Connection con=DBConnection.getconnection();
			Statement st=con.createStatement();
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String student_email=request.getParameter("student_email");
			long student_mobile=Long.parseLong(request.getParameter("student_mobile"));
			String parentname=request.getParameter("parentname");
			String parentemail=request.getParameter("parentemail");
			long parent_mobile=Long.parseLong(request.getParameter("parent_mobile"));
			int sid=Integer.parseInt(request.getParameter("sid"));
			String dept=request.getParameter("dept");
			int year=Integer.parseInt(request.getParameter("year"));
			int sem=Integer.parseInt(request.getParameter("sem"))*year;
			String password=request.getParameter("password");
//			(firstname,lastname,student_email,student_mobile,parentname,parentemail,parent_mobile,sid,dept,year,sem,password) 
			ResultSet rs=st.executeQuery("select * from Student where student_email='"+student_email+"';");
			if(rs.next())
			{
				responce.getWriter().println("Already An User");
				return;
			}
			int res=st.executeUpdate("INSERT INTO Student values('"+firstname+"','"+lastname+"','"+student_email+"','"+student_mobile+"','"+parentname+"','"+parentemail+"','"+parent_mobile+"',"+sid+",'"+dept+"',"+year+","+sem+",'"+password+"');");
			RequestDispatcher rd;
			if(res!=0)
			{
				responce.getWriter().println("Successfully Added");
//				rd=request.getRequestDispatcher("");
			}
			else
			{
				responce.getWriter().println("Oops! failed to add data");
//				rd=request.getRequestDispatcher("");
			}
//			rd.forward(request, responce);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean Checker(ResultSet rs) throws SQLException
	{
		int c=0;
		while(rs.next())
		{
			c++;
		}
		if(c==0)
		{
			return false;
		}
		return true;
	}
}
