package com.polytech.goldfish.businesslogic.manager;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.factory.Factory;
import com.polytech.goldfish.persistence.factoryjdbc.FactoryJDBC;


/**
 * This class allows a person to login the application
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class PersonManager {
	
	private final Factory factory;
	
	public PersonManager(){
		this.factory = new FactoryJDBC();
	}
	
	public Person login(String email, String password){
		return this.factory.createPersonByLogin(email, password);
	}	
}
