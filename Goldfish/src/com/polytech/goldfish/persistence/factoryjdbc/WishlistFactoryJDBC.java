package com.polytech.goldfish.persistence.factoryjdbc;

import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Wishlist;
import com.polytech.goldfish.businesslogic.factory.WishlistFactory;
import com.polytech.goldfish.persistence.jdbc.WishlistJDBC;

public class WishlistFactoryJDBC extends WishlistFactory{
	
	@Override
	public int createWishlist(String name, Integer quantity) {
		return WishlistJDBC.createWishlist(name, quantity);
	}

	@Override
	public Wishlist getWishlistById(Integer id) {
		return WishlistJDBC.findWishlistById(id);
	}
	
	@Override
	public Collection<Wishlist> getWishlistByIdPerson(Integer id) {
		// Creation of a collection of Wishlist
		Collection<Wishlist> listWishlists = new ArrayList<Wishlist>();
				
		// Put the PersonJDBC as Wishlist in a new list
		for(Wishlist wishlist : WishlistJDBC.findWishlistByIdPerson(id)) {
			listWishlists.add(wishlist);
		}

		// Return the new list
		return listWishlists;
	}
	
	@Override
	public Collection<Wishlist> getAllWishlists() {
		// Creation of a collection of Wishlist
		Collection<Wishlist> listWishlists = new ArrayList<Wishlist>();
		
		// Put the PersonJDBC as Wishlist in a new list
		for(Wishlist Wishlist : WishlistJDBC.findAllWishlists()) {
			listWishlists.add(Wishlist);
		}

		// Return the new list
		return listWishlists;
	}

	@Override
	public int updateWishlist(Integer id,String name, Integer quantity){
		return WishlistJDBC.updateWishlist(id, name, quantity);
	}
	
	@Override
	public int deleteWishlist(Integer id){
		return WishlistJDBC.deleteWishlist(id);
	}
}
