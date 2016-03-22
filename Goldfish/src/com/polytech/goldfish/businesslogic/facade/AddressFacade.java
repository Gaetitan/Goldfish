package com.polytech.goldfish.businesslogic.facade;

import com.polytech.goldfish.businesslogic.business.Address;
import com.polytech.goldfish.businesslogic.manager.AddressManager;

public class AddressFacade {
	
	private AddressManager addressManager = new AddressManager();
	
	public AddressFacade(){
		this.addressManager = new AddressManager();
	}
	
	public Address findAddressOfAPerson(Integer idPerson) {
		return this.addressManager.findAddressOfAPerson(idPerson);
	}

}
