package com.polytech.goldfish.businesslogic.business;

import java.sql.Date;
import java.sql.Time;

/**
 * @author RedaM
 *
 */
public class DiaryEntry {

	// Attributes
	private Integer id;
	private Integer idPerson;
	private String name;
	private Date date;
	private Time time;
	/**
	 * True : the DiaryEntry is visible by anyone
	 * False : the DiaryEntry is visible only by its user
	 */
	private boolean visibility;

	// Constructors
	public DiaryEntry(Integer id, Integer idPerson, String name, Date date, Time time, boolean visibility) {
		super();
		this.id = id;
		this.idPerson = idPerson;
		this.name = name;
		this.date = date;
		this.time = time;
		this.visibility = visibility;
	}
	
	public DiaryEntry(){
		
	}

	// Getters & setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
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

	public boolean getVisibility() {
		return visibility;
	}
	
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	// Other methods
}