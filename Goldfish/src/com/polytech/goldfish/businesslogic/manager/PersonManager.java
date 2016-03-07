package com.polytech.goldfish.businesslogic.manager;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.factory.PersonFactory;
import com.polytech.goldfish.persistence.factoryjdbc.PersonFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;


/**
 * This class allows a person to login the application
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class PersonManager {
	
	private final PersonFactory factory;
	
	public PersonManager(){
		this.factory = new PersonFactoryJDBC();
	}
	
	public Person login(String email, String password) throws GoldfishException {
		if (this.factory.getPersonByLogin(email, password) == null) {
			throw new GoldfishException("The written email/password is invalid.");
		}
		else{
			return this.factory.getPersonByLogin(email, password);
		}
	}
	
	public int createPerson(String surname, String name, String phone_number,
			String email, String password){
		return this.factory.createPerson(surname, name, phone_number, email, password);
	}
	
	public Person findPersonById(Integer id){
		return this.factory.getPersonById(id);
	}
}
