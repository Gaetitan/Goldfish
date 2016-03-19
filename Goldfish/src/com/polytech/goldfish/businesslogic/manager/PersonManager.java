package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.factory.PersonFactory;
import com.polytech.goldfish.persistence.factoryjdbc.PersonFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;


/**
 * This class manages a Person
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class PersonManager {
	
	private final PersonFactory factory;
	
	boolean checkTel(String tel){
		Pattern p = Pattern.compile("\\d{10}");
		Matcher m = p.matcher(tel);
		return m.matches();
	}

	boolean checkEmail(String email){
		Pattern p = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[\\p{Alpha}]{2,6}$");
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	boolean checkZipCode(String zipCode){
		Pattern p = Pattern.compile("\\d{5}");
		Matcher m = p.matcher(zipCode);
		return m.matches();
	}
	
	boolean checkNumber(String number){
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(number);
		return m.matches();
	}
	
	public PersonManager(){
		this.factory = new PersonFactoryJDBC();
	}
	
	public Person login(String email, String password) throws GoldfishException {
		if (this.factory.getPersonByLogin(email, password) == null) {
			throw new GoldfishException("The written email/password is invalid.");
		}
		else{
			return this.factory.getPersonByLogin(email, password);
		}
	}
	
	public Integer createPerson(String surname, String name, String phone_number,
			String email, String password, String street, String street_number, String zip_code, String city) throws GoldfishException{
		if(!checkEmail(email)) {
			throw new GoldfishException("Please enter a valid email.");
		}
		else if(!checkTel(phone_number)){
			throw new GoldfishException("Please enter a valid phone number.");
		}
		else if(!checkNumber(street_number)){
			throw new GoldfishException("Please enter a valid street number.");
		}
		else if(!checkZipCode(zip_code)){
			throw new GoldfishException("Please enter a valid zip code.");
		}
		else {
			return this.factory.createPerson(surname, name, phone_number, email, password, street, Integer.parseInt(street_number), Integer.parseInt(zip_code), city);
		}
		
	}
	
	public Integer updatePerson(Integer id, String surname, String name, String phone_number,
			String email, String password) {
		return this.factory.updatePerson(id, surname, name, phone_number, email, password);
	}
	
	public Person findPersonById(Integer id){
		return this.factory.getPersonById(id);
	}
	
	public Collection<Person> findAllPersons(){
		return this.factory.getAllPersons();
	}
}
