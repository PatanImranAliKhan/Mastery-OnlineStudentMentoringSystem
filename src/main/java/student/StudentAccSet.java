package student;

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

@WebServlet("/accountStd")
public class StudentAccSet extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse responce) throws ServletException, IOException
	{
		try {
			Connection con=DBConnection.getconnection();
			
			HttpSession session=request.getSession();
			String det=(String)session.getAttribute("userdetails");
			System.out.println(det);
			String[] details=det.split(",");
			
			Statement st=con.createStatement();
			int id=Integer.parseInt(details[6]);
			String strid=request.getParameter("id");
			
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			
			String parentname=request.getParameter("parentname");
			String parentemail=request.getParameter("parentemail");
			String password=request.getParameter("newpass");
			
			String bio=request.getParameter("bio");
			if(firstname==null)
			{
				firstname=details[0];
			}
			if(lastname==null)
			{
				lastname=details[1];
			}
			if(email==null)
			{
				email=details[2];
			}
			if(mobile==null)
			{
				mobile=details[3];
			}
			if(parentname==null)
			{
				parentname=details[4];
			}
			if(parentemail==null)
			{
				parentemail=details[5];
			}
			if(password==null)
			{
				password=details[7];
			}
			if(bio==null)
			{
				bio=details[8];
			}
			long longmobile=Long.parseLong(mobile);
			responce.getWriter().println("update student firstname='"+firstname+"',lastname='"+lastname+"',student_email='"+email+"',student_mobile="+mobile+",parentname='"+parentname+"',parentemail='"+parentemail+"',password='"+password+"',bio='"+bio+"' where sid="+id+";");
			st.execute("update student set firstname='"+firstname+"',lastname='"+lastname+"',student_email='"+email+"',student_mobile="+mobile+",parentname='"+parentname+"',parentemail='"+parentemail+"',password='"+password+"',bio='"+bio+"' where sid="+id+";");
			HttpSession ses=request.getSession();
			ses.setAttribute("userdetails",firstname+","+lastname+","+email+","+mobile+","+parentname+","+parentemail+","+id+","+password+","+bio);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}