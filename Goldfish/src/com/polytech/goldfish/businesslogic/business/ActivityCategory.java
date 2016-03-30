package com.polytech.goldfish.businesslogic.business;

/**
 * Business class ActivityCategory
 * @author Gaëtan FRANÇOIS
 *
 */
public class ActivityCategory {

	// Attributes
	private Integer id;
	private String name;
	private String short_description;
	private String detailed_description;
	
	// Constructors
	public ActivityCategory(Integer id, String name, String short_description,
			String detailed_description) {
		super();
		this.id = id;
		this.name = name;
		this.short_description = short_description;
		this.detailed_description = detailed_description;
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
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public String getDetailed_description() {
		return detailed_description;
	}
	public void setDetailed_description(String detailed_description) {
		this.detailed_description = detailed_description;
	}
	
}
