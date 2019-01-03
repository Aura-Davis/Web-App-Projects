package com.dao;

import java.sql.SQLException;

import com.infotech.util.DBconnect;

public class EntryDao {
	
	
	
	
	public void submitEntry (String title, String content)
	{
		String sql = "insert into sales_rep_entry (city_id, title, content) values (?, ?, ?);";
		DBconnect entryDbc = new DBconnect();
		try {
			EntryDao entryDao = new EntryDao();
			int cityId = entryDao.getCurrentCity();			
			entryDbc.ps2 = DBconnect.createConnection().prepareStatement(sql);
			entryDbc.ps2.setInt(1, cityId);
			entryDbc.ps2.setString(2, title);
			entryDbc.ps2.setString(3, content);
			entryDbc.ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getCurrentCity()
	{
		String sql = "select * from current_city;";
		DBconnect dbc = new DBconnect();
		try {
			dbc.ps1 = DBconnect.createConnection().prepareStatement(sql);
			dbc.rs1 = dbc.ps1.executeQuery();
			int cityId = 0;
			if (dbc.rs1.next()) cityId = dbc.rs1.getInt("city_id");
			System.out.println("In getcurrentCity " + cityId);
			
			return cityId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public String [] getEntries()
	{
		String sql = "select * from sales_rep_entry where city_id =?;";
		DBconnect dbc = new DBconnect();
		EntryDao entryDao = new EntryDao();
		int cityId = entryDao.getCurrentCity();
		System.out.println("In getEntries " + cityId);
		String cityIdString = Integer.toString(cityId);
		System.out.println(cityIdString);
		try {
			dbc.ps1 = DBconnect.createConnection().prepareStatement(sql);
			//dbc.ps1.setString(1, cityIdString);
			dbc.ps1.setInt(1, cityId);
			dbc.rs1 = dbc.ps1.executeQuery();
			dbc.rs1.last();
			int size = dbc.rs1.getRow();
			dbc.rs1.beforeFirst();
			String [] entries = new String [size];
			for (int i = 0; dbc.rs1.next() ;i++)
			{
				entries[i] = dbc.rs1.getString("title");
				System.out.println(entries[i]);
			}
			return entries;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
