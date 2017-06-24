package com.kbunl.chemistry.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.kbunl.chemistry.entity.DmWaterProdConsumption;


public class DmWaterProdConsumptionServlet  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Create a Blank Object
		DmWaterProdConsumption dm=new DmWaterProdConsumption();
		
		try{
			
			//Passing Blank object to JSP
			request.setAttribute("dm", dm);
		    request.getRequestDispatcher("/WEB-INF/jspPages/chemistry/dmWaterProdConsumption.jsp").forward(request, response);
				
		}
		catch (ServletException ex) {
				
				response.getWriter().println(ex.getMessage());
				
		
		}catch(Exception ex){
			
			response.getWriter().println(ex.getMessage());
		}

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double prod_val=0.0;
		double stage1_val=0.0;
		double stage2_val=0.0;
		double stock_val=0.0;
		Date date_val=null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Map<String, String> errors = new HashMap<String, String>();
		
		//Validate Form parameter First
		
		String production=request.getParameter("production");
		String stage1Consumption=request.getParameter("stage1Consumption");
		String stage2Consumption=request.getParameter("stage2Consumption");
		String stock=request.getParameter("stock");
		String dateInput=request.getParameter("dateInput");
		
		//Validation Starts
		if(production == null || production.isEmpty()){
			errors.put("production","Production is Blank");
		}else{
			
			try {
				prod_val=Double.parseDouble(production);
			}catch(NumberFormatException ex){
				
				errors.put("production","Production: "+ex.getMessage());
			}
		}
		
		if(stage1Consumption == null || stage1Consumption.isEmpty()){
			errors.put("stage1Consumption","stage1Consumption is Blank");
		}else{
			
			try {
				stage1_val=Double.parseDouble(stage1Consumption);
			}catch(NumberFormatException ex){
				
				errors.put("stage1Consumption","stage1Consumption: "+ex.getMessage());
			}
		}
		
		if(stage2Consumption == null || stage2Consumption.isEmpty()){
			errors.put("stage2Consumption","stage2Consumption is Blank");
		}else{
			
			try {
				stage2_val=Double.parseDouble(stage2Consumption);
			}catch(NumberFormatException ex){
				
				errors.put("stage2Consumption","stage2Consumption: "+ex.getMessage());
			}
		}
		
		if(stock == null || stock.isEmpty()){
			errors.put("stock","stock is Blank");
		}else{
			
			try {
				stock_val=Double.parseDouble(stock);
			}catch(NumberFormatException ex){
				
				errors.put("stock","stock: "+ex.getMessage());
			}
		}
		
		if(dateInput ==null || dateInput.isEmpty()){
			errors.put("dateInput","Date is Blank");
		}else{
			
			try {

	           date_val = formatter.parse(dateInput);
	           

	        } catch (ParseException ex) {
	            errors.put("dateInput","dateInput: "+ex.getMessage());
	        }
		}
		
		//Validation Ends
		
		if(errors.isEmpty()){
			
			try{
				String message="";
				String key="";
				
				List<DmWaterProdConsumption> existingList = ObjectifyService.ofy()
		        		  .load().type(DmWaterProdConsumption.class)
		        		  .filter("forDate =",date_val).list();
				
				if(existingList.isEmpty()){
					
					DmWaterProdConsumption dm=new DmWaterProdConsumption(prod_val,stage1_val,stage2_val,stock_val,"10:00AM",date_val);
			
					Key<DmWaterProdConsumption> insertKey=ObjectifyService.ofy().save().entity(dm).now();
					message="New Row Inserted";
					key=Long.toString(insertKey.getId());
					
				}else{
					
					DmWaterProdConsumption existingObject=existingList.get(0);
					Key<DmWaterProdConsumption> fetchKey = Key.create(DmWaterProdConsumption.class, existingObject.getId());
					DmWaterProdConsumption dpc=ObjectifyService.ofy().load().key(fetchKey).now();
					
					dpc.setProduction(prod_val);
					dpc.setStage1Consumption(stage1_val);
					dpc.setStage2Consumption(stage2_val);
					dpc.setStock(stock_val);
					dpc.setSampleTime("10:00AM");
					dpc.setForDate(date_val);
					
					ObjectifyService.ofy().save().entity(dpc).now();
					
					message="Existing Row Updated";
					key=Long.toString(existingObject.getId());
					
				}
				
				response.sendRedirect("/Chemistry/ChemSubmitSuccess?message="+message +"&key="+key);
				
			}catch(Exception ex){
				
				response.getWriter().println(ex.getMessage());
			}
			
		}else{
			
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/WEB-INF/jspPages/chemistry/dmWaterProdConsumption.jsp").forward(request, response);
			
			
		}
		
		
		
	}

}
