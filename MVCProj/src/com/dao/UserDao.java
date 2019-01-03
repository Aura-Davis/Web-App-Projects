package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infotech.util.DBconnect;
import com.mysql.cj.protocol.Resultset;
import com.sun.crypto.provider.RSACipher;

public class UserDao 
{
	public ResultSet getUser(String username, String password)
	{
		String sql = "select * from sales_rep where username =? and password =?;";
		DBconnect dbc = new DBconnect();
		try {
			dbc.ps1 = DBconnect.createConnection().prepareStatement(sql);
			dbc.ps1.setString(1, username);
			dbc.ps1.setString(2, password);
			dbc.rs1 = dbc.ps1.executeQuery();
			return dbc.rs1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void loginUser (String username)
	{
		String sql = "insert into login (username) values (?);";
		DBconnect dbc = new DBconnect();
		try {
			dbc.ps1 = DBconnect.createConnection().prepareStatement(sql);
			dbc.ps1.setString(1, username);
			dbc.ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkIfLoggedin()
	{
		String sql = "select * from login;";
		DBconnect dbc = new DBconnect();
		try {
			dbc.ps1 = DBconnect.createConnection().prepareStatement(sql);
			dbc.rs3 = dbc.ps1.executeQuery();
			return dbc.rs3.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void logoutUser ()
	{
		String sql = "DELETE FROM login;";
		DBconnect dbc = new DBconnect();
		try {
			dbc.ps1 = DBconnect.createConnection().prepareStatement(sql);
			dbc.ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
