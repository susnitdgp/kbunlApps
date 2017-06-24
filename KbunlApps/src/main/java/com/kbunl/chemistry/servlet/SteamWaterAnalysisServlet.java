package com.kbunl.chemistry.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.kbunl.chemistry.entity.SteamWaterAnalysis;
import com.kbunl.chemistry.entity.SteamWaterDetails;

public class SteamWaterAnalysisServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		       Date forDate=null;
		       try {

		           forDate = formatter.parse("13/06/2017");
		           

		        } catch (ParseException ex) {
		            
		        }
				//Testing Entity Relationship
				//Create Parent Object
		       
		        List<Key<SteamWaterDetails>> steamWaterDetailsKey=new ArrayList<Key<SteamWaterDetails>>();
				
				
				SteamWaterDetails swd1=new SteamWaterDetails("5.0-6.0",4.56,5.67);
				ObjectifyService.ofy().save().entity(swd1).now();
				Key<SteamWaterDetails> sk1=Key.create(SteamWaterDetails.class, swd1.getId());
				steamWaterDetailsKey.add(sk1);
				
				SteamWaterDetails swd2=new SteamWaterDetails("6.0-7.0",5.56,7.67);
				ObjectifyService.ofy().save().entity(swd2).now();
				Key<SteamWaterDetails> sk2=Key.create(SteamWaterDetails.class, swd2.getId());
				steamWaterDetailsKey.add(sk2);
				
				
				
				
				SteamWaterAnalysis swa=new SteamWaterAnalysis("UNIT1",87.78,forDate,steamWaterDetailsKey);
				ObjectifyService.ofy().save().entity(swa).now();
				
				//Testing End
				
				try{
					
					//Passing Blank object to JSP
					//request.setAttribute("dm", dm);
			    	request.getRequestDispatcher("/WEB-INF/jspPages/chemistry/steamWaterAnalysis.jsp").forward(request, response);
					
				}catch (ServletException ex) {
					
					response.getWriter().println(ex.getMessage());
					
				}catch(Exception ex){
					
					response.getWriter().println(ex.getMessage());
				}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
