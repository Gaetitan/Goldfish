package com.polytech.goldfish.businesslogic.facade;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Product;
import com.polytech.goldfish.businesslogic.manager.ProductManager;
import com.polytech.goldfish.util.GoldfishException;

public class ProductFacade {

	private final ProductManager productManager;

	public ProductFacade(){
		this.productManager = new ProductManager();
	}

	public int createProduct(String name, String description){
		return this.productManager.createProduct(name, description);
	}

	public Product findProductById(Integer id){
		return this.productManager.findProductById(id);
	}
	
	public Collection<Product> findAllProducts(){
		return this.productManager.findAllProducts();
	}
	
	public int updateProduct(Integer id, String name, String description) throws GoldfishException{
		return this.productManager.updateProduct(id,name,description);
	}
	
	public int deleteProduct(Integer id)throws GoldfishException{
		return this.productManager.deleteProduct(id);
	}

}
