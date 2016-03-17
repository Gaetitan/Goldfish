package com.polytech.goldfish.businesslogic.factory;

/**
 * Factory class
 * This class provides the methods necessary to create the HaveAddress used in the application
 * @author Gaëtan FRANÇOIS
 *
 */
public abstract class HaveAddressFactory {
	
	/**
	 * This method inserts a HaveAddress
	 * @param idPerson
	 * @param idAddress
	 * @return 
	 */
	public abstract boolean insertOne(Integer idPerson, Integer idAddress);

}
