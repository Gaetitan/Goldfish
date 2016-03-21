package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ShoppingCart;
import com.polytech.goldfish.businesslogic.factory.ShoppingCartFactory;
import com.polytech.goldfish.persistence.factoryjdbc.ShoppingCartFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;

/**
 * This class allows the system to create a new shoppingCart
 * 
 * @author Pierre Laborde
 *
 */
public class ShoppingCartManager {
	
	private final ShoppingCartFactory factory;
	
	public ShoppingCartManager(){
		this.factory = new ShoppingCartFactoryJDBC();
	}
	
	public Integer createShoppingCart() throws GoldfishException {
		return this.factory.createShoppingCart();		
	}
	
	public Integer updateShoppingCart(Integer id) throws GoldfishException {
		return this.factory.updateShoppingCart(id);
	}
	
	public Integer deleteShoppingCart(Integer id) throws GoldfishException {
		return this.factory.deleteShoppingCart(id);
	}
	
	public ShoppingCart findShoppingCartById(Integer id){
		return this.factory.getShoppingCartById(id);
	}
	
	public Collection<ShoppingCart> findAllShoppingCarts(){
		return this.factory.getAllShoppingCarts();
	}
	
	public Float calculatePrice(Integer id) throws GoldfishException {
		return this.factory.calculatePrice(id);
	}

}
