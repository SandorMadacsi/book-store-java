package com.bs.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	
	
	private static Connection con;

	//establish database connection
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("starting connection");
			if(con == null) {
				//This code enable Singleton
				System.out.println("starting connection");
				con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bookshop","root","root");
				System.out.println("Finishing connection");
				System.out.println(con);
			}
		}
		catch(ClassNotFoundException e)
		{
			return null;
		}
		catch(SQLException e)
		{
			return null;
		}

		return con;
	}
	
	

}
