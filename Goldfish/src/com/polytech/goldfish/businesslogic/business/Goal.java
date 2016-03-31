package com.polytech.goldfish.businesslogic.business;

import java.sql.Date;

/**
 * Business class Goal
 * @author Ga�tan FRAN�OIS
 *
 */
public class Goal {

	// Attributes
	private Integer id;
	private String name;
	private String description;
	private Date deadline;
	private Date date_creation;

	// Constructors
	public Goal(Integer id, String name, String description, Date deadline,
			Date date_creation) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.deadline = deadline;
		this.date_creation = date_creation;
	}
	
	public Goal() {
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	// Other methods

}
