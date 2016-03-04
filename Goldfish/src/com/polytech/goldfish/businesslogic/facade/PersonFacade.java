package com.polytech.goldfish.businesslogic.facade;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.manager.PersonManager;

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
	
	public Person login(String email, String password){
		return this.personManager.login(email, password);
	}
	
	public void createPerson(String surname, String name, String phone_number,
			String email, String password){
		this.personManager.createPerson(surname, name, phone_number, email, password);
	}
}
