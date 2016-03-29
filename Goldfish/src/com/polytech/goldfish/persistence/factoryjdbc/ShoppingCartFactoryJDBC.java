package com.polytech.goldfish.persistence.factoryjdbc;

import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Product;
import com.polytech.goldfish.businesslogic.business.ShoppingCart;
import com.polytech.goldfish.businesslogic.factory.ShoppingCartFactory;
import com.polytech.goldfish.persistence.jdbc.ProductJDBC;
import com.polytech.goldfish.persistence.jdbc.ShoppingCartJDBC;

/**
 * This class creates the shopping carts used in the application
 * 
 * @author Pierre Laborde
 *
 */
public class ShoppingCartFactoryJDBC extends ShoppingCartFactory {
	
	@Override
	public Integer createShoppingCart(Integer id) {
		return ShoppingCartJDBC.createShoppingCart(id);
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
		Collection<ShoppingCartJDBC> listShoppingCartsJDBC = ShoppingCartJDBC.findAllShoppingCarts();
		Collection<ShoppingCart> listShoppingCarts = new ArrayList<ShoppingCart>();
		
		// Put the ShoppingCartJDBC as ShoppingCart in a new list
		for(ShoppingCart shoppingCart : listShoppingCartsJDBC ) {
			listShoppingCarts.add(shoppingCart);
		}

		// Return the new list
		return listShoppingCarts;
	}
	
	@Override
	public Integer addProductShoppingCart(Integer idshoppingcart, Integer idproduct, Integer quantity) {
		return ShoppingCartJDBC.addProductShoppingCart(idshoppingcart, idproduct, quantity);
	}
	
	@Override
	public Integer modifyQuantityProductShoppingCart(Integer idshoppingcart, Integer idproduct, Integer quantity) {
		return ShoppingCartJDBC.modifyQuantityProductShoppingCart(idshoppingcart, idproduct, quantity);
	}
	
	@Override
	public Integer deleteProductShoppingCart(Integer idshoppingcart, Integer idproduct) {
		return ShoppingCartJDBC.deleteProductShoppingCart(idshoppingcart, idproduct);
	}
	
	@Override
	public Integer emptyShoppingCart(Integer idshoppingcart) {
		return ShoppingCartJDBC.emptyShoppingCart(idshoppingcart);
	}
	
	@Override
	public Collection<Product> findAllProductsOfAShoppingCart(Integer idshoppingcart) {
		// Creation of a collection of products
		Collection<ProductJDBC> listProductsJDBC = ShoppingCartJDBC.findAllProductsOfAShoppingCart(idshoppingcart);
		Collection<Product> listProducts = new ArrayList<Product>();
		
		// Put the ProductJDBC as product in a new list
		for(Product product : listProductsJDBC ) {
			listProducts.add(product);
		}
		// Return the new list
		return listProducts;
	}
	

}
