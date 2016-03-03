package com.polytech.goldfish.persistence.jdbc;

import com.polytech.goldfish.businesslogic.business.Administrator;

/**
 * Persitence class for an Administrator
 * @author Gaëtan FRANÇOIS
 *
 */
public class AdministratorJDBC extends Administrator {

	// Queries
	
	// Constructors
	public AdministratorJDBC(Integer id, String name, String surname,
			String phone_number, String email, String password) {
		super(id, name, surname, phone_number, email, password);
	}
	
	// Other methods

}
