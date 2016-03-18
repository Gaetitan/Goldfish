package com.polytech.goldfish.businesslogic.business;

/**
 * Business class Adress
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class Address {

	// Attributes
	private Integer id;
	private String street;
	private Integer street_number;
	private Integer zip_code;
	private String city;
	
	// Constructors
	public Address(Integer id, String street, Integer street_number, Integer zip_code,
			String city) {
		super();
		this.id = id;
		this.street = street;
		this.street_number = street_number;
		this.zip_code = zip_code;
		this.city = city;
	}
	
	// Getters & setters
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public Integer getStreet_number() {
		return street_number;
	}
	
	public void setStreet_number(Integer street_number) {
		this.street_number = street_number;
	}
	
	public Integer getZip_code() {
		return zip_code;
	}
	
	public void setZip_code(Integer zip_code) {
		this.zip_code = zip_code;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
}
