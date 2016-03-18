package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.factory.PersonFactory;
import com.polytech.goldfish.persistence.factoryjdbc.PersonFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;


/**
 * This class manages a Person
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
	
	public Integer createPerson(String surname, String name, String phone_number,
			String email, String password) throws GoldfishException {
		if(surname.isEmpty() || name.isEmpty() || phone_number.isEmpty() || email.isEmpty() || password.isEmpty()) {
			throw new GoldfishException("Please fill all the fields.");
		}
		else {
			return this.factory.createPerson(surname, name, phone_number, email, password);
		}
		
	}
	
	public Integer updatePerson(Integer id, String surname, String name, String phone_number,
			String email, String password) throws GoldfishException {
		if(surname.isEmpty() || name.isEmpty() || phone_number.isEmpty() || email.isEmpty() || password.isEmpty()) {
			throw new GoldfishException("Please fill all the fields.");
		}
		else {
			return this.factory.updatePerson(id, surname, name, phone_number, email, password);
		}
	}
	
	public Person findPersonById(Integer id){
		return this.factory.getPersonById(id);
	}
	
	public Collection<Person> findAllPersons(){
		return this.factory.getAllPersons();
	}
}
