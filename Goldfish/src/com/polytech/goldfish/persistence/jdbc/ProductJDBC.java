package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Product;
import com.polytech.goldfish.util.Connect;

public class ProductJDBC extends Product {

	// Queries
	private static final String queryGetProductById = "SELECT * FROM product WHERE idproduct = ?;";
	private static final String queryInsertOne = "INSERT INTO product (name, description) VALUES(?,?);";
	private static final String queryUpdateOne = "UPDATE product SET name = ?, description = ? WHERE idproduct = ?;";
	private static final String queryGetAllProducts = "SELECT * FROM product;";
	private static final String queryDeleteOne ="DELETE FROM product WHERE idproduct = ?;";
	
	
	// Constructors
	public ProductJDBC(Integer id, String name, String description) {
		super(id, name, description);
		// TODO Auto-generated constructor stub
	}
	
	public ProductJDBC(){
		super();	
	}
	
	// Other methods
	public static int createProduct(String name, String description) {
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, name);
			instruction.setString(2, description);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating product failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating product failed, no ID obtained.");
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
	
	public static ProductJDBC findProductById(Integer id) {
		ProductJDBC product = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetProductById);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				product = new ProductJDBC(rs.getInt(1), rs.getString(2), rs.getString(3));
			}	
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return product;
	}
	
	public static Collection<ProductJDBC> findAllProducts() {
		Collection<ProductJDBC> listProducts = null;
		try{
			listProducts = new ArrayList<ProductJDBC>();
			
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetAllProducts);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				listProducts.add(new ProductJDBC(rs.getInt(1), rs.getString(2), rs.getString(3)));
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
	
	public static int updateProduct(Integer id, String name, String description){
		
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryUpdateOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, name);
			instruction.setString(2, description);
			instruction.setInt(3, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Updating product failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Updating product failed, no ID obtained.");
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
	
	public static int deleteProduct(Integer id){
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryDeleteOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Deleting product failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Deleting product failed, no ID obtained.");
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

}
