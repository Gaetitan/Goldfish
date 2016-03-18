package com.polytech.goldfish.businesslogic.facade;

import com.polytech.goldfish.businesslogic.manager.HaveAddressManager;

/**
 * Facade for the link between a Person and an Address
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class HaveAddressFacade {

	private final HaveAddressManager haveAddressManager;
	
	public HaveAddressFacade(){
		this.haveAddressManager = new HaveAddressManager();
	}
	
	public boolean insertOne(Integer idPerson, Integer idAddress){
		return this.haveAddressManager.insertOne(idPerson, idAddress);
	}
}
