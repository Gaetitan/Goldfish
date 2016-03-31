package com.polytech.goldfish.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.polytech.goldfish.persistence.jdbc.WishlistJDBC;

public class WishlistTests {

	protected WishlistJDBC wishlistJDBC;

	@Before
	public void setUp(){
		wishlistJDBC = new WishlistJDBC(10000, "AName", 25);
	}

	@After
	public void tearDown(){

	}

	@Test
	public void test() {
		String name = "ANewName";
		Integer newQuantity = 50;

		wishlistJDBC.setName(name);
		wishlistJDBC.setQuantity(newQuantity);

		assertNotNull(wishlistJDBC);

		assertEquals(name, wishlistJDBC.getName());
		assertEquals(newQuantity, wishlistJDBC.getQuantity());
	}
}