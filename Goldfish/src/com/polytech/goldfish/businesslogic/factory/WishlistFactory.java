package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Wishlist;

public abstract class WishlistFactory {

	public abstract Collection <Wishlist> getWishlistByIdPerson(Integer id);
	
	public abstract Wishlist getWishlistById(Integer id);
	
	public abstract int createWishlist(String name,Integer quantity);
	
	public abstract Collection <Wishlist> getAllWishlists();
	
	public abstract int updateWishlist(Integer id, String name, Integer quantity);
	
	public abstract int deleteWishlist(Integer id);
}
