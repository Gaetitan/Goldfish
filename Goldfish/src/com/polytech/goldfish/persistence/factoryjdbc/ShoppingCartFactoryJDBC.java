package com.polytech.goldfish.persistence.factoryjdbc;

import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ShoppingCart;
import com.polytech.goldfish.businesslogic.factory.ShoppingCartFactory;
import com.polytech.goldfish.persistence.jdbc.ShoppingCartJDBC;

/**
 * This class creates the shopping carts used in the application
 * 
 * @author Pierre Laborde
 *
 */
public class ShoppingCartFactoryJDBC extends ShoppingCartFactory {
	
	@Override
	public Integer createShoppingCart() {
		return ShoppingCartJDBC.createShoppingCart();
	}

	@Override
	public ShoppingCart getShoppingCartById(Integer id) {
		return ShoppingCartJDBC.findShoppingCartById(id);
	}
	
	@Override
	public Integer updateShoppingCart(Integer id) {
		return ShoppingCartJDBC.updateShoppingCart(id);
	}
	
	@Override
	public Integer deleteShoppingCart(Integer id) {
		return ShoppingCartJDBC.deleteShoppingCart(id);
	}
	
	@Override
	public Collection<ShoppingCart> getAllShoppingCarts() {
		// Creation of a collection of ShoppingCarts
		Collection<ShoppingCart> listShoppingCarts = new ArrayList<ShoppingCart>();
		
		// Put the ShoppingCartJDBC as ShoppingCart in a new list
		for(ShoppingCart shoppingCart : ShoppingCartJDBC.findAllShoppingCarts()) {
			listShoppingCarts.add(shoppingCart);
		}

		// Return the new list
		return listShoppingCarts;
	}
	
	@Override
	public Float calculatePrice(Integer id) {
		return ShoppingCartJDBC.calculatePrice(id); 
	}

}
