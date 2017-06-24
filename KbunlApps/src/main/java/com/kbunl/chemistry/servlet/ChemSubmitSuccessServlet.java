package com.kbunl.chemistry.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChemSubmitSuccessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("message", request.getParameter("message"));
		request.setAttribute("key",request.getParameter("key"));
		
		try{
			
	    	request.getRequestDispatcher("/WEB-INF/jspPages/chemistry/chemSubmitSuccess.jsp").forward(request, response);
			
		}catch (ServletException ex) {
			
			response.getWriter().println(ex.getMessage());
			
		}catch(Exception ex){
			
			response.getWriter().println(ex.getMessage());
		}
		
	}

}
