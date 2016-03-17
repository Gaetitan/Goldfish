package com.polytech.goldfish.persistence.factoryjdbc;

import com.polytech.goldfish.businesslogic.factory.HaveAddressFactory;
import com.polytech.goldfish.persistence.jdbc.HaveAddressJDBC;

public class HaveAddressFactoryJDBC extends HaveAddressFactory {

	@Override
	public boolean insertOne(Integer idPerson, Integer idAddress) {
		return HaveAddressJDBC.insertOne(idPerson, idAddress);
	}

}
