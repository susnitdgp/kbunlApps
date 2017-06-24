package com.kbunl.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

//import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
//import com.googlecode.objectify.annotation.Parent;

@Entity
public class Greeting {
	
	//@Parent Key<GuestBook> theBook;
	
	@Id 
	public Long id;

	public String author_email;
	public String author_id;
	public String content;
	
	@Index 
	public Date date;
	
	
	/**
	   * Simple constructor just sets the date
	   **/
	  public Greeting() {
	    date = new Date();
	  }

	  

	  /**
	   * Takes all important fields
	   **/
	  public Greeting(String content, String auth_id, String email) {
	    this.content=content;
	    this.author_email = email;
	    this.author_id = auth_id;
	    this.date=new Date();
	  }



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getAuthor_email() {
		return author_email;
	}



	public void setAuthor_email(String author_email) {
		this.author_email = author_email;
	}



	public String getAuthor_id() {
		return author_id;
	}



	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getDate() {
		DateFormat indianFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		indianFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		return indianFormat.format(this.date);
	}



	public void setDate(Date date) {
		this.date = date;
	}
	  
	  

}
