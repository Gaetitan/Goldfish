package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Wishlist;
import com.polytech.goldfish.util.Connect;

public class WishlistJDBC extends Wishlist {

	// Queries
	private static final String queryGetWishlistByIdPerson = "SELECT w.idwishlist, cp.name, wc.quantity  FROM WishListContainsCatProduct wc, \"user\" u, wishlist w, categoryproduct cp WHERE u.idperson = ? AND u.idperson = w.idperson AND w.idwishlist = wc.idwishlist AND wc.idcatProduct = cp.idcatProduct;";
	private static final String queryGetWishlistById = "SELECT *  FROM WishListContainsCatProduct WHERE idWishlist = ?;";
	private static final String queryInsertOne = "INSERT INTO Wishlist (name, quantity) VALUES(?,?);";
	private static final String queryUpdateOne = "UPDATE WishListContainsCatProduct SET IDCatProduct = (SELECT IDCatProduct FROM categoryProduct WHERE name = ?), quantity = ? WHERE idWishlist = ?;";
	private static final String queryGetAllWishlists = "SELECT wc.idWishlist, cp.name, wc.quantity FROM WishListContainsCatProduct wc, categoryProduct cp WHERE wc.IDCatProduct = cp.IDCatProduct;";
	private static final String queryDeleteOne ="DELETE FROM Wishlist WHERE idWishlist = ?;";
	
	
	// Constructors
	public WishlistJDBC(Integer id, String name, Integer quantity) {
		super(id, name, quantity);
		// TODO Auto-generated constructor stub
	}
	
	// Other methods
	public static int createWishlist(String name, Integer quantity) {
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, name);
			instruction.setInt(2, quantity);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating Wishlist failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating Wishlist failed, no ID obtained.");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return idToReturn;		
	}
	
	public static Collection<WishlistJDBC> findWishlistByIdPerson(Integer id) {
		Collection<WishlistJDBC> listWishlists = null;
		try{
			listWishlists = new ArrayList<WishlistJDBC>();
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetWishlistByIdPerson);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				listWishlists.add(new WishlistJDBC(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return listWishlists;
	}
	
	public static WishlistJDBC findWishlistById(Integer id) {
		WishlistJDBC wishlist = null;
		try{
	
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetWishlistById);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				wishlist = new WishlistJDBC(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return wishlist;
	}
	
	public static Collection<WishlistJDBC> findAllWishlists() {
		Collection<WishlistJDBC> listWishlists = null;
		try{
			listWishlists = new ArrayList<WishlistJDBC>();
			
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetAllWishlists);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				listWishlists.add(new WishlistJDBC(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		
		return listWishlists;
	}
	
	public static int updateWishlist(Integer id, String name, Integer quantity){
		
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryUpdateOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, name);
			instruction.setInt(2, quantity);
			instruction.setInt(3, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Updating Wishlist failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Updating Wishlist failed, no ID obtained.");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return idToReturn;
	}
	
	public static int deleteWishlist(Integer id){
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryDeleteOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Deleting Wishlist failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Deleting Wishlist failed, no ID obtained.");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return idToReturn;
	}

}
