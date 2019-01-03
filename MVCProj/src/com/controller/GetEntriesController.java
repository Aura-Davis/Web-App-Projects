package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CityDao;
import com.dao.EntryDao;

/**
 * Servlet implementation class GetEntriesController
 */
@WebServlet("/GetEntriesController")
public class GetEntriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEntriesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String [] entries = new EntryDao().getEntries();
        response.setContentType("text/html");
        response.getWriter().write(entryArraytoJson(entries));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
	
	public String entryArraytoJson(String [] entries)
	{
		StringBuffer entryJson = new StringBuffer("{\"title\":{");
		entryJson.append("\"name\": \"Entries\",");
		entryJson.append("\"entries\": [");
		for (int i = 0; i < entries.length; i++)
		{
		entryJson.append("{\"name\": \"" + entries[i] + "\"}");
		if (i != (entries.length - 1)) entryJson.append(",");
		}
		entryJson.append("]}}");
		return entryJson.toString();
	}

}
