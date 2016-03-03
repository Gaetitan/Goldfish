package com.polytech.goldfish.businesslogic.business;

/**
 * Business class Wishlist
 * @author Gaëtan FRANÇOIS
 *
 */
public class Wishlist {

	// Attributes
	private Integer id;
	private String name;
	private Integer quantity;
	
	// Constructors
	public Wishlist(Integer id, String name, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
