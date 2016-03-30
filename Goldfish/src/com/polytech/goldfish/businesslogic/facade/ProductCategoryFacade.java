package com.polytech.goldfish.businesslogic.facade;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ProductCategory;
import com.polytech.goldfish.businesslogic.manager.ProductCategoryManager;
import com.polytech.goldfish.util.GoldfishException;

public class ProductCategoryFacade {

	private final ProductCategoryManager ProductCategoryManager;

	public ProductCategoryFacade(){
		this.ProductCategoryManager = new ProductCategoryManager();
	}

	public int createProductCategory(String name){
		return this.ProductCategoryManager.createProductCategory(name);
	}

	public ProductCategory findProductCategoryById(Integer id){
		return this.ProductCategoryManager.findProductCategoryById(id);
	}
	
	public Collection<ProductCategory> findAllProductCategories(){
		return this.ProductCategoryManager.findAllProductCategories();
	}
	
	public int updateProductCategory(Integer id, String name)throws GoldfishException{
		return this.ProductCategoryManager.updateProductCategory(id,name);
	}
	
	public int deleteProductCategory(Integer id)throws GoldfishException{
		return this.ProductCategoryManager.deleteProductCategory(id);
	}

}
