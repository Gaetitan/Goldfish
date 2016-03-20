package com.polytech.goldfish.persistence.factoryjdbc;

import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.factory.PersonFactory;
import com.polytech.goldfish.persistence.jdbc.PersonJDBC;
import com.polytech.goldfish.util.GoldfishException;

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
	public Integer createPerson(Object typePerson, String surname, String name,
			String phone_number, String email, String password, String street, Integer street_number, Integer zip_code, String city,
			String shopname, String description, Integer siret, String activity_domain, String web_address) throws GoldfishException {
		return PersonJDBC.createPerson(typePerson, surname, name, phone_number, email, password, street, street_number, zip_code, city,
				shopname, description, siret, activity_domain, web_address);
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

	@Override
	public boolean isUser(Integer idPerson) {
		return PersonJDBC.isUser(idPerson);
	}

	@Override
	public boolean isAdministrator(Integer idPerson) {
		return PersonJDBC.isAdministrator(idPerson);
	}

}
