package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Wishlist;
import com.polytech.goldfish.businesslogic.factory.WishlistFactory;
import com.polytech.goldfish.persistence.factoryjdbc.WishlistFactoryJDBC;

public class WishlistManager {

	private final WishlistFactory factory;

	public WishlistManager(){
		this.factory = new WishlistFactoryJDBC();
	}

	public int createWishlist(String name, Integer quantity){
		return this.factory.createWishlist(name, quantity);
	}

	public Collection<Wishlist> findWishlistByIdPerson(Integer id){
		return this.factory.getWishlistByIdPerson(id);
	}
	
	public Wishlist findWishlistById(Integer id){
		return this.factory.getWishlistById(id);
	}
	
	public Collection<Wishlist> findAllWishlists(){
		return this.factory.getAllWishlists();
	}
	
	public int updateWishlist(Integer id, String name, Integer quantity){
		
		return this.factory.updateWishlist(id, name, quantity);
	}
	
	public int deleteWishlist(Integer id){
		
		return this.factory.deleteWishlist(id);
	}
}
