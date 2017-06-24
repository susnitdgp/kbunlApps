package com.kbunl.chemistry.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.kbunl.chemistry.entity.DailyUploadFile;


public class ProcessDailyReportServlet  extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Iterator<BlobInfo> blobsIterator = blobInfoFactory.queryBlobInfos();
	
		List<DailyUploadFile> lsd=new ArrayList<DailyUploadFile>();
		
		 while (blobsIterator.hasNext()) {
			 BlobInfo blobInfo = (BlobInfo) blobsIterator.next();
			 
			
			 DailyUploadFile duf=new DailyUploadFile();
			 duf.setFileName(blobInfo.getFilename());
			 duf.setFileType(blobInfo.getContentType());
			 duf.setUploadDate(blobInfo.getCreation().toString());
			 duf.setSize(Long.toString(blobInfo.getSize()));
			 duf.setBlobKey(blobInfo.getBlobKey().getKeyString());
			 
			 lsd.add(duf);
		 }
		 
		 try{
								
				request.setAttribute("listOfFiles", lsd);
			    request.getRequestDispatcher("/WEB-INF/jspPages/chemistry/processDailyReport.jsp").forward(request, response);
					
		 }
		 catch (ServletException ex) {
					
					response.getWriter().println(ex.getMessage());
					
			
		 }catch(Exception ex){
				
				response.getWriter().println(ex.getMessage());
		 }
		
		 
	}

}
