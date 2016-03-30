package com.polytech.goldfish.businesslogic.business;

import java.sql.Date;

/**
 * Business class Quotation
 * @author Gaëtan FRANÇOIS
 *
 */
public class Quotation {

	// Attributes
	private Integer num_quotation;
	private Date date;
	private Float price;
	
	// Constructors
	public Quotation(Integer id, Date date, Float price) {
		super();
		this.num_quotation = id;
		this.date = date;
		this.price = price;
	}
	
	// Getters & setters
	public Integer getId() {
		return num_quotation;
	}

	public void setId(Integer id) {
		this.num_quotation = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
