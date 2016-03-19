package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ProductCategory;
import com.polytech.goldfish.businesslogic.factory.ProductCategoryFactory;
import com.polytech.goldfish.persistence.factoryjdbc.ProductCategoryFactoryJDBC;

public class ProductCategoryManager {

	private final ProductCategoryFactory factory;

	public ProductCategoryManager(){
		this.factory = new ProductCategoryFactoryJDBC();
	}

	public int createProductCategory(String name){
		return this.factory.createProductCategory(name);
	}

	public ProductCategory findProductCategoryById(Integer id){
		return this.factory.getProductCategoryById(id);
	}
	
	public Collection<ProductCategory> findAllProductCategories(){
		return this.factory.getAllProductCategories();
	}
	
	public int updateProductCategory(Integer id, String name){
		
		return this.factory.updateProductCategory(id, name);
	}
	
	public int deleteProductCategory(Integer id){
		
		return this.factory.deleteProductCategory(id);
	}
}
