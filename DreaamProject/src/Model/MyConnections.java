package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnections {

	private static MyConnections myconnection=new MyConnections();
	public Connection connec;
	private MyConnections()
	{
		
	
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
					try {
						connec=DriverManager.getConnection("jdbc:mysql://localhost:3306/babu","root","root");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

	public static MyConnections getInstance()
	{
		return myconnection;
	}
	}
