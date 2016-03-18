package com.polytech.goldfish.businesslogic.manager;

import com.polytech.goldfish.businesslogic.factory.AddressFactory;
import com.polytech.goldfish.persistence.factoryjdbc.AddressFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;

/**
 * This class manages an Address
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class AddressManager {

	private final AddressFactory addressFactory;
	
	public AddressManager() {
		this.addressFactory = new AddressFactoryJDBC();
	}
	
	public int createAddress(String street, String street_number, String zip_code, String city) throws GoldfishException {
		if(street.isEmpty() || street_number.isEmpty()|| zip_code.isEmpty() || city.isEmpty()){
			throw new GoldfishException("Please fill all the fields.");
		}
		else{
			return this.addressFactory.createAddress(street, Integer.parseInt(street_number), Integer.parseInt(zip_code), city);
		}
		
	}
	
}
