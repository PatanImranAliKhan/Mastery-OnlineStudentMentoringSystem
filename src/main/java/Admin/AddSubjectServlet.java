package Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addSubject")
public class AddSubjectServlet extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse responce) throws ServletException, IOException
	{
		try {
			Connection con=DBConnection.getconnection();
			Statement st=con.createStatement();
			String subject=request.getParameter("subjectname");
			String code=request.getParameter("code");
			String dept=request.getParameter("dept");
			int year=Integer.parseInt(request.getParameter("year"));
			int sem=Integer.parseInt(request.getParameter("sem"));
//			System.out.print("INSERT INTO SUBJECTS values('"+subject+"','"+code+"','"+dept+"',"+year+","+sem+");");
			ResultSet rs=st.executeQuery("select * from subjects where coursecode='"+code+"' and subject='"+subject+"';");
			if(rs.next())
			{
				responce.getWriter().println("Already Used This CourseCode "+code);
				return;
			}
			else
			{
				boolean res=st.execute("INSERT INTO SUBJECTS values('"+subject+"','"+code+"','"+dept+"',"+year+","+sem+");");
				RequestDispatcher rd1;
				if(!res)
				{
					responce.getWriter().println("Successfully Added");
//					rd1=request.getRequestDispatcher("");
				}
				else
				{
					responce.getWriter().println("Oops! failed to add data");
//					rd1=request.getRequestDispatcher("");
				}
			}
//			rd1.forward(request, responce);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
