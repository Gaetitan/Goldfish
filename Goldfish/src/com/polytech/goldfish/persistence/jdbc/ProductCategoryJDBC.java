package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ProductCategory;
import com.polytech.goldfish.util.Connect;

public class ProductCategoryJDBC extends ProductCategory {

	// Queries
	private static final String queryGetProductCategoryById = "SELECT * FROM ProductCategory WHERE idProductCategory = ?;";
	private static final String queryInsertOne = "INSERT INTO ProductCategory (name) VALUES(?);";
	private static final String queryUpdateOne = "UPDATE ProductCategory SET name = ? WHERE idProductCategory = ?;";
	private static final String queryGetAllProductCategories = "SELECT * FROM ProductCategory;";
	private static final String queryDeleteOne ="DELETE FROM ProductCategory WHERE idProductCategory = ?;";
	
	
	// Constructors
	public ProductCategoryJDBC(Integer id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	
	// Other methods
	public static int createProductCategory(String name) {
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, name);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating Product Category failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating Product Category failed, no ID obtained.");
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
	
	public static ProductCategoryJDBC findProductCategoryById(Integer id) {
		ProductCategoryJDBC productCategory = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetProductCategoryById);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				productCategory = new ProductCategoryJDBC(rs.getInt(1), rs.getString(2));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return productCategory;
	}
	
	public static Collection<ProductCategoryJDBC> findAllProductCategories() {
		Collection<ProductCategoryJDBC> listProductCategorys = null;
		try{
			listProductCategorys = new ArrayList<ProductCategoryJDBC>();
			
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetAllProductCategories);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				listProductCategorys.add(new ProductCategoryJDBC(rs.getInt(1), rs.getString(2)));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		
		return listProductCategorys;
	}
	
	public static int updateProductCategory(Integer id, String name){
		
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryUpdateOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, name);
			instruction.setInt(2, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Updating Product Category failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Updating Product Category failed, no ID obtained.");
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
	
	public static int deleteProductCategory(Integer id){
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryDeleteOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Deleting Product Category failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Deleting Product Category failed, no ID obtained.");
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
