package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ActivityCategory;
import com.polytech.goldfish.util.Connect;

/**
 * Persistence class for an ActivityCategory
 * @author Pierre Laborde
 *
 */
public class ActivityCategoryJDBC extends ActivityCategory{
	
	// Queries
	private static final String queryGetActivityCategoryById = "SELECT * FROM categoryactivity WHERE idCatActivity = ?;";
	private static final String queryInsertOne = "INSERT INTO categoryactivity (name, shortDescription, LongDescription) VALUES(?,?,?);";
	private static final String queryUpdateOne = "UPDATE categoryactivity SET name = ?, shortDescription = ?, LongDescription = ? WHERE idCatActivity = ?;";
	private static final String queryGetAllActivitiesCategories = "SELECT * FROM categoryactivity;";
	private static final String queryDeleteOne = "DELETE FROM categoryactivity WHERE idCatActivity = ?;";
	
	// Constructors
	public ActivityCategoryJDBC(Integer id, String name,
			String shortDescription, String detailledDescription) {
		super(id, name, shortDescription, detailledDescription);
	}
	
	// Other methods
	
		/**
		 * This methods inserts an ActivityCategory in the database
		 * @param name
		 * @param shortDescription
		 * @param detailledDescription
		 * @return 
		 * @return the new activityCategory
		 */
		public static Integer createActivityCategory(String name, String shortDescription, String detailledDescription) {
			Integer idToReturn = null;
			try{
				Connection connect = Connect.getInstance().getConnection();
				
				PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
				instruction.setString(1, name);
				instruction.setString(2, shortDescription);
				instruction.setString(3, detailledDescription);
				int affectedRows = instruction.executeUpdate();
				connect.commit();
				
				if(affectedRows == 0){
					throw new SQLException("Creating activityCategory failed, no ID obtained.");
				}
				
				try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
					if(generatedKeys.next()){
						idToReturn = generatedKeys.getInt(1);
					}
					else{
						throw new SQLException("Creating activityCategory failed, no ID obtained.");
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
		
		/**
		 * This method updates an activityCategory from the database
		 * @param name
		 * @param shortDescription
		 * @param detailledDescription
		 * @return the updated ActivityCategory's id
		 */
		public static Integer updateActivityCategory(Integer id, String name, String shortDescription, String detailledDescription) {
			Integer idToReturn = null;
			try{
				Connection connect = Connect.getInstance().getConnection();
				
				PreparedStatement instruction = connect.prepareStatement(queryUpdateOne, Statement.RETURN_GENERATED_KEYS);
				instruction.setString(1, name);
				instruction.setString(2, shortDescription);
				instruction.setString(3, detailledDescription);
				instruction.setInt(4, id);
				int affectedRows = instruction.executeUpdate();
				connect.commit();
				
				if(affectedRows == 0){
					throw new SQLException("Updating an activityCategory failed, no rows affected.");
				}
				
				try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
					if(generatedKeys.next()){
						idToReturn = generatedKeys.getInt(1);
					}
					else{
						throw new SQLException("Updating an activityCategory failed, no ID obtained.");
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
		
		/**
		 * This method deletes an activityCategory from the database
		 * @param id
		 * @return the deleted Activity's id
		 */
		public static Integer deleteActivityCategory(Integer id) {
			Integer idToReturn = null;
			try{
				Connection connect = Connect.getInstance().getConnection();
				
				PreparedStatement instruction = connect.prepareStatement(queryDeleteOne, Statement.RETURN_GENERATED_KEYS);
				instruction.setInt(1, id);
				int affectedRows = instruction.executeUpdate();
				connect.commit();
				
				if(affectedRows == 0){
					throw new SQLException("Deleting an activityCategory failed, no rows affected.");
				}
				
				try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
					if(generatedKeys.next()){
						idToReturn = generatedKeys.getInt(1);
					}
					else{
						throw new SQLException("Deleting an activityCategory failed, no ID obtained.");
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
		
		/**
		 * This method finds an ActivityCategory thanks to its id
		 * @param id the ActivityCategory's id
		 * @return an ActivityCategory
		 */
		public static ActivityCategoryJDBC findActivityCategoryById(Integer id) {
			ActivityCategoryJDBC activityCategory = null;
			try{
				Connection connect = Connect.getInstance().getConnection();
				
				PreparedStatement instruction = connect.prepareCall(queryGetActivityCategoryById);
				instruction.setInt(1, id);
				ResultSet rs = instruction.executeQuery();
				
				while(rs.next()){
					activityCategory = new ActivityCategoryJDBC(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				}	
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				Connect.getInstance().closeConnection();
			}
			return activityCategory;
		}
		
		/**
		 * This methods get all ActivitiesCategories in the database
		 * 
		 * @return all ActivitiesCategories in the database
		 */
		public static Collection<ActivityCategoryJDBC> findAllActivitiesCategories() {
			Collection<ActivityCategoryJDBC> listActivitiesCategories = null;
			try{
				listActivitiesCategories = new ArrayList<ActivityCategoryJDBC>();
				
				Connection connect = Connect.getInstance().getConnection();
				
				PreparedStatement instruction = connect.prepareCall(queryGetAllActivitiesCategories);
				ResultSet rs = instruction.executeQuery();
				
				while(rs.next()){
					listActivitiesCategories.add(new ActivityCategoryJDBC(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				}	
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				Connect.getInstance().closeConnection();
			}
			
			return listActivitiesCategories;
		}

}
