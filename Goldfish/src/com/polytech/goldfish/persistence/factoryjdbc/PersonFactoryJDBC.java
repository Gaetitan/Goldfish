package com.polytech.goldfish.persistence.factoryjdbc;

import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.factory.PersonFactory;
import com.polytech.goldfish.persistence.jdbc.PersonJDBC;

/**
 * This class creates the Persons used in the application
 * 
 * @author Ga�tan FRAN�OIS
 *
 */
public class PersonFactoryJDBC extends PersonFactory {

	@Override
	public Person getPersonByLogin(String email, String password) {
		return PersonJDBC.findPersonByLogin(email, password);
	}

	@Override
	public Integer createPerson(String surname, String name,
			String phone_number, String email, String password) {
		return PersonJDBC.createPerson(surname, name, phone_number, email, password);
	}

	@Override
	public Person getPersonById(Integer id) {
		return PersonJDBC.findPersonById(id);
	}

	@Override
	public Collection<Person> getAllPersons() {
		// Creation of a collection of Person
		Collection<Person> listPersons = new ArrayList<Person>();
		
		// Put the PersonJDBC as Person in a new list
		for(Person person : PersonJDBC.findAllPersons()) {
			listPersons.add(person);
		}

		// Return the new list
		return listPersons;
	}

	@Override
	public Integer updatePerson(Integer id, String surname, String name, String phone_number,
			String email, String password) {
		return PersonJDBC.updatePerson(id, surname, name, phone_number, email, password);
	}

}