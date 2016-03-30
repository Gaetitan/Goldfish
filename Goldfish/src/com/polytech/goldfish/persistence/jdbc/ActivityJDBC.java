package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Activity;
import com.polytech.goldfish.util.Connect;

/**
 * Persistence class for an Activity
 * @author Pierre Laborde
 *
 */
public class ActivityJDBC extends Activity {

	// Queries
	private static final String queryGetActivityById = "SELECT * FROM activity WHERE idactivity = ?;";
	private static final String queryInsertOne = "INSERT INTO activity (name, description, idperson) VALUES(?,?,?);";
	private static final String queryUpdateOne = "UPDATE activity SET name = ?, description = ? WHERE idactivity = ?;";
	private static final String queryGetAllActivities = "SELECT * FROM activity;";
	private static final String queryGetAllActivitiesOfAnUser = "SELECT * FROM activity where idperson = ?;";
	private static final String queryDeleteOne = "DELETE FROM activity WHERE idactivity = ?;";
	
	// Constructors
	public ActivityJDBC(Integer id, String name, String description) {
		super(id, name, description);
		// TODO Auto-generated constructor stub
	}
	
	public ActivityJDBC(){
		super();	
	}
	
	// Other methods
	
	/**
	 * This methods inserts an Activity in the database
	 * @param name
	 * @param description
	 * @return 
	 * @return the id of the new activity
	 */
	public static Integer createActivity(String name, String description, Integer id) {
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, name);
			instruction.setString(2, description);
			instruction.setInt(3, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating activity failed, no ID obtained.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating activity failed, no ID obtained.");
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
	 * This method updates an activity from the database
	 * @param name
	 * @param description
	 * @return the updated Activity's id
	 */
	public static Integer updateActivity(Integer id, String name, String description) {
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryUpdateOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, name);
			instruction.setString(2, description);
			instruction.setInt(3, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Updating an activity failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Updating an activity failed, no ID obtained.");
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
	 * This method deletes an activity from the database
	 * @param id
	 * @return the deleted Activity's id
	 */
	public static Integer deleteActivity(Integer id) {
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryDeleteOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Deleting an activity failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Deleting an activity failed, no ID obtained.");
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
	 * This method finds an Activity thanks to its id
	 * @param id the Activity's id
	 * @return an Activity
	 */
	public static ActivityJDBC findActivityById(Integer id) {
		ActivityJDBC activity = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetActivityById);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				activity = new ActivityJDBC(rs.getInt(1), rs.getString(3), rs.getString(4));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return activity;
	}
	
	/**
	 * This methods get all Activities in the database
	 * 
	 * @return all Activities in the database
	 */
	public static Collection<ActivityJDBC> findAllActivities() {
		Collection<ActivityJDBC> listActivities = null;
		try{
			listActivities = new ArrayList<ActivityJDBC>();
			
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetAllActivities);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				listActivities.add(new ActivityJDBC(rs.getInt(1), rs.getString(3), rs.getString(4)));

			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		
		return listActivities;
	}
	
	/**
	 * This methods get all Activities of an user in the database
	 * 
	 * @return all Activities of an user in the database
	 */
	public static Collection<ActivityJDBC> findAllActivitiesOfAnUser(Integer id) {
		Collection<ActivityJDBC> listActivities = null;
		try{
			listActivities = new ArrayList<ActivityJDBC>();
			
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetAllActivitiesOfAnUser);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				listActivities.add(new ActivityJDBC(rs.getInt(1), rs.getString(3), rs.getString(4)));

			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		
		return listActivities;
	}

}
