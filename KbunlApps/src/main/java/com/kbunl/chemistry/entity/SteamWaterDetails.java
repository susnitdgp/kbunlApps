package com.kbunl.chemistry.entity;

//import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
//import com.googlecode.objectify.annotation.Parent;

@Entity
public class SteamWaterDetails {
	
	//@Parent
	//Key<SteamWaterAnalysis> SteamWaterAnalysisFor;
	
	@Id 
	public Long id;
	
	//public String sampleName;
	
	public String phLimit;
	public double phValue;
	public double phSwas;
	/*
	public String condLimit;
	public double condValue;
	public double condSwas;
	
	public String sio2Limit;
	public double sio2Value;
	public double sio2Swas;
	
	public String phosLimit;
	public double phosValue;
	
	public String hydraLimit;
	public double hydraValue;
	
	public String nh3Limit;
	public double nh3Value;
	
	public String doppbLimit;
	public double doppbValue;
	public double doppbSwas;
	
	public String accLimit;
	public double accValue;
	
	*/
	public SteamWaterDetails(){
		
	}
	public SteamWaterDetails(String phLim,double phVal,double phSwa){
		
		//SteamWaterAnalysisFor=Key.create(SteamWaterAnalysis.class,parentKey.getId());
		this.phLimit=phLim;
		this.phValue=phVal;
		this.phSwas=phSwa;
	}
	//Getter Setter
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhLimit() {
		return phLimit;
	}
	public void setPhLimit(String phLimit) {
		this.phLimit = phLimit;
	}
	public double getPhValue() {
		return phValue;
	}
	public void setPhValue(double phValue) {
		this.phValue = phValue;
	}
	public double getPhSwas() {
		return phSwas;
	}
	public void setPhSwas(double phSwas) {
		this.phSwas = phSwas;
	}
	
	
}
