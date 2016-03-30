package com.polytech.goldfish.businesslogic.business;

import java.util.Date;

/**
 * Business class Comment
 * @author Ga�tan FRAN�OIS
 *
 */
public class Comment {

	// Attributes
	private Integer id;
	private String concerned;
	private String poster;
	private String text;
	private Date date;
	
	// Constructors
	public Comment(Integer id, String concerned, String poster, String text,Date date) {
		super();
		this.id = id;
		this.concerned = concerned;
		this.poster = poster;
		this.text = text;
		this.date = date;
	}

	// Getters & setters
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getConcerned() {
		return concerned;
	}
	
	public void setConcerned(String concerned) {
		this.concerned = concerned;
	}


	public String getPoster() {
		return poster;
	}
	
	public void setPoster(String poster) {
		this.poster = poster;
	}
		
}
