package com.kbunl.chemistry.entity;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class DmWaterProdConsumption {
	
	@Id 
	public Long id;
	
	public double production;
	public double stage1Consumption;
	public double stage2Consumption;
	public double stock;
	
	public String sampleTime;

	@Index
	public Date forDate;
	
	public Date updateTimestamp;
	
	//Constructor
	public DmWaterProdConsumption(){
		
	}
	public DmWaterProdConsumption(double prod,double stage1,double stage2,double sto,String sampletime,Date forDa){

		this.production=prod;
		this.stage1Consumption=stage1;
		this.stage2Consumption=stage2;
		this.stock=sto;
		this.sampleTime=sampletime;
		
		this.forDate=forDa;
		this.updateTimestamp=new Date();
	}
	//Getter Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getProduction() {
		return production;
	}
	public void setProduction(double production) {
		this.production = production;
	}
	public double getStage1Consumption() {
		return stage1Consumption;
	}
	public void setStage1Consumption(double stage1Consumption) {
		this.stage1Consumption = stage1Consumption;
	}
	public double getStage2Consumption() {
		return stage2Consumption;
	}
	public void setStage2Consumption(double stage2Consumption) {
		this.stage2Consumption = stage2Consumption;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
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
	
	
	
}
