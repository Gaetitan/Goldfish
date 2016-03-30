package com.polytech.goldfish.persistence.factoryjdbc;

import com.polytech.goldfish.businesslogic.business.Address;
import com.polytech.goldfish.businesslogic.factory.AddressFactory;
import com.polytech.goldfish.persistence.jdbc.AddressJDBC;

public class AddressFactoryJDBC extends AddressFactory {

	@Override
	public Address findAddressOfAPerson(Integer idPerson) {
		return AddressJDBC.findAddressOfAPerson(idPerson);
	}

}
