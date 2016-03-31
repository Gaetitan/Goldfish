package com.polytech.goldfish.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.polytech.goldfish.persistence.jdbc.ProductJDBC;

public class ProductTests {
	
	protected ProductJDBC productJDBC;
	
	@Before
	public void setUp(){
		productJDBC = new ProductJDBC();
	}

	@After
	public void tearDown(){
		
	}
	
	@Test
	public void test() {
		String name = "chaussure";
		String description = "chaussures pour faire du sport";
		
		productJDBC.setName(name);
		productJDBC.setDescription(description);
		
		assertNotNull(productJDBC);
		assertEquals(name, productJDBC.getName());
		assertEquals(description, productJDBC.getDescription());
	}

}
