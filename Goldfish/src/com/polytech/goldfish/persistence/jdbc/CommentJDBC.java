package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.util.Connect;


public class CommentJDBC extends Comment{	

	// Queries
	private static final String queryDeleteCommentById = "DELETE FROM comment WHERE idcomment = ?;";
	private static final String queryInsertComment = "INSERT INTO comment (text, date) VALUES(?,?);";
	private static final String queryGetAllComments = "SELECT * FROM comment;";
	private static final String queryUpdateComment = "UPDATE comment SET text = ?, date = ? WHERE idcomment = ?;";

	// Constructors
	public CommentJDBC(Integer id, String text, Date date) {
		super(id, text, date);
	}

	public static Integer createComment(String text, Integer poster, Integer concernedPerson) {
		Integer idToReturn = null;
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

		try{
			Connection connect = Connect.getInstance().getConnection();
			PreparedStatement instruction = connect.prepareStatement(queryInsertComment, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, text);
			instruction.setString(2, ft.format(dNow));


			// Insert Comment in databse
			int affectedRows = instruction.executeUpdate();
			connect.commit();


			if(affectedRows == 0){
				throw new SQLException("Creating comment failed, no rows affected.");
			}	

			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating comment failed, no ID obtained.");
				}
			}
			// Insert Comment and link between Comment and CommentSeller in database
			if(PersonJDBC.isUser(poster)){
				if(PersonJDBC.isUser(concernedPerson)){
					CommentUserJDBC.queryInsertOneUserToUser(idToReturn, poster, concernedPerson);
				}
				else{
					CommentUserJDBC.queryInsertOneUserToSeller(idToReturn, poster, concernedPerson); 
				} 
			}
			else{
				if(PersonJDBC.isUser(concernedPerson)){
					CommentSellerJDBC.queryInsertOneSellerToUser(idToReturn, poster, concernedPerson);
				}
				else{
					CommentSellerJDBC.queryInsertOneSellerToSeller(idToReturn, poster, concernedPerson);	
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;
	}

	public static Collection<CommentJDBC> findAllComments() {
		Collection<CommentJDBC> listComments = null;
		try{
			listComments = new ArrayList<CommentJDBC>();

			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(queryGetAllComments);
			ResultSet rs = instruction.executeQuery();

			while(rs.next()){
				listComments.add(new CommentJDBC(rs.getInt(1), rs.getString(2), rs.getDate(3)));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return listComments;
	}

	public static Integer updateComment(Integer id, String newText) {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryUpdateComment, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, newText);
			instruction.setString(2, ft.format(dNow));
			instruction.setInt(3, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();

			if(affectedRows == 0){
				throw new SQLException("Updating comment failed, no rows affected.");
			}

			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Updating comment failed, no ID obtained.");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;
	}

	public static Integer deleteCommet(Integer id) {
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryDeleteCommentById, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();

			if(affectedRows == 0){
				throw new SQLException("Deleting comment failed, no rows deleted.");
			}

			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Deleteting comment failed, no ID obtained.");
				}
			}

			// Delete links between Comment and CommentSeller in database
			CommentUserJDBC.queryDeleteOneUserToUser(idToReturn);
			CommentUserJDBC.queryDeleteOneUserToSeller(idToReturn); 
			CommentSellerJDBC.queryDeleteOneSellerToUser(idToReturn);
			CommentSellerJDBC.queryDeleteOneSellerToSeller(idToReturn);	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;
	}
}
