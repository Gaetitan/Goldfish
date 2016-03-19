package com.polytech.goldfish.businesslogic.facade;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.manager.PersonManager;
import com.polytech.goldfish.util.GoldfishException;

/**
 * Facade for a Person
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class PersonFacade {

	private final PersonManager personManager;
	
	public PersonFacade(){
		this.personManager = new PersonManager();
	}
	
	public Person login(String email, String password) throws GoldfishException{
		return this.personManager.login(email, password);
	}
	
	public Integer createPerson(String surname, String name, String phone_number,
			String email, String password, String street, String street_number, String zip_code, String city) throws GoldfishException {
		return this.personManager.createPerson(surname, name, phone_number, email, password, street, street_number, zip_code, city);
	}
	
	public Integer updatePerson(Integer id, String surname, String name, String phone_number,
			String email, String password) {
		return this.personManager.updatePerson(id, surname, name, phone_number, email, password);
	}
	
	public Person findPersonById(Integer id){
		return this.personManager.findPersonById(id);
	}
	
	public Collection<Person> findAllPersons(){
		return this.personManager.findAllPersons();
	}
}
