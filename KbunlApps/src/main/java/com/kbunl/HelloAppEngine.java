/**
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kbunl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;
import com.kbunl.entity.Greeting;

public class HelloAppEngine extends HttpServlet {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
      
	
	//Retrieve Entity List with Query
	
	List<Greeting> greetings = ObjectifyService.ofy()
	          .load()
	          .type(Greeting.class) // We want only Greetings
	          .order("-date")       // Most recent first - date is indexed.
	          .limit(5)             // Only show 5 of them.
	          .list();
	
	
	request.setAttribute("greetings", greetings);
    try{
		
    	request.getRequestDispatcher("/jspPages/greetings.jsp").forward(request, response);
		
	}catch (ServletException ex) {
		
		response.getWriter().println(ex.getMessage());
		
	}catch(Exception ex){
		
		response.getWriter().println(ex.getMessage());
	}
	
  }
}
