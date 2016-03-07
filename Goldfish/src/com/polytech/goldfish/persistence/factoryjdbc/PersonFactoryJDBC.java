package com.polytech.goldfish.persistence.factoryjdbc;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.factory.PersonFactory;
import com.polytech.goldfish.persistence.jdbc.PersonJDBC;

/**
 * This class creates the Persons used in the application
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class PersonFactoryJDBC extends PersonFactory {

	@Override
	public Person getPersonByLogin(String email, String password) {
		return PersonJDBC.findPersonByLogin(email, password);
	}

	@Override
	public int createPerson(String surname, String name,
			String phone_number, String email, String password) {
		return PersonJDBC.createPerson(surname, name, phone_number, email, password);
	}

	@Override
	public Person getPersonById(Integer id) {
		return PersonJDBC.findPersonById(id);
	}

}
