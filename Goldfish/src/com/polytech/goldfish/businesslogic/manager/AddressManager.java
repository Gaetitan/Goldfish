package com.polytech.goldfish.businesslogic.manager;

import com.polytech.goldfish.businesslogic.business.Address;
import com.polytech.goldfish.businesslogic.factory.AddressFactory;
import com.polytech.goldfish.persistence.factoryjdbc.AddressFactoryJDBC;

public class AddressManager {

	private final AddressFactory addressFactory;
	
	public AddressManager(){
		this.addressFactory = new AddressFactoryJDBC();
	}
	
	public Address findAddressOfAPerson(Integer idPerson) {
		return this.addressFactory.findAddressOfAPerson(idPerson);
	}
}
