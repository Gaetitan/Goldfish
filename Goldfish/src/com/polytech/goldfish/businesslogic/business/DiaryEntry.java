package com.polytech.goldfish.businesslogic.business;

import java.sql.Date;
import java.sql.Time;

/**
 * Business class DiaryEntry
 * @author Gaëtan FRANÇOIS
 *
 */
public class DiaryEntry {

	// Attributes
	private Integer id;
	private String name;
	private Date date;
	private Time time;
	/**
	 * True : the DiaryEntry is visible by anyone
	 * False : the DiaryEntry is visible only by its user
	 */
	private final boolean visibility;
	
	// Constructors
	public DiaryEntry(Integer id, String name, Date date, Time time,
			boolean visibility) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.visibility = visibility;
	}
	
	// Getters & setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public boolean isVisibility() {
		return visibility;
	}
	
	// Other methods
}
