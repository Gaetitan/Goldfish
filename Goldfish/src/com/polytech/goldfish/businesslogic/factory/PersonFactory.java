package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Person;


/**
 * Factory class
 * This class provides the methods necessary to create the Persons used in the application
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public abstract class PersonFactory {

	/**
	 * This method gets a Person thanks to his login
	 * 
	 * @param email
	 * @param password
	 * @return a Person
	 */
	public abstract Person getPersonByLogin(String email, String password);
	
	/**
	 * This methods gets a Person thanks to its id
	 * @param id
	 * @return a Person
	 */
	public abstract Person getPersonById(Integer id);
	
	/**
	 * This method creates a new Person
	 * 
	 * @param name
	 * @param surname
	 * @param phone_number
	 * @param email
	 * @param password
	 * @return the Person's id
	 */
	public abstract int createPerson(String surname, String name, String phone_number, String email, String password);

	
	/**
	 * This method updates a Person
	 * 
	 * @param surname
	 * @param name
	 * @param phone_number
	 * @param email
	 * @param password
	 * @return the Person's id
	 */
	public abstract int updatePerson(Integer id, String surname, String name, String phone_number, String email, String password);

	/**
	 * This methods gets all existing Persons
	 * 
	 * @return all existing Persons
	 */
	public abstract Collection <Person> getAllPersons();

}
