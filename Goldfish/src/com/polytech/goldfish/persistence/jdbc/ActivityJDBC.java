package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	private static final String queryInsertOne = "INSERT INTO activity (name, description) VALUES(?,?);";
	
	// Constructors
	public ActivityJDBC(Integer id, String name, String description) {
		super(id, name, description);
		// TODO Auto-generated constructor stub
	}
	
	// Other methods
	
	/**
	 * This methods inserts an Activity in the database
	 * @param name
	 * @param description
	 * @return 
	 * @return the new activity
	 */
	public static int createActivity(String name, String description) {
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, name);
			instruction.setString(2, description);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating activity failed, no rows affected.");
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
				activity = new ActivityJDBC(rs.getInt(1), rs.getString(2), rs.getString(3));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return activity;
	}

}
