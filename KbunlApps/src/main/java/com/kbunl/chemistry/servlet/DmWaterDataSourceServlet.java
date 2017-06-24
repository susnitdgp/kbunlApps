package com.kbunl.chemistry.servlet;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.repackaged.org.joda.time.DateTime;
import com.google.visualization.datasource.DataSourceServlet;
import com.google.visualization.datasource.base.DataSourceException;
import com.google.visualization.datasource.base.TypeMismatchException;
import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.google.visualization.datasource.query.Query;
import com.googlecode.objectify.ObjectifyService;
import com.kbunl.chemistry.entity.DmWaterProdConsumption;

public class DmWaterDataSourceServlet extends DataSourceServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public DataTable generateDataTable(Query arg0, HttpServletRequest request) throws DataSourceException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		String fromDate=null;
		
		String toDate=request.getParameter("toDate");
		
		//From Date Sanitize
		if(request.getParameter("fromDate")==null || request.getParameter("fromDate").isEmpty()){
			
			//Joda Time for Date Manipulation
			DateTime temp=new DateTime(new Date());
			fromDate=formatter.format(temp.minusDays(7).toDate());
			
		}else{
			fromDate=request.getParameter("fromDate");
		}
		
		
		//To Date Sanitize
		if(request.getParameter("toDate")==null || request.getParameter("toDate").isEmpty()){
			toDate=formatter.format(new Date());
		}else{
			toDate=request.getParameter("toDate");
		}
		
		 //Create a data table,
	    DataTable data = new DataTable();
	    ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
	    
	    cd.add(new ColumnDescription("date", ValueType.TEXT, "Date"));
	    cd.add(new ColumnDescription("production", ValueType.NUMBER, "Production"));
	    cd.add(new ColumnDescription("stage1Cons", ValueType.NUMBER, "Stage1 Consumption"));
	    cd.add(new ColumnDescription("stage2Cons", ValueType.NUMBER, "Stage2 Consumption"));
	    cd.add(new ColumnDescription("stock", ValueType.NUMBER, "Stock"));

	    data.addColumns(cd);
	    
	    
	    try {
	    	
	    	  //String to Date Parsing
	          Date formD = formatter.parse(fromDate);
	          Date toD = formatter.parse(toDate);
	          data.setCustomProperty("customMessage", "Line Chart: "+fromDate + " to " +toDate);
	          
	          List<DmWaterProdConsumption> params = ObjectifyService.ofy()
			          .load()
			          .type(DmWaterProdConsumption.class)  // We want only DmWaterProdConsumption 
			          .filter("forDate >=", formD).filter("forDate <=", toD) //Date Filter
			          .order("forDate")  		  // Most recent first - updateTimestamp is indexed.
			          .limit(10)                         // Only show 10 of them.
			          .list();
	         
	          
	        //Fill the data table.
	        if(params.size() ==0){
	        	data.setCustomProperty("customMessage", "Not Data Found For The Range");
	        	
	        }else{
	        	
	        	for(DmWaterProdConsumption temp:params){
		  	    	
	  	    	 	try{
	  		   	      
	  	    	 		data.addRowFromValues(formatter.format(temp.getForDate()),temp.getProduction(), temp.getStage1Consumption(),temp.getStage2Consumption(),temp.getStock());
	  	   	    	} 
	  	    	 	catch (TypeMismatchException ex) {
	  	    	 	
	  	    	 	}
	        	}
	        	
	        }
	     } catch (ParseException ex) {
	            
	     }

	    return data;
	}
	@Override
	protected boolean isRestrictedAccessMode() {
		
		//return super.isRestrictedAccessMode();
		return false;
	}

}
