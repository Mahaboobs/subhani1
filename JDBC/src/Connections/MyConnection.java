package Connections;

import java.sql.*;

public class MyConnection
{
private static MyConnection myconnection= new MyConnection();
static Connection connection;
private MyConnection()
{

	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/babu","root","root");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
 public static MyConnection getInstance()
 {
	 return myconnection;
 }

}
