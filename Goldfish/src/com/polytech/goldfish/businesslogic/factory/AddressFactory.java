package com.polytech.goldfish.businesslogic.factory;

import com.polytech.goldfish.businesslogic.business.Address;


public abstract class AddressFactory {
	/**
	 * This method gets an Address thanks to an id of a Person
	 * 
	 * @param idPerson
	 * @return an Address
	 */
	public abstract Address findAddressOfAPerson(Integer idPerson);
}
