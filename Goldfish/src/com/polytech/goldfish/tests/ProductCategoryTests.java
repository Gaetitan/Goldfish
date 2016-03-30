package com.polytech.goldfish.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.polytech.goldfish.persistence.jdbc.ProductCategoryJDBC;

public class ProductCategoryTests {
	
	protected ProductCategoryJDBC productCategoryJDBC;
	
	@Before
	public void setUp(){
		productCategoryJDBC = new ProductCategoryJDBC();
	}

	@After
	public void tearDown(){
		
	}
	
	@Test
	public void test() {
		String name = "Shoes";
		
		productCategoryJDBC.setName(name);
		
		assertNotNull(productCategoryJDBC);
		assertEquals(name, productCategoryJDBC.getName());
	}

}
