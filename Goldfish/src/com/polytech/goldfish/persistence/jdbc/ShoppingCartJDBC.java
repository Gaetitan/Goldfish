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
	private static final String queryGetShoppingCartOfAnUser = "SELECT * FROM shoppingCart WHERE idPerson = ?;";
	private static final String queryGetShoppingCartById = "SELECT * FROM shoppingCart WHERE idshoppingCart = ?;";
	private static final String queryInsertOne = "INSERT INTO shoppingCart (idperson) VALUES (?);";
	private static final String queryUpdateOne = "UPDATE shoppingCart WHERE idshoppingCart = ?;";
	private static final String queryGetAllShoppingCarts = "SELECT * FROM shoppingCart;";
	private static final String queryDeleteOne = "DELETE FROM shoppingCart WHERE idshoppingCart = ?;";
	private static final String queryAddProduct = "INSERT INTO shoppingCartcontainsproduct (idshoppingcart, idproduct, quantity) VALUES (?,?,?);";
	private static final String queryChangeQuantityProduct = "UPDATE shoppingCartcontainsproduct SET quantity = ? WHERE idshoppingCart = ? AND idproduct = ?;";
	private static final String queryDeleteProduct = "DELETE FROM shoppingCartcontainsproduct WHERE idshoppingCart = ? AND idproduct = ?;";
	private static final String queryEmptyShoppingCart = "DELETE FROM shoppingCartcontainsproduct WHERE idshoppingCart = ?;";
	private static final String queryGetAllProductsFromShoppingCart = "SELECT * FROM ShoppingCartContainsProduct,product WHERE idshoppingCart = ? and shoppingcartcontainsproduct.idproduct = product.idproduct;";

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
	public static Integer createShoppingCart(Integer id) {
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);
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
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
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
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
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
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
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
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return shoppingCart;
	}

	/**
	 * This method finds a ShoppingCart thanks to the id owner
	 * @param id the id of the owner
	 * @return a ShoppingCart
	 */
	public static ShoppingCartJDBC findShoppingCartOfAnUser(Integer id) {
		ShoppingCartJDBC shoppingCart = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			PreparedStatement instruction = connect.prepareCall(queryGetShoppingCartOfAnUser);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();

			while(rs.next()){
				shoppingCart = new ShoppingCartJDBC(rs.getInt(1));
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
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
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}

		return listShoppingCarts;
	}

	/**
	 * This method adds a product into a ShoppingCart
	 * @return the ShoppingCart's id
	 */
	public static Integer addProductShoppingCart(Integer idshoppingcart, Integer idproduct, Integer quantity) {
		Integer idToReturn = idshoppingcart;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryAddProduct, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idshoppingcart);
			instruction.setInt(2, idproduct);
			instruction.setInt(3, quantity);
			int affectedRows = instruction.executeUpdate();
			connect.commit();

			if(affectedRows == 0){
				throw new SQLException("Addind a product to the ShoppingCart failed, no rows affected.");
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return idToReturn;
	}

	/**
	 * This method modifies the quantity of a product into a ShoppingCart
	 * @return the ShoppingCart's id
	 */
	public static Integer modifyQuantityProductShoppingCart(Integer idshoppingcart, Integer idproduct, Integer quantity) {
		Integer idToReturn = idshoppingcart;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryChangeQuantityProduct, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, quantity);
			instruction.setInt(2, idshoppingcart);
			instruction.setInt(3, idproduct);
			int affectedRows = instruction.executeUpdate();
			connect.commit();

			if(affectedRows == 0){
				throw new SQLException("Modifying the quantity of the product in the ShoppingCart failed, no rows affected.");
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return idToReturn;
	}

	/**
	 * This method deletes a product from a ShoppingCart
	 * @return the ShoppingCart's id
	 */
	public static Integer deleteProductShoppingCart(Integer idshoppingcart, Integer idproduct) {
		Integer idToReturn = idshoppingcart;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryDeleteProduct, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idshoppingcart);
			instruction.setInt(2, idproduct);
			int affectedRows = instruction.executeUpdate();
			connect.commit();

			if(affectedRows == 0){
				throw new SQLException("Deleting the product from the ShoppingCart failed, no rows affected.");
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return idToReturn;
	}

	/**
	 * This method empties a ShoppingCart
	 * @return the ShoppingCart's id
	 */
	public static Integer emptyShoppingCart(Integer idshoppingcart) {
		Integer idToReturn = idshoppingcart;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryEmptyShoppingCart, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idshoppingcart);
			int affectedRows = instruction.executeUpdate();
			connect.commit();

			if(affectedRows == 0){
				throw new SQLException("Emptying the ShoppingCart failed, no rows affected.");
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return idToReturn;
	}

	/**
	 * This methods gets all products in a shoppingcart
	 * 
	 * @return all products from a shoppingcart
	 */
	public static Collection<ProductJDBC> findAllProductsOfAShoppingCart(Integer idshoppingcart) {
		Collection<ProductJDBC> listProducts = null;
		try{
			listProducts = new ArrayList<ProductJDBC>();

			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(queryGetAllProductsFromShoppingCart);
			instruction.setInt(1, idshoppingcart);
			ResultSet rs = instruction.executeQuery();

			while(rs.next()){
				listProducts.add(new ProductJDBC(rs.getInt(3),rs.getString(5),rs.getString(6)));
			}	
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}

		return listProducts;
	}
}