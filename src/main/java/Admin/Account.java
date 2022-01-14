package Admin;

import Database.DBConnection;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/account")
public class Account extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse responce) throws ServletException, IOException
	{
		try {
			Connection con=DBConnection.getconnection();
			Statement st=con.createStatement();
			String id=request.getParameter("id");
			String name=request.getParameter("username");
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			long longmobile=Long.parseLong(request.getParameter("mobile"));
			String password=request.getParameter("newpass");
			int intid=Integer.parseInt(request.getParameter("id"));
			HttpSession session=request.getSession();
			String det=(String)session.getAttribute("userdetails");
			String[] details=det.split(",");
			if(id==null)
			{
				id=details[3];
			}
			if(name==null)
			{
				name=details[0];
			}
			if(email==null)
			{
				email=details[1];
			}
			if(mobile==null)
			{
				mobile=details[2];
			}
			if(password==null)
			{
				password=details[4];
			}
			System.out.println("update student email='"+email+"' mobile="+mobile+" password='"+password+"' where sid="+id+";");
			if(id.length()==9)
			{
				st.execute("update student email='"+email+"' mobile="+longmobile+" password='"+password+"' where sid="+intid+";");
			}
			else
			{
				st.execute("update mentor email='"+email+"' mobile="+longmobile+" password='"+password+"' where mid="+intid+";");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
