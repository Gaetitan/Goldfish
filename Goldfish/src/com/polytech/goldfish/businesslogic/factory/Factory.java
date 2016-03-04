package com.polytech.goldfish.businesslogic.factory;

import com.polytech.goldfish.businesslogic.business.Person;


/**
 * Factory class
 * This class provides the methods necessary to create the objects used in the application
 * 
 * @author Ga�tan FRAN�OIS
 *
 */
public abstract class Factory {

	/**
	 * This method gets a Person thanks to his login
	 * 
	 * @param email
	 * @param password
	 * @return a Person
	 */
	public abstract Person getPersonByLogin(String email, String password);
	
	/**
	 * This method creates a new Person
	 * 
	 * @param name
	 * @param surname
	 * @param phone_number
	 * @param email
	 * @param password
	 * @return a Person
	 */
	public abstract void createPerson(String surname, String name, String phone_number,String email, String password);
}
