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
	 * @param email the Person's email
	 * @param password the Person's password
	 * @return a Person
	 */
	public abstract Person getPersonByLogin(String email, String password);
	
	/**
	 * This method gets a Person thanks to its id
	 * @param id the Person's id
	 * @return a Person
	 */
	public abstract Person getPersonById(Integer id);
	
	/**
	 * This method gets a Person thanks to its email address
	 * @param email the Person's email
	 * @return a Person
	 */
	public abstract Person getPersonByEmail(String email);
	/**
	 * This method creates a new Person
	 * 
	 * @param typePerson the Person's type
	 * @param surname the Person's surname
	 * @param name the Person's name
	 * @param phone_number the Person's phone number
	 * @param email the Person's email
	 * @param password the Person's password
	 * @param street the Person's address' street
	 * @param street_number the Person's address' street number
	 * @param zip_code the Person's address' zip code
	 * @param city the Person's address' city
	 * @param shopname the Person's shopname
	 * @param description the Person's description
	 * @param siret the Person's SIRET
	 * @param activitydomain the Person's activitydomain
	 * @param webaddress the Person's webaddress
	 * @return the Person's id
	 * @throws GoldfishException
	 */
	public abstract Integer createPerson(Object typePerson, String surname, String name, String phone_number, String email, String password, String street, Integer street_number, Integer zip_code, String city,
			String shopname, String description, Integer siret, String activitydomain, String webaddress) throws GoldfishException;

	

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
	public abstract Integer updatePerson(Integer id, String surname, String name, String phone_number, String email, String street, Integer street_number, Integer zip_code, String city, String shopname, String description, Integer siret, String activitydomain, String webaddress);

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
	
	/**
	 * This method determines if a Person is a Seller
	 * @return true if the Person is a Seller, false otherwise
	 */
	public abstract boolean isSeller(Integer idPerson);
	
	/**
	 * This method checks a Person's password
	 * @param idPerson
	 * @param password
	 * @return true if the couple id/password is good, false otherwise
	 */
	public abstract boolean verifyPasswordById(Integer idPerson, String password);
	
	/**
	 * This method deletes a Person
	 * @param idPerson the Person's id
	 * @return 
	 */
	public abstract boolean deletePerson(Integer idPerson);
}
