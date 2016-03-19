package com.polytech.goldfish.businesslogic.facade;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ShoppingCart;
import com.polytech.goldfish.businesslogic.manager.ShoppingCartManager;
import com.polytech.goldfish.util.GoldfishException;

/**
 * Facade for a ShoppingCart
 * 
 * @author Pierre Laborde
 *
 */
public class ShoppingCartFacade {
	
	private final ShoppingCartManager shoppingCartManager;
	
	public ShoppingCartFacade(){
		this.shoppingCartManager = new ShoppingCartManager();
	}
	
	public Integer createShoppingCart() throws GoldfishException {
		return this.shoppingCartManager.createShoppingCart();
	}
	
	public Integer updateShoppingCart(Integer id) throws GoldfishException {
		return this.shoppingCartManager.updateShoppingCart(id);
	}
	
	public Integer deleteShoppingCart(Integer id) throws GoldfishException {
		return this.shoppingCartManager.deleteShoppingCart(id);
	}
	
	public ShoppingCart findShoppingCartById(Integer id){
		return this.shoppingCartManager.findShoppingCartById(id);
	}
	
	public Collection<ShoppingCart> findAllShoppingCarts(){
		return this.shoppingCartManager.findAllShoppingCarts();
	}

}
