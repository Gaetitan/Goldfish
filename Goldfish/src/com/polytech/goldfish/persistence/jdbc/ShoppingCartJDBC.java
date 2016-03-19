package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ShoppingCart;
import com.polytech.goldfish.util.Connect;

/**
 * Persistence class for a ShoppingCart
 * @author Pierre Laborde
 *
 */
public class ShoppingCartJDBC extends ShoppingCart{

	// Queries
	private static final String queryGetShoppingCartById = "SELECT * FROM shoppingCart WHERE idshoppingCart = ?;";
	private static final String queryInsertOne = "INSERT INTO shoppingCart ();";
	private static final String queryUpdateOne = "UPDATE shoppingCart WHERE idshoppingCart = ?;";
	private static final String queryGetAllShoppingCarts = "SELECT * FROM shoppingCart;";
	private static final String queryDeleteOne = "DELETE FROM shoppingCart WHERE idshoppingCart = ?;";
	
	// Constructors
	public ShoppingCartJDBC(Integer id) {
		super(id);
	}
	
	// Other methods
	/**
	 * This methods inserts a ShoppingCart in the database
	 * @return 
	 * @return the new ShoppingCart
	 */
	public static Integer createShoppingCart() {
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating ShoppingCart failed, no ID obtained.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating ShoppingCart failed, no ID obtained.");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;	
	}
	
	/**
	 * This method updates a ShoppingCart from the database
	 * @return the updated ShoppingCart's id
	 */
	public static Integer updateShoppingCart(Integer id) {
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryUpdateOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Updating a ShoppingCart failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Updating a ShoppingCart failed, no ID obtained.");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;
	}
	
	/**
	 * This method deletes an shoppingCart from the database
	 * @param id
	 * @return the deleted shoppingCart's id
	 */
	public static Integer deleteShoppingCart(Integer id) {
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryDeleteOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Deleting a shoppingCart failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Deleting a shoppingCart failed, no ID obtained.");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;
	}
	
	/**
	 * This method finds a ShoppingCart thanks to its id
	 * @param id the ShoppingCart's id
	 * @return a ShoppingCart
	 */
	public static ShoppingCartJDBC findShoppingCartById(Integer id) {
		ShoppingCartJDBC shoppingCart = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetShoppingCartById);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				shoppingCart = new ShoppingCartJDBC(rs.getInt(1));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return shoppingCart;
	}
	
	/**
	 * This methods get all ShoppingCarts in the database
	 * 
	 * @return all ShoppingCarts in the database
	 */
	public static Collection<ShoppingCartJDBC> findAllShoppingCarts() {
		Collection<ShoppingCartJDBC> listShoppingCarts = null;
		try{
			listShoppingCarts = new ArrayList<ShoppingCartJDBC>();
			
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetAllShoppingCarts);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				listShoppingCarts.add(new ShoppingCartJDBC(rs.getInt(1)));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return listShoppingCarts;
	}


}
