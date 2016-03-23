package com.polytech.goldfish.persistence.factoryjdbc;

import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ProductCategory;
import com.polytech.goldfish.businesslogic.factory.ProductCategoryFactory;
import com.polytech.goldfish.persistence.jdbc.ProductCategoryJDBC;

public class ProductCategoryFactoryJDBC extends ProductCategoryFactory{
	
	@Override
	public int createProductCategory(String name) {
		return ProductCategoryJDBC.createProductCategory(name);
	}

	@Override
	public ProductCategory getProductCategoryById(Integer id) {
		return ProductCategoryJDBC.findProductCategoryById(id);
	}
	
	@Override
	public Collection<ProductCategory> getAllProductCategories() {
		Collection<ProductCategoryJDBC> listProductCategoriesJDBC = ProductCategoryJDBC.findAllProductCategories();
		Collection<ProductCategory> listProductCategories = new ArrayList<ProductCategory>();
		
		for(ProductCategory ProductCategory : listProductCategoriesJDBC ) {
			listProductCategories.add(ProductCategory);
		}

		return listProductCategories;
	}

	@Override
	public int updateProductCategory(Integer id,String name){
		return ProductCategoryJDBC.updateProductCategory(id, name);
	}
	
	@Override
	public int deleteProductCategory(Integer id){
		return ProductCategoryJDBC.deleteProductCategory(id);
	}
}
