package com.kbunl.entity;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class DailyParameter {
	
	@Id 
	public Long id;
	
	@Index 
	public Date date;
	public String paramName;
	public String paramVal;
	
	
	// Constructor
	public DailyParameter(){
		date = new Date();
	}
	public DailyParameter(String paramname,String paramval,Date paramdate){
		this.paramName=paramname;
		this.paramVal=paramval;
		this.date=paramdate;
	}
	
	//Getter and Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamVal() {
		return paramVal;
	}
	public void setParamVal(String paramVal) {
		this.paramVal = paramVal;
	}
	
	
	

}
