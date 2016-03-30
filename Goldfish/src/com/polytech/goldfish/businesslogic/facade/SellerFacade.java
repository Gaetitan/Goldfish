package com.polytech.goldfish.businesslogic.facade;

import com.polytech.goldfish.businesslogic.business.Seller;
import com.polytech.goldfish.businesslogic.manager.SellerManager;

/**
 * Facade for a Seller
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class SellerFacade {
	
	private final SellerManager sellerManager;
	
	public SellerFacade(){
		this.sellerManager = new SellerManager();
	}
	
	public Seller getSellerById(Integer idSeller){
		return this.sellerManager.getSellerById(idSeller);
	}

}