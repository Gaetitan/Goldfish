package com.polytech.goldfish.persistence.jdbc;

import com.polytech.goldfish.businesslogic.business.User;

/**
 * Persistence class for a User
 * @author Gaëtan FRANÇOIS
 *
 */
public class UserJDBC extends User {

	// Queries
	
	// Constructors
	public UserJDBC(Integer id, String name, String surname,
			String phone_number, String email, String password) {
		super(id, name, surname, phone_number, email, password);
	}
	
	// Other methods

}
