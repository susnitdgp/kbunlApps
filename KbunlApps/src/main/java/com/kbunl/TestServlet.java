package com.kbunl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;
import com.kbunl.entity.DailyParameter;
import com.kbunl.entity.Greeting;


public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException {
	      
		// Save Entity
		Greeting greeting=new Greeting("Hello from Goswami","Susanta Goswami","susnitdgp@gmail.com");
		DailyParameter dpm=new DailyParameter("MAKEUP_WATER","435.89",new Date());
		
		// Use Objectify to save the greeting and now() is used to make the call synchronously as we
	    // will immediately get a new page using redirect and we want the data to be present.
	    ObjectifyService.ofy().save().entity(greeting).now();
	    ObjectifyService.ofy().save().entity(dpm).now();
	    
	    response.setContentType("text/plain");
	    response.getWriter().println("Hello From Test Again Servlet: Greeting/Dpm Inserted");
	  
	 }
	
}
