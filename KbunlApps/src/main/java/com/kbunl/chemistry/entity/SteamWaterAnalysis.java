package com.kbunl.chemistry.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class SteamWaterAnalysis {
	
	
	@Id 
	public Long id;
	
	public String unitName;
	public double unitLoad;

	public String sampleTime;

	@Index 
	public Date forDate;
	public Date updateTimestamp;
	
	
	List<Key<SteamWaterDetails>> steamWaterDetails=new ArrayList<Key<SteamWaterDetails>>();
	
	//Constructor	
	public SteamWaterAnalysis(){
		
	}
	public SteamWaterAnalysis(String unitNa,double unitL,Date forDa,List<Key<SteamWaterDetails>> steamWaterD){
		this.unitName=unitNa;
		this.unitLoad=unitL;
		
		this.sampleTime="10:00AM";
		this.forDate=forDa;
		this.updateTimestamp=new Date();
		
		this.steamWaterDetails =steamWaterD;
	}
	
	
	//Setter Getter
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public double getUnitLoad() {
		return unitLoad;
	}
	public void setUnitLoad(double unitLoad) {
		this.unitLoad = unitLoad;
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
	public List<Key<SteamWaterDetails>> getSteamWaterDetails() {
		return steamWaterDetails;
	}
	public void setSteamWaterDetails(List<Key<SteamWaterDetails>> steamWaterDetails) {
		this.steamWaterDetails = steamWaterDetails;
	}

	
	

}
