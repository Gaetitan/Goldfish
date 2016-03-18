package com.polytech.goldfish.businesslogic.facade;

import com.polytech.goldfish.businesslogic.manager.AddressManager;
import com.polytech.goldfish.util.GoldfishException;

/**
 * Facade for an Address
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class AddressFacade {

	// Attributes
	private final AddressManager addressManager;
	
	// Constructors
	public AddressFacade() {
		this.addressManager = new AddressManager();
	}
	
	// Other methods
	public int createAddress(String street, String street_number, String zip_code, String city) throws GoldfishException {
		return this.addressManager.createAddress(street, street_number, zip_code, city);
	}
	
}
