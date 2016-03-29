package com.polytech.goldfish.persistence.factoryjdbc;

import com.polytech.goldfish.businesslogic.business.Seller;
import com.polytech.goldfish.businesslogic.factory.SellerFactory;
import com.polytech.goldfish.persistence.jdbc.SellerJDBC;

public class SellerFactoryJDBC extends SellerFactory {

	@Override
	public Seller getSellerById(Integer idSeller) {
		return SellerJDBC.findPersonById(idSeller);
	}

}
