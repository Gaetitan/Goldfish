package com.polytech.goldfish.businesslogic.factory;

import com.polytech.goldfish.businesslogic.business.Seller;

public abstract class SellerFactory {

	/**
	 * This methods gets a Seller thanks to its id
	 * @param idSeller the Seller's id
	 * @return a Seller
	 */
	public abstract Seller getSellerById(Integer idSeller);
}