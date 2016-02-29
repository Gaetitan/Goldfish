package com.polytech.goldfish.persistence.factoryjdbc;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.factory.Factory;
import com.polytech.goldfish.persistence.jdbc.PersonJDBC;

public class FactoryJDBC extends Factory {

	@Override
	public Person createPersonByLogin(String email, String password) {
		return PersonJDBC.findPersonByLogin(email, password);
	}

}
