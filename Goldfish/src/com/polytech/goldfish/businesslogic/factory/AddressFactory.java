package com.polytech.goldfish.businesslogic.factory;

/**
 * Factory class
 * This class provides the methods necessary to create the Addresses used in the application
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public abstract class AddressFactory {

	/**
	 * This method creates a new Address
	 * 
	 * @param street
	 * @param street_number
	 * @param zip_code
	 * @param city
	 * @return the Address' id
	 */
	public abstract int createAddress(String street, Integer street_number, Integer zip_code, String city);
}
