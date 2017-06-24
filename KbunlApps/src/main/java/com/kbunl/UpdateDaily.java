package com.kbunl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;
import com.kbunl.entity.DailyParameter;


public class UpdateDaily extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDaily() {
        super();
        
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DailyParameter dpm=new DailyParameter();
		
		request.setAttribute("dpm", dpm);
		
		try{
			
	    	request.getRequestDispatcher("/jspPages/UpdateDaily.jsp").forward(request, response);
			
		}catch (ServletException ex) {
			
			response.getWriter().println(ex.getMessage());
			
		}catch(Exception ex){
			
			response.getWriter().println(ex.getMessage());
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errors = new HashMap<String, String>();
		
		String makeUpWater=request.getParameter("makeUpWater");  
		
		//String coalGcv=request.getParameter("coalGcv"); 
		
		//Form Validation
		
		if(makeUpWater == null || makeUpWater.isEmpty()){
			errors.put("makeUpWater","Make Up Water is Blank");
			errors.put("makeUpWater_error","true");
		}
		
		
		if(errors.isEmpty()){
			
			try{
				
				DailyParameter dpm=new DailyParameter("MAKEUP_WATER",makeUpWater,new Date());
				ObjectifyService.ofy().save().entity(dpm).now();
				 
				response.sendRedirect("/jspPages/UpdateDailySuccess.jsp");
				//request.getRequestDispatcher("/jspPages/UpdateDailySuccess.jsp").forward(request, response);
				
			}catch(Exception ex){
				
				response.getWriter().println(ex.getMessage());
			}
			
		}else{
			
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/jspPages/UpdateDaily.jsp").forward(request, response);
		}
	
	}

}
