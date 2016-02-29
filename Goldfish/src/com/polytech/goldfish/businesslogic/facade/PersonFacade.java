package com.polytech.goldfish.businesslogic.facade;

import com.polytech.goldfish.businesslogic.manager.PersonManager;

public class PersonFacade {

	private final PersonManager personManager;
	
	public PersonFacade(){
		this.personManager = new PersonManager();
	}
	
	public boolean login(String email, String password){
		return personManager.login(email, password);
	}
}
