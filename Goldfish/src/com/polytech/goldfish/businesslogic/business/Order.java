package com.polytech.goldfish.businesslogic.business;

import java.sql.Date;

/**
 * Business class Order
 * @author Gaëtan FRANÇOIS
 *
 */
public class Order {

	// Attributes
	private Integer num_order;
	private Date date;
	private Float shipping_cost;
	private Float price;
	
	// Constructors
	public Order(Integer num_order, Date date, Float shipping_cost, Float price) {
		super();
		this.num_order = num_order;
		this.date = date;
		this.shipping_cost = shipping_cost;
		this.price = price;
	}

	// Getters & setters	
	public Integer getNum_order() {
		return num_order;
	}

	public void setNum_order(Integer num_order) {
		this.num_order = num_order;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getShipping_cost() {
		return shipping_cost;
	}

	public void setShipping_cost(Float shipping_cost) {
		this.shipping_cost = shipping_cost;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	// Other methods
	public Float calculatePrice(){
		return this.price + this.shipping_cost;
	}
	
	
}
