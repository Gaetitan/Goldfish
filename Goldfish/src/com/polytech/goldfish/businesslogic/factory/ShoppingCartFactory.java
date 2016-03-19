package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ShoppingCart;

/**
 * Factory class
 * This class provides the methods necessary to create the shopping carts used in the application
 * 
 * @author Pierre Laborde
 *
 */
public abstract class ShoppingCartFactory {
	
	/**
	 * This methods gets a ShoppingCart thanks to its id
	 * @param id
	 * @return an ShoppingCart
	 */
	public abstract ShoppingCart getShoppingCartById(Integer id);
	
	/**
	 * This method creates a new ShoppingCart
	 */
	public abstract Integer createShoppingCart();
	
	/**
	 * This method updates a ShoppingCart
	 * @return the ShoppingCart's id
	 */
	public abstract Integer updateShoppingCart(Integer id);
	
	/**
	 * This method deletes a ShoppingCart
	 * @return the ShoppingCart's id
	 */
	public abstract Integer deleteShoppingCart(Integer id);
	
	/**
	 * This methods gets all existing ShoppingCarts
	 * 
	 * @return all existing ShoppingCarts
	 */
	public abstract Collection <ShoppingCart> getAllShoppingCarts();

}
