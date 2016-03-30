package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.polytech.goldfish.util.Connect;

public class CommentUserJDBC{
	// Queries
	private static final String queryInsertOneUserToUser = "INSERT INTO commentusertouser (idcomment, idpersonconcernuser, idpersonpostuser) VALUES(?,?,?);";
	private static final String queryInsertOneUserToSeller = "INSERT INTO commentusertoseller (idcomment, idpersonconcernseller, idpersonpostuser) VALUES(?,?,?);";
	private static final String queryDeleteOneUserToUser = "DELETE FROM commentusertouser WHERE idcomment = ?;";
	private static final String queryDeleteOneUserToSeller = "DELETE FROM commentusertouser WHERE idcomment = ?;";

	public static boolean queryInsertOneUserToUser(Integer idComment, Integer idconcerneduser, Integer idposteruser) {
		boolean bool = false;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOneUserToUser, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idComment);
			instruction.setInt(2, idconcerneduser);
			instruction.setInt(3, idposteruser);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating connection between comment and commentUserToUser failed, no rows affected.");
			}
			else {
				bool = true;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}	
		
		return bool;
	}
	
	public static boolean queryInsertOneUserToSeller(Integer idComment, Integer idconcernedseller, Integer idposteruser) {
		boolean bool = false;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOneUserToSeller, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idComment);
			instruction.setInt(2, idconcernedseller);
			instruction.setInt(3, idposteruser);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating connection between comment and commentUserToSeller failed, no rows affected.");
			}
			else {
				bool = true;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}	
		
		return bool;
	}
	

	
	public static boolean queryDeleteOneUserToSeller(Integer idComment) {
		boolean bool = false;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryDeleteOneUserToSeller, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idComment);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Deleting connection between comment and CommentUserToSeller failed, no rows deleted.");
			}
			else {
				bool = true;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}	
		
		return bool;
	}
	
	public static boolean queryDeleteOneUserToUser(Integer idComment) {
		boolean bool = false;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryDeleteOneUserToUser, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idComment);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Deleting connection between comment and CommentUserToUser failed, no rows deleted.");
			}
			else {
				bool = true;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}	
		
		return bool;
	}

}
