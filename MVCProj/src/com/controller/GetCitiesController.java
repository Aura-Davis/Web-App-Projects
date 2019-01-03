package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CityDao;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;

/**
 * Servlet implementation class GetCitiesController
 */
@WebServlet("/GetCitiesController")
public class GetCitiesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCitiesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String titleName = request.getParameter("titleName");
		String [] cities = new CityDao().getCities();
        response.setContentType("text/html");
        response.getWriter().write(cityArraytoJson(cities));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.setContentType("text/plain");
		//response.getWriter().write(cityArraytoJson());
		
		//String [] cities = new CityDao().getCities();
		//for (int i = 0; i < cities.length; i++) response.getWriter().write(cities[i]);
		//request.getRequestDispatcher(cities).forward(request, response);
		
		
	}
	
	public String cityArraytoJson(String [] cities)
	{
		StringBuffer cityJson = new StringBuffer("{\"title\":{");
		cityJson.append("\"name\": \"Cities\",");
		cityJson.append("\"cities\": [");
		for (int i = 0; i < cities.length; i++)
		{
		cityJson.append("{\"name\": \"" + cities[i] + "\"}");
		if (i != (cities.length - 1)) cityJson.append(",");
		}
		cityJson.append("]}}");
		return cityJson.toString();
	}

}
