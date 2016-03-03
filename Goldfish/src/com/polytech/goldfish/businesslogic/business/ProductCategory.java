package com.polytech.goldfish.businesslogic.business;

/**
 * Business class ProductCategory
 * @author Gaëtan FRANÇOIS
 *
 */
public class ProductCategory {

	// Attributes
	private Integer id;
	private String name;
	
	// Constructors
	public ProductCategory(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
}
