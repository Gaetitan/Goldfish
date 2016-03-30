package com.polytech.goldfish.businesslogic.manager;

import com.polytech.goldfish.businesslogic.business.Seller;
import com.polytech.goldfish.businesslogic.factory.SellerFactory;
import com.polytech.goldfish.persistence.factoryjdbc.SellerFactoryJDBC;

/**
 * This class manages a Seller
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class SellerManager {

	private final SellerFactory sellerFactory;
	
	public SellerManager(){
		this.sellerFactory = new SellerFactoryJDBC();
	}
	
	public Seller getSellerById(Integer idSeller){
		return this.sellerFactory.getSellerById(idSeller);
	}
}