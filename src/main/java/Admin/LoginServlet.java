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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse responce) throws ServletException, IOException
	{
		try {
			Connection con=DBConnection.getconnection();
			Statement st=con.createStatement();
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			ResultSet res=st.executeQuery("select * from admin where username=\""+username+"\" and password=\""+password+"\";");
			RequestDispatcher rd;
			HttpSession ses=request.getSession();
			if(Checker(res))
			{
				ses.setAttribute("user", "admin");
				responce.getWriter().println("<h1>Successfully Logined as Admin</h1>");
			}
			else
			{
				ResultSet res1=st.executeQuery("select * from mentor where mid=\""+Integer.parseInt(username)+"\" and password=\""+password+"\";");
				if(Checker(res1))
				{
					responce.getWriter().println("<h1>Successfully Logined as Mentor</h1>");
					ses.removeAttribute("sid");
					ses.setAttribute("mid",Integer.parseInt(username));
					ses.setAttribute("user", "mentor");
					ResultSet norm=st.executeQuery("select * from mentor where mid=\""+Integer.parseInt(username)+"\";"); 
					while(norm.next())
					{
						ses.setAttribute("userdetails", norm.getString(1)+","+norm.getString(2)+","+norm.getString(3)+","+norm.getString(4)+","+norm.getString(8)+","+norm.getString(10));
						responce.getWriter().println(ses.getAttribute("userdetails"));
						
					}
					responce.sendRedirect("AccountMen.jsp");
				}
				else
				{
					ResultSet res2=st.executeQuery("select * from student where sid=\""+Integer.parseInt(username)+"\" and password=\""+password+"\";");
					if(Checker(res2))
					{
						responce.getWriter().println("<h1>Successfully Logined as Student</h1>");
						ses.removeAttribute("mid");
						ses.setAttribute("sid",Integer.parseInt(username));
						ses.setAttribute("user", "student");
						ResultSet norm1=st.executeQuery("select * from student where sid=\""+Integer.parseInt(username)+"\";");
						while(norm1.next())
						{
							ses.setAttribute("userdetails", norm1.getString(1)+","+norm1.getString(2)+","+norm1.getString(3)+","+norm1.getString(4)+","+norm1.getString(5)+","+norm1.getString(6)+","+norm1.getString(8)+","+norm1.getString(12)+","+norm1.getString(13));
						}
						responce.sendRedirect("AccountStd.jsp");
					}
					else
					{
						responce.getWriter().println("Oops! failed Incorrect Username and password ");
					}
				}
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
