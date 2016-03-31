package com.polytech.goldfish.businesslogic.facade;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Product;
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
	
	public Integer createShoppingCart(Integer id) throws GoldfishException {
		return this.shoppingCartManager.createShoppingCart(id);
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
	
	public ShoppingCart findShoppingCartOfAnUser(Integer id){
		return this.shoppingCartManager.findShoppingCartOfAnUser(id);
	}
	
	public Collection<ShoppingCart> findAllShoppingCarts(){
		return this.shoppingCartManager.findAllShoppingCarts();
	}
	
	public Integer addProductShoppingCart(Integer idshoppingcart, Integer idproduct, Integer quantity) throws GoldfishException{
		return this.shoppingCartManager.addProductShoppingCart(idshoppingcart, idproduct, quantity);
	}
	
	public Integer modifyQuantityProductShoppingCart(Integer idshoppingcart, Integer idproduct, Integer quantity){
		return this.shoppingCartManager.modifyQuantityProductShoppingCart(idshoppingcart, idproduct, quantity);
	}
	
	public Integer deleteProductShoppingCart(Integer idshoppingcart, Integer idproduct){
		return this.shoppingCartManager.deleteProductShoppingCart(idshoppingcart, idproduct);
	}
	
	public Integer emptyShoppingCart(Integer idshoppingcart){
		return this.shoppingCartManager.emptyShoppingCart(idshoppingcart);
	}
	
	public Collection<Product> findAllProductsOfAShoppingCart(Integer idshoppingcart){
		return this.shoppingCartManager.findAllProductsOfAShoppingCart(idshoppingcart);
	}

}