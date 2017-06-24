package com.kbunl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.googlecode.objectify.ObjectifyService;
import com.kbunl.entity.DailyParameter;



public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve Entity List with Query

		List<DailyParameter> params = ObjectifyService.ofy()
		          .load()
		          .type(DailyParameter.class) // We want only Greetings
		          .order("-date")       // Most recent first - date is indexed.
		          .limit(5)             // Only show 5 of them.
		          .list();
		
		String json = new Gson().toJson(params);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
	}

	

}
