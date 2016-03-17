package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Product;
import com.polytech.goldfish.businesslogic.factory.ProductFactory;
import com.polytech.goldfish.persistence.factoryjdbc.ProductFactoryJDBC;

public class ProductManager {

	private final ProductFactory factory;

	public ProductManager(){
		this.factory = new ProductFactoryJDBC();
	}

	public int createProduct(String name, String description){
		return this.factory.createProduct(name, description);
	}

	public Product findProductById(Integer id){
		return this.factory.getProductById(id);
	}
	
	public Collection<Product> findAllProducts(){
		return this.factory.getAllProducts();
	}
	
	public int updateProduct(Integer id, String name, String description){
		
		return this.factory.updateProduct(id, name, description);
	}
}
