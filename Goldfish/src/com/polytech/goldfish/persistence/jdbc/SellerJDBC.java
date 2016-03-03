package com.polytech.goldfish.persistence.jdbc;

import com.polytech.goldfish.businesslogic.business.Seller;

/**
 * Persistence class for a Seller
 * @author Gaëtan FRANÇOIS
 *
 */
public class SellerJDBC extends Seller {

	// Queries
	
	
	// Constructors
	public SellerJDBC(Integer id, String name, String surname,
			String phone_number, String email, String password,
			String shop_name, String description, String siret,
			String activity_domain, String web_adress) {
		super(id, name, surname, phone_number, email, password, shop_name, description,
				siret, activity_domain, web_adress);
	}
	
	// Other methods

}
