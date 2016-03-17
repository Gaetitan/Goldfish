package com.polytech.goldfish.businesslogic.factory;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.businesslogic.business.Product;

public abstract class ProductFactory {

	public abstract Product getProductById(Integer id);
	
	public abstract int createProduct(String name,String description);
}
