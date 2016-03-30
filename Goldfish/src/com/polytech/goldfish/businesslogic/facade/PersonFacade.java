package com.polytech.goldfish.businesslogic.facade;

import java.util.Collection;

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
	
	public Integer createPerson(Object typePerson, String surname, String name, String phone_number,
			String email, String password, String street, String street_number, String zip_code, String city,
			String shopname, String description, String siret, String activitydomain, String webaddress) throws GoldfishException {
		return this.personManager.createPerson(typePerson, surname, name, phone_number, email, password, street, street_number, zip_code, city,
				shopname, description, siret, activitydomain, webaddress);
	}
	
	public Integer updatePerson(Integer id, String surname, String name, String phone_number,
			String email, String password,String street, String street_number, String zip_code, String city,
			String shopname, String description, String siret, String activitydomain, String webaddress) throws GoldfishException {
		return this.personManager.updatePerson(id, surname, name, phone_number, email, password, street, street_number, zip_code, city,
				shopname, description, siret, activitydomain, webaddress);
	}
	
	public Person findPersonById(Integer id){
		return this.personManager.findPersonById(id);
	}
	
	public Collection<Person> findAllPersons(){
		return this.personManager.findAllPersons();
	}
	
	public boolean isUser(Integer idPerson) {
		return this.personManager.isUser(idPerson);
	}

	public boolean isAdministrator(Integer idPerson) {
		return this.personManager.isAdministrator(idPerson);
	}
	
	public boolean isSeller(Integer idPerson) {
		return this.personManager.isSeller(idPerson);
	}
	
	public Person findPersonByEmail(String email){
		return this.personManager.findPersonByEmail(email);
	}
	
	public boolean verifyPasswordById(Integer idPerson, String password) throws GoldfishException{
		return this.personManager.verifyPasswordById(idPerson, password);
	}
	
	public boolean deletePerson(Integer idPerson){
		return this.personManager.deletePerson(idPerson);
	}
}
