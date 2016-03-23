package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.util.GoldfishException;


/**
 * Factory class
 * This class provides the methods necessary to create the Persons used in the application
 * 
 * @author Ga�tan FRAN�OIS
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
	 * @throws GoldfishException
	 */
	public abstract Integer createPerson(Object typePerson, String surname, String name, String phone_number, String email, String password, String street, Integer street_number, Integer zip_code, String city) throws GoldfishException;

	

	/**
	 * This method updates a Person
	 * @param id
	 * @param surname
	 * @param name
	 * @param phone_number
	 * @param email
	 * @param street
	 * @param street_number
	 * @param zip_code
	 * @param city
	 * @return the updated Person
	 */
	public abstract Integer updatePerson(Integer id, String surname, String name, String phone_number, String email, String street, Integer street_number, Integer zip_code, String city);

	/**
	 * This methods gets all existing Persons
	 * 
	 * @return all existing Persons
	 */
	public abstract Collection <Person> getAllPersons();

	
	/**
	 * This method determines if a Person is a user
	 * @return true if the Person is a User, false otherwise
	 */
	public abstract boolean isUser(Integer idPerson);
	
	/**
	 * This method determines if a Person is an Administrator
	 * @return true if the Person is an Administrator, false otherwise
	 */
	public abstract boolean isAdministrator(Integer idPerson);
}
