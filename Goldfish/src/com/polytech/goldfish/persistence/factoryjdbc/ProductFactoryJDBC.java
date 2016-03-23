package com.polytech.goldfish.persistence.factoryjdbc;

import java.util.ArrayList;
import java.util.Collection;

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
	
	@Override
	public Collection<Product> getAllProducts() {
		// Creation of a collection of Person
		Collection<ProductJDBC> listProductsJDBC = ProductJDBC.findAllProducts();
		Collection<Product> listProducts = new ArrayList<Product>();
		
		// Put the PersonJDBC as Person in a new list
		for(Product product : listProductsJDBC ) {
			listProducts.add(product);
		}

		// Return the new list
		return listProducts;
	}

	@Override
	public int updateProduct(Integer id,String name, String description){
		return ProductJDBC.updateProduct(id, name, description);
	}
	
	@Override
	public int deleteProduct(Integer id){
		return ProductJDBC.deleteProduct(id);
	}
}
