package com.polytech.goldfish.businesslogic.facade;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Wishlist;
import com.polytech.goldfish.businesslogic.manager.WishlistManager;
import com.polytech.goldfish.util.GoldfishException;

public class WishlistFacade {

	private final WishlistManager WishlistManager;

	public WishlistFacade(){
		this.WishlistManager = new WishlistManager();
	}

	public int createWishlist(String name, Integer quantity){
		return this.WishlistManager.createWishlist(name, quantity);
	}

	public Collection<Wishlist> findWishlistByIdPerson(Integer id){
		return this.WishlistManager.findWishlistByIdPerson(id);
	}
	
	public Wishlist findWishlistById(Integer id){
		return this.WishlistManager.findWishlistById(id);
	}
	
	public Collection<Wishlist> findAllWishlists(){
		return this.WishlistManager.findAllWishlists();
	}
	
	public int updateWishlist(Integer id, String name, Integer quantity)throws GoldfishException{
		return this.WishlistManager.updateWishlist(id,name,quantity);
	}
	
	public int deleteWishlist(Integer id) throws GoldfishException{
		return this.WishlistManager.deleteWishlist(id);
	}

}
