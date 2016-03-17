package com.polytech.goldfish.businesslogic.manager;

import com.polytech.goldfish.businesslogic.factory.HaveAddressFactory;
import com.polytech.goldfish.persistence.factoryjdbc.HaveAddressFactoryJDBC;


/**
 * This class manages a link between a Person and an Address
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class HaveAddressManager {
	
	private final HaveAddressFactory factory;

	public HaveAddressManager() {
		this.factory = new HaveAddressFactoryJDBC();
	}
	
	public boolean insertOne(Integer idPerson, Integer idAddress){
		return this.factory.insertOne(idPerson, idAddress);
	}
}
