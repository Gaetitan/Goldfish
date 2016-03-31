package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Goal;
import com.polytech.goldfish.util.Connect;

/**
 * @author RedaM
 *
 */
public class GoalJDBC extends Goal {
	
	// Queries
	private static final String queryDeleteGoalById = "DELETE FROM Goal WHERE idgoal = ?;";
	private static final String queryInsertGoal = "INSERT INTO Goal (name, description, deadline, creationdata) VALUES(?,?,?,?);";
	private static final String queryGetAllGoals = "SELECT * FROM Goal;";
	private static final String queryUpdateGoal = "UPDATE Goal SET name = ?, description = ?, deadline = ?, creationdata = ? WHERE idgoal = ?;";
	
	
	// Constructors
	public GoalJDBC(Integer id, String name, String description, Date deadline, Date date_creation) {
		super(id, name, description, deadline, date_creation);
	}
	
	public GoalJDBC(){
		super();	
	}

	/**
	 * <p>
	 * Does update a goal in the the database thanks to the ID of goal
	 * </p>
	 * @param idGoal
	 * @param newName
	 * @param newDescription
	 * @param newDeadline
	 * @return the entry's id
	 */
	public static Integer updateGoal(Integer idGoal, String newName, String newDescription, Date newDeadline) {
		Integer idToReturn = null;

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		try{
			Connection connect = Connect.getInstance().getConnection();
			PreparedStatement instruction = connect.prepareStatement(queryUpdateGoal, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, newName);
			instruction.setString(2, newDescription);
			instruction.setDate(3, sqlDate);
			instruction.setDate(4, newDeadline);
			instruction.setInt(5, idGoal);

			// Update Entry in databse
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			if(affectedRows == 0){
				throw new SQLException("Updating entry failed, no rows affected.");
			}	
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Updating entry failed, no ID obtained.");
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
	 * <p>
	 * Does find all the goals in the database
	 * </p>
	 * @return a collection of goals
	 */	
	public static Collection<GoalJDBC> findAllGoals() {
		Collection<GoalJDBC> listGoals = null;
		try{
			listGoals = new ArrayList<GoalJDBC>();

			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(queryGetAllGoals);
			ResultSet rs = instruction.executeQuery();

			while(rs.next()){
				listGoals.add(new GoalJDBC(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5)));
			}	
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}

		return listGoals;
	}

	/**
	 * <p>
	 * Does insert a goal in the database
	 * </p>
	 * @param name
	 * @param description
	 * @param deadline
	 * @return the id of the newly created goal
	 */
	public static Integer createGoal(String name, String description, Date deadline) {
		Integer idToReturn = null;

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		try{
			Connection connect = Connect.getInstance().getConnection();
			PreparedStatement instruction = connect.prepareStatement(queryInsertGoal, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, name);
			instruction.setString(2, description);
			instruction.setDate(3, deadline);
			instruction.setDate(4, sqlDate);

			// Insert Entry in databse
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			if(affectedRows == 0){
				throw new SQLException("Creating goal failed, no rows affected.");
			}	
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating goal failed, no ID obtained.");
				}
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;
	}

	/**
	 * <p>
	 * Does delete a goal in the database
	 * </p>
	 * @param id
	 * @return true if the deletion has been done, false otherwise
	 */
	public static boolean deleteGoal(Integer id) {
		boolean deleted = false;

		try{
			Connection connect = Connect.getInstance().getConnection();
			PreparedStatement instruction = connect.prepareStatement(queryDeleteGoalById, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);

			// Delete Entry from databse
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			deleted = true;
			
			if(affectedRows == 0){
				throw new SQLException("Deleting goal failed, no rows affected.");
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return deleted;
	}
	
	// Other methods

}
