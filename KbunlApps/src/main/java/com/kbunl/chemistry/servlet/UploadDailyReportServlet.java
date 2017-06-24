package com.kbunl.chemistry.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.math.BigInteger;
//import java.security.SecureRandom;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.kbunl.chemistry.entity.DailyUploadFile;


public class UploadDailyReportServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	private static final BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String state = new BigInteger(130, new SecureRandom()).toString(32);  // prevent request forgery
		//request.getSession().setAttribute("state", state);
		
		//Delete blob file using Blob Key
		//blobstoreService.delete(blobInfo.getBlobKey());
		
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

			//Passing Blank object to JSP
			request.setAttribute("listOfFiles", lsd);
			request.getRequestDispatcher("/WEB-INF/jspPages/chemistry/uploadDailyReport.jsp").forward(request, response);

		}
		catch (ServletException ex) {

			response.getWriter().println(ex.getMessage());


		}catch(Exception ex){

			response.getWriter().println(ex.getMessage());
		}

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
		List<BlobKey> blobKeys = blobs.get("myFile");
		
		String  message="";

		if (blobKeys == null || blobKeys.isEmpty()) {
			message="uploadERROR";
			response.sendRedirect("/Chemistry/UploadDailyReport?upload_status="+message);
		} else {
			message="uploadOK";
			response.sendRedirect("/Chemistry/UploadDailyReport?upload_status="+message);
		}

	}

}
