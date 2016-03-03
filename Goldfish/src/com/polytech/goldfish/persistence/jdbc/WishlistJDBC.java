package com.polytech.goldfish.persistence.jdbc;

import com.polytech.goldfish.businesslogic.business.Wishlist;

/**
 * Persistence class for a Wishlist
 * @author Gaëtan FRANÇOIS
 *
 */
public class WishlistJDBC extends Wishlist{

	// Queries
	
	
	// Constructors
	public WishlistJDBC(Integer id, String name, Integer quantity) {
		super(id, name, quantity);
	}

	// Other methods
}
