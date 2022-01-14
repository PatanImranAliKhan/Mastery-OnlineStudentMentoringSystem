package mentor;

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

@WebServlet("/accountMen")
public class MentorAccSet extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse responce) throws ServletException, IOException
	{
		try {
			Connection con=DBConnection.getconnection();
			
			HttpSession session=request.getSession();
			String det=(String)session.getAttribute("userdetails");
			String[] details=det.split(",");
			
			Statement st=con.createStatement();
			int id=Integer.parseInt(details[3]);
			String strid=request.getParameter("id");
			
			String username=request.getParameter("usename");
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			
			String password=request.getParameter("newpass");
			
			String bio=request.getParameter("bio");
			if(password==null)
			{
				password=details[4];
			}
			if(username==null)
			{
				username=details[0];
			}
			if(email==null)
			{
				email=details[1];
			}
			if(mobile==null)
			{
				mobile=details[2];
			}
			if(bio==null)
			{
				bio=details[5];
			}
			System.out.println(bio);
			st.execute("update mentor set mentorname='"+username+"',email='"+email+"',mobile="+mobile+",password='"+password+"',bio='"+bio+"' where mid="+id+";");
			HttpSession ses=request.getSession();
			ses.setAttribute("userdetails", username+","+email+","+mobile+","+id+","+password+","+bio);
			responce.getWriter().println(ses.getAttribute("userdetails"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}