package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Product;
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
	
	public Integer createShoppingCart(Integer id) throws GoldfishException {
		return this.factory.createShoppingCart(id);		
	}
	
	public Integer updateShoppingCart(Integer id) throws GoldfishException {
		return this.factory.updateShoppingCart(id);
	}
	
	public Integer deleteShoppingCart(Integer id) throws GoldfishException {
		return this.factory.deleteShoppingCart(id);
	}
	
	public ShoppingCart findShoppingCartOfAnUser(Integer id){
		return this.factory.findShoppingCartOfAnUser(id);
	}
	
	public ShoppingCart findShoppingCartById(Integer id){
		return this.factory.getShoppingCartById(id);
	}
	
	public Collection<ShoppingCart> findAllShoppingCarts(){
		return this.factory.getAllShoppingCarts();
	}
	
	public Integer addProductShoppingCart(Integer idshoppingcart, Integer idproduct, Integer quantity) throws GoldfishException{
		return this.factory.addProductShoppingCart(idshoppingcart, idproduct, quantity);
	}
	
	public Integer modifyQuantityProductShoppingCart(Integer idshoppingcart, Integer idproduct, Integer quantity){
		return this.factory.modifyQuantityProductShoppingCart(idshoppingcart, idproduct, quantity);
	}
	
	public Integer deleteProductShoppingCart(Integer idshoppingcart, Integer idproduct){
		return this.factory.deleteProductShoppingCart(idshoppingcart, idproduct);
	}
	
	public Integer emptyShoppingCart(Integer idshoppingcart){
		return this.factory.emptyShoppingCart(idshoppingcart);
	}
	
	public Collection<Product> findAllProductsOfAShoppingCart(Integer idshoppingcart){
		return this.factory.findAllProductsOfAShoppingCart(idshoppingcart);
	}

}