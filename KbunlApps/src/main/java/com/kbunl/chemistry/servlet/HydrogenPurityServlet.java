package com.kbunl.chemistry.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.kbunl.chemistry.entity.GenHydrogenPurity;

public class HydrogenPurityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GenHydrogenPurity genH=new GenHydrogenPurity();
		
		try{
			
			//Passing Blank object to JSP
			request.setAttribute("genH", genH);
		    request.getRequestDispatcher("/WEB-INF/jspPages/chemistry/genHydrogenPurity.jsp").forward(request, response);
				
		}
		catch (ServletException ex) {
				
				response.getWriter().println(ex.getMessage());
				
		
		}catch(Exception ex){
			
			response.getWriter().println(ex.getMessage());
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		
		GenHydrogenPurity genH=new GenHydrogenPurity();
		genH.setUnit1OffValue(98.7);
		genH.setUnit1OnValue(98.2);
		
		genH.setUnit2OffValue(97.8);
		genH.setUnit2OnValue(98.6);
		
		genH.setUnit3OffValue(97.5);
		genH.setUnit3OnValue(98.9);
		
		genH.setUnit4OffValue(97.9);
		genH.setUnit4OnValue(97.2);
		
		genH.setSampleTime("10:00AM");
		genH.setUpdateTimestamp(new Date());
		genH.setRemarks("N/A");
		
		try {
			genH.setForDate(formatter.parse("15/05/2017"));
		} catch (ParseException e) {
			
			genH.setForDate(new Date());
		}
		
		Key<GenHydrogenPurity> genhKey=ObjectifyService.ofy().save().entity(genH).now();
		String message="New Row Inserted";
		
		response.sendRedirect("/Chemistry/ChemSubmitSuccess?message="+message +"&key="+ Long.toString(genhKey.getId()));
		
	}

}
