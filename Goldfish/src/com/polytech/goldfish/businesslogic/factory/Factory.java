package com.polytech.goldfish.businesslogic.factory;

import com.polytech.goldfish.businesslogic.business.Person;


public abstract class Factory {

	public abstract Person createPersonByLogin(String email, String password);
	
}
