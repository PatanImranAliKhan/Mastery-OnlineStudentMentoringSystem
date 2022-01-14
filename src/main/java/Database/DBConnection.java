package Database;

import java.sql.*;
public class DBConnection {

	public static String username="root";
	public static String passwordDB="root";
	public static String url="jdbc:mysql://localhost:3306/ep_project";
	public static Connection getconnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EP_Project","root","root");
//		System.out.println("database Was Connected!!!!!");
		return con;
	}
	
}
