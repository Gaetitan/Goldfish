package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.polytech.goldfish.util.Connect;

public class CommentSellerJDBC{
	// Queries
	private static final String queryInsertOneSellerToUser = "INSERT INTO commentsellertouser (idcomment, idpersonconcernuser, idpersonpost) VALUES(?,?,?);";
	private static final String queryInsertOneSellerToSeller = "INSERT INTO commentsellertoseller (idcomment, idpersonconcernseller, idpersonpost) VALUES(?,?,?);";
	private static final String queryDeleteOneSellerToUser = "DELETE FROM commentsellertouser WHERE idcomment = ?;";
	private static final String queryDeleteOneSellerToSeller = "DELETE FROM commentsellertoseller WHERE idcomment = ?;";


	public static boolean queryInsertOneSellerToUser(Integer idComment, Integer idconcerneduser, Integer idposterseller) {
		boolean bool = false;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOneSellerToUser, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idComment);
			instruction.setInt(2, idconcerneduser);
			instruction.setInt(3, idposterseller);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating connection between comment and commentSellerToUser failed, no rows affected.");
			}
			else {
				bool = true;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
		
		return bool;
	}
	
	public static boolean queryInsertOneSellerToSeller(Integer idComment, Integer idconcernedseller, Integer idposterseller) {
		boolean bool = false;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOneSellerToSeller, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idComment);
			instruction.setInt(2, idconcernedseller);
			instruction.setInt(3, idposterseller);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating connection between comment and commentSellerToSeller failed, no rows affected.");
			}
			else {
				bool = true;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
		
		return bool;
	}
	
	
	public static boolean queryDeleteOneSellerToSeller(Integer idComment) {
		boolean bool = false;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryDeleteOneSellerToSeller, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idComment);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Deleting connection between comment and CommentSellerToSeller failed, no rows deleted.");
			}
			else {
				bool = true;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
		
		return bool;
	}
	
	public static boolean queryDeleteOneSellerToUser(Integer idComment) {
		boolean bool = false;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryDeleteOneSellerToUser, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idComment);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Deleting connection between comment and commentSellerToUser failed, no rows deleted.");
			}
			else {
				bool = true;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
		
		return bool;
	}
	
}
