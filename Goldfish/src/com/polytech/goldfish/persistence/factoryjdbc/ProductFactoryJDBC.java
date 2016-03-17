package com.polytech.goldfish.persistence.factoryjdbc;

import com.polytech.goldfish.businesslogic.business.Product;
import com.polytech.goldfish.businesslogic.factory.ProductFactory;
import com.polytech.goldfish.persistence.jdbc.ProductJDBC;

public class ProductFactoryJDBC extends ProductFactory{
	
	@Override
	public int createProduct(String name, String description) {
		return ProductJDBC.createProduct(name, description);
	}

	@Override
	public Product getProductById(Integer id) {
		return ProductJDBC.findProductById(id);
	}

	
}
