package com.kbunl.chemistry.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HydrogenPurityStatusServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
		
		    request.getRequestDispatcher("/WEB-INF/jspPages/chemistry/hydrogenPurityStatus.jsp").forward(request, response);
				
		}
		catch (ServletException ex) {
				
				response.getWriter().println(ex.getMessage());
				
		
		}catch(Exception ex){
			
			response.getWriter().println(ex.getMessage());
		}
		
		
	}

}
