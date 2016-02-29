package com.polytech.goldfish.businesslogic.manager;

import com.polytech.goldfish.persistence.jdbc.PersonJDBC;


/**
 * This class allows a person to login the application
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class PersonManager {
	
	private final PersonJDBC personPersistence;
	
	public PersonManager(){
		this.personPersistence = new PersonJDBC();
	}
	
	public boolean login(String email, String password){
		return personPersistence.queryLogin(email, password);
	}	
}
