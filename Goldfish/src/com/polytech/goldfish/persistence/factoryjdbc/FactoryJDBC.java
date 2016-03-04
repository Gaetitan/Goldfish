package com.polytech.goldfish.persistence.factoryjdbc;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.factory.Factory;
import com.polytech.goldfish.persistence.jdbc.PersonJDBC;

/**
 * This class creates the objects used in the application
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class FactoryJDBC extends Factory {

	@Override
	public Person getPersonByLogin(String email, String password) {
		return PersonJDBC.findPersonByLogin(email, password);
	}

	@Override
	public void createPerson(String surname, String name,
			String phone_number, String email, String password) {
		PersonJDBC.createPerson(surname, name, phone_number, email, password);
	}

}
