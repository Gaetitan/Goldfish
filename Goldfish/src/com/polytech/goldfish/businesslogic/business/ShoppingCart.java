package com.polytech.goldfish.businesslogic.business;

/**
 * Business class ShoppingCart
 * @author Gaëtan FRANÇOIS
 *
 */
public class ShoppingCart {
	
	// Attributes
	private Integer id;

	// Constructor
	public ShoppingCart(Integer id) {
		super();
		this.id = id;
	}

	// Getters & setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
