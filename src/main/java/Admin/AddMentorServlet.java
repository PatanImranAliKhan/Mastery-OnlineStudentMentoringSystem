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

@WebServlet("/addMentor")
public class AddMentorServlet extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse responce) throws ServletException, IOException
	{
		try {
			Connection con=DBConnection.getconnection();
			Statement st=con.createStatement();
			String mentorname=request.getParameter("mentorname");
			String email=request.getParameter("email");
			long mobile=Long.parseLong(request.getParameter("mobile"));
			int mid=Integer.parseInt(request.getParameter("mid"));
			String dept=request.getParameter("dept");
			int year=Integer.parseInt(request.getParameter("year"));
			int sem=Integer.parseInt(request.getParameter("sem"))*year;
			String password=request.getParameter("password");
			String subject=null;
			String bio=null;
			ResultSet rs=st.executeQuery("select * from Mentor where email='"+email+"';");
			if(rs.next())
			{
				responce.getWriter().println("Already An User");
				return;
			}
//			System.out.println("INSERT INTO Mentor values('"+mentorname+"','"+email+"','"+mobile+"',"+mid+",'"+dept+"',"+year+","+sem+",'"+password+"');");
			boolean res=st.execute("INSERT INTO Mentor values('"+mentorname+"','"+email+"','"+mobile+"','"+mid+"','"+dept+"','"+year+"','"+sem+"','"+password+"','"+subject+"',"+bio+");");
			RequestDispatcher rd1;
			String s="";
			if(!res)
			{
				ResultSet newrs=st.executeQuery("select * from subjects where dept='"+dept+"' and year="+year+" and sem="+sem+";");
				while(newrs.next())
				{
					s+=newrs.getString("subject")+",";
				}
				HttpSession session=request.getSession();
				session.setAttribute("mentorsubjects",s);
				session.setAttribute("mentorid",Integer.toString(mid));
				responce.sendRedirect("mentor_assign_subject.jsp"); 
			}
			else
			{
				responce.getWriter().println("Oops! failed to add data");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
