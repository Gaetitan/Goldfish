package com.polytech.goldfish.businesslogic.factory;

import com.polytech.goldfish.businesslogic.business.Person;


/**
 * Factory class
 * This class provides the methods necessary to create the objects used in the application
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public abstract class Factory {

	/**
	 * This method creates a Person thanks to his login
	 * 
	 * @param email
	 * @param password
	 * @return a Person
	 */
	public abstract Person createPersonByLogin(String email, String password);
	
}
