package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ProductCategory;

public abstract class ProductCategoryFactory {

	public abstract ProductCategory getProductCategoryById(Integer id);
	
	public abstract int createProductCategory(String name);
	
	public abstract Collection <ProductCategory> getAllProductCategories();
	
	public abstract int updateProductCategory(Integer id, String name);
	
	public abstract int deleteProductCategory(Integer id);
}
