package com.infotech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class DBconnect {
	
	public PreparedStatement ps1, ps2, ps3;
	public ResultSet rs1, rs2, rs3;
	
	public static void main(String [] args)
	{
		DBconnect proj = new DBconnect();
		proj.createConnection();
	}
	
	public static Connection createConnection ()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
			System.out.println("DB connected");
			return connection;
		}
		 catch (SQLException ex) {
			// TODO Auto-generated catch block
			 Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE,null,ex);
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE,null,ex);
		}
		return null;
		
	}

}
