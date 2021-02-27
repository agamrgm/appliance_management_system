package com.dbconnection;
import java.sql.*;
public class DataBaseConnection 
{
	private static Connection con;
	public static Connection connection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","root");
		}
		catch(ClassNotFoundException|SQLException ae)
		{
			ae.printStackTrace();
		}
		return con;
	}
	}
	
