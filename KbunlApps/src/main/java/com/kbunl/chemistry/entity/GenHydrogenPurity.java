package com.kbunl.chemistry.entity;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class GenHydrogenPurity {
	
	@Id 
	public Long id;
	
	public double unit1OffValue;
	public double unit1OnValue;
	
	public double unit2OffValue;
	public double unit2OnValue;
	
	public double unit3OffValue;
	public double unit3OnValue;
	
	public double unit4OffValue;
	public double unit4OnValue;
	
	public String sampleTime;
	
	@Index 
	public Date forDate;
	
	public Date updateTimestamp;
	
	public String remarks;
	
	// Constructor
	public GenHydrogenPurity(){
		
	}
	public GenHydrogenPurity(double u1OffVal,double u1OnVal,double u2OffVal,double u2OnVal,
			double u3OffVal,double u3OnVal,double u4OffVal,double u4OnVal,
			String sampletime,Date forDa,String remark){
		
		this.unit1OffValue=u1OffVal;
		this.unit1OnValue=u1OnVal;
		
		this.unit2OffValue=u2OffVal;
		this.unit2OnValue=u2OnVal;
		
		this.unit3OffValue=u3OffVal;
		this.unit3OnValue=u3OnVal;
		
		this.unit4OffValue=u4OffVal;
		this.unit4OnValue=u4OnVal;
		
		
		this.sampleTime=sampletime;
		this.forDate=forDa;
		
		this.updateTimestamp=new Date();
		this.remarks=remark;
	}
	//Getter and Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getUnit1OffValue() {
		return unit1OffValue;
	}
	public void setUnit1OffValue(double unit1OffValue) {
		this.unit1OffValue = unit1OffValue;
	}
	public double getUnit1OnValue() {
		return unit1OnValue;
	}
	public void setUnit1OnValue(double unit1OnValue) {
		this.unit1OnValue = unit1OnValue;
	}
	public double getUnit2OffValue() {
		return unit2OffValue;
	}
	public void setUnit2OffValue(double unit2OffValue) {
		this.unit2OffValue = unit2OffValue;
	}
	public double getUnit2OnValue() {
		return unit2OnValue;
	}
	public void setUnit2OnValue(double unit2OnValue) {
		this.unit2OnValue = unit2OnValue;
	}
	public double getUnit3OffValue() {
		return unit3OffValue;
	}
	public void setUnit3OffValue(double unit3OffValue) {
		this.unit3OffValue = unit3OffValue;
	}
	public double getUnit3OnValue() {
		return unit3OnValue;
	}
	public void setUnit3OnValue(double unit3OnValue) {
		this.unit3OnValue = unit3OnValue;
	}
	public double getUnit4OffValue() {
		return unit4OffValue;
	}
	public void setUnit4OffValue(double unit4OffValue) {
		this.unit4OffValue = unit4OffValue;
	}
	public double getUnit4OnValue() {
		return unit4OnValue;
	}
	public void setUnit4OnValue(double unit4OnValue) {
		this.unit4OnValue = unit4OnValue;
	}
	public String getSampleTime() {
		return sampleTime;
	}
	public void setSampleTime(String sampleTime) {
		this.sampleTime = sampleTime;
	}
	public Date getForDate() {
		return forDate;
	}
	public void setForDate(Date forDate) {
		this.forDate = forDate;
	}
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
