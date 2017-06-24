package com.kbunl.chemistry.servlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.visualization.datasource.DataSourceServlet;
import com.google.visualization.datasource.base.DataSourceException;
import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.google.visualization.datasource.query.Query;
import com.googlecode.objectify.ObjectifyService;
import com.kbunl.chemistry.entity.GenHydrogenPurity;

public class HydrogenDataSourceServlet extends DataSourceServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public DataTable generateDataTable(Query arg0, HttpServletRequest request) throws DataSourceException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		
		//Create a data table,
	    DataTable data = new DataTable();
	    ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
	    
	    cd.add(new ColumnDescription("date", ValueType.TEXT, "Date"));
	    cd.add(new ColumnDescription("u1off", ValueType.NUMBER, "U1#OFF"));
	    cd.add(new ColumnDescription("u1on", ValueType.NUMBER, "U1#ON"));
	    
	    cd.add(new ColumnDescription("u2off", ValueType.NUMBER, "U2#OFF"));
	    cd.add(new ColumnDescription("u2on", ValueType.NUMBER, "U2#ON"));
	    
	    cd.add(new ColumnDescription("u3off", ValueType.NUMBER, "U3#OFF"));
	    cd.add(new ColumnDescription("u3on", ValueType.NUMBER, "U3#ON"));
	    
	    cd.add(new ColumnDescription("u4off", ValueType.NUMBER, "U4#OFF"));
	    cd.add(new ColumnDescription("u4on", ValueType.NUMBER, "U4#ON"));
	    
	    data.addColumns(cd);
	    
	    try {
			Date formD = formatter.parse("05/06/2017");
			Date toD = formatter.parse("18/06/2017");
			
			 List<GenHydrogenPurity> params = ObjectifyService.ofy()
			          .load()
			          .type(GenHydrogenPurity.class)  
			          .filter("forDate >=", formD).filter("forDate <=", toD) 
			          .order("forDate")  		  
			          .limit(10)                        
			          .list();
			 
			 for(GenHydrogenPurity temp:params){
				 
				 data.addRowFromValues(formatter.format(temp.getForDate()),temp.getUnit1OffValue(),temp.getUnit1OnValue(),
						 temp.getUnit2OffValue(),temp.getUnit2OffValue(),
						 temp.getUnit3OffValue(),temp.getUnit3OnValue(),
						 temp.getUnit4OffValue(),temp.getUnit4OnValue());
			 }
			
			
		} catch (ParseException e) {
			
		}
        
		
		return data;
	}
	@Override
	protected boolean isRestrictedAccessMode() {
		
		//return super.isRestrictedAccessMode();
		return false;
	}

}
