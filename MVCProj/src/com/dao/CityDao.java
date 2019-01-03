package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infotech.util.DBconnect;

public class CityDao 
{
	public int getCurrentUser()
	{
		String sql = "select * from login;";
		DBconnect dbc = new DBconnect();
		try {
			dbc.ps1 = DBconnect.createConnection().prepareStatement(sql);
			dbc.rs1 = dbc.ps1.executeQuery();
			dbc.rs1.next();
			String username = dbc.rs1.getString("username");
			System.out.println(username);
			sql = "select * from sales_rep where username = ?";
			dbc.ps2 = DBconnect.createConnection().prepareStatement(sql);
			dbc.ps2.setString(1, username);
			dbc.rs2 = dbc.ps2.executeQuery();
			dbc.rs2.next();
			int id = dbc.rs2.getInt("id");
			System.out.println(id);
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public String [] getCities()
	{
		String sql = "select * from city where sr_id =?;";
		DBconnect dbc = new DBconnect();
		CityDao cityDao = new CityDao();
		int id = cityDao.getCurrentUser();
		String idString = Integer.toString(id);
		System.out.println(idString);
		try {
			dbc.ps1 = DBconnect.createConnection().prepareStatement(sql);
			dbc.ps1.setString(1, idString);
			dbc.rs1 = dbc.ps1.executeQuery();
			dbc.rs1.last();
			int size = dbc.rs1.getRow();
			dbc.rs1.beforeFirst();
			String [] cities = new String [size];
			for (int i = 0; dbc.rs1.next();i++)
			{
				cities[i] = dbc.rs1.getString("name");
				System.out.println(cities[i]);
			}
			return cities;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setCity(String city)
	{
		String sql = "select * from city where name=?;";
		DBconnect entryDbc = new DBconnect();
		try {
			entryDbc.ps1 = DBconnect.createConnection().prepareStatement(sql);
			entryDbc.ps1.setString(1, city);
			entryDbc.rs1 = entryDbc.ps1.executeQuery();
			int cityId = 0;
			if (entryDbc.rs1.next()) cityId = entryDbc.rs1.getInt("id");
			sql = "insert into current_city (city_id) values (?);";
			entryDbc.ps2 = DBconnect.createConnection().prepareStatement(sql);
			entryDbc.ps2.setInt(1, cityId);
			entryDbc.ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
