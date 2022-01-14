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
import jakarta.servlet.http.HttpSession;

@WebServlet("/mensssub")
public class MentorAssignSubject extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse responce) throws ServletException, IOException
	{
		try {
			Connection con=DBConnection.getconnection();
			Statement st=con.createStatement();
			String subject=request.getParameter("subject");
			HttpSession ses=request.getSession();
			String strid=(String)ses.getAttribute("mentorid");
			int mid=Integer.parseInt(strid);
			st.execute("update mentor set subject='"+subject+"' where mid="+mid+";");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
