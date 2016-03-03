package com.polytech.goldfish.businesslogic.facade;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.manager.PersonManager;

/**
 * Facade for a Person
 * 
 * @author Ga�tan FRAN�OIS
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
}
