package Utility;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnector {
	
	public static Connection getConnection() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/CRMS","puru","puru");
			return con;
		} 
		catch (Exception e) {
			return null;
		}
	}
}
