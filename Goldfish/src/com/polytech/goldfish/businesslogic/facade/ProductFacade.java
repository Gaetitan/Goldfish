package com.polytech.goldfish.businesslogic.facade;

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

}
