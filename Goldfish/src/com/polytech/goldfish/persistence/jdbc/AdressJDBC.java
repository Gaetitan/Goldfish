package com.polytech.goldfish.persistence.jdbc;

import com.polytech.goldfish.businesslogic.business.Adress;

/**
 * Persistence class for an Adress
 * @author Gaëtan FRANÇOIS
 *
 */
public class AdressJDBC extends Adress{

	// Queries
	
	
	// Constructors
	public AdressJDBC(Integer id, String street, String street_number, String zip_code,
			String city) {
		super(id, street, street_number, zip_code, city);
	}
	
	// Other methods
	
}
