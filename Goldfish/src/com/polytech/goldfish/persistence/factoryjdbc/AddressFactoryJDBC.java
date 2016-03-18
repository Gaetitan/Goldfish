package com.polytech.goldfish.persistence.factoryjdbc;

import com.polytech.goldfish.businesslogic.factory.AddressFactory;
import com.polytech.goldfish.persistence.jdbc.AddressJDBC;

public class AddressFactoryJDBC extends AddressFactory {

	@Override
	public int createAddress(String street, Integer street_number,
			Integer zip_code, String city) {
		return AddressJDBC.createAddress(street, street_number, zip_code, city);
	}

}
