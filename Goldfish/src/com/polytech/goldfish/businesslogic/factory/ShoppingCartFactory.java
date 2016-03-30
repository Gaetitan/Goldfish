package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Product;
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
	public abstract Integer createShoppingCart(Integer id);
	
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
	
	/**
	 * This method adds a product in a ShoppingCart
	 * @return the ShoppingCart's id
	 */
	public abstract Integer addProductShoppingCart(Integer idshoppingcart, Integer idproduct, Integer quantity);
	
	/**
	 * This method modifies the quantity of a product in a ShoppingCart
	 * @return the ShoppingCart's id
	 */
	public abstract Integer modifyQuantityProductShoppingCart(Integer idshoppingcart, Integer idproduct, Integer quantity);
	
	/**
	 * This method deletes a product from a ShoppingCart
	 * @return the ShoppingCart's id
	 */
	public abstract Integer deleteProductShoppingCart(Integer idshoppingcart, Integer idproduct);	
	
	/**
	 * This method empties a ShoppingCart
	 * @return the ShoppingCart's id
	 */
	public abstract Integer emptyShoppingCart(Integer idshoppingcart);	
	
	/**
	 * This method gets all products of a ShoppingCart
	 * @return the ShoppingCart's id
	 */
	public abstract Collection <Product> findAllProductsOfAShoppingCart(Integer idshoppingcart);	
}
