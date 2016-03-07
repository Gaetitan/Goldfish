package com.polytech.goldfish.businesslogic.facade;

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
	
	public int createPerson(String surname, String name, String phone_number,
			String email, String password){
		return this.personManager.createPerson(surname, name, phone_number, email, password);
	}
	
	public Person findPersonById(Integer id){
		return this.personManager.findPersonById(id);
	}
}
