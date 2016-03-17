package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Product;

public abstract class ProductFactory {

	public abstract Product getProductById(Integer id);
	
	public abstract int createProduct(String name,String description);
	
	public abstract Collection <Product> getAllProducts();
	
	public abstract int updateProduct(Integer id, String name, String description);
	
	public abstract int deleteProduct(Integer id);
}
