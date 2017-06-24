package com.kbunl.chemistry.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class DailyReportDownloadServlet extends HttpServlet  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		if(request.getParameter("blob-key") !=null && !request.getParameter("blob-key").isEmpty()){
			
			BlobKey blobKey = new BlobKey(request.getParameter("blob-key"));
			
	        blobstoreService.serve(blobKey, response);
		
		}else{
			
			response.getWriter().println("Nothing to Display");
			
		}
	}

}
