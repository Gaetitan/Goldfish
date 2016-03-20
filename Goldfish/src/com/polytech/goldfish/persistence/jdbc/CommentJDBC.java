package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.util.Connect;


public class CommentJDBC extends Comment{	

	// Queries
	private static final String queryGetCommentById = "SELECT * FROM comment WHERE idcomment = ?;";
	private static final String queryMakeLinksUserToUser = "INSERT INTO comment (text, date) VALUES(?,?);";
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
			CommentSellerJDBC.queryInsertOneSellerToSeller(idToReturn, 1, 1); // TODO tout les if 
			CommentSellerJDBC.queryInsertOneSellerToUser(idToReturn, 1, 1); // TODO tout les if 
			CommentUserJDBC.queryInsertOneUserToUser(idToReturn, 1, 1); // TODO tout les if 
			CommentUserJDBC.queryInsertOneUserToSeller(idToReturn, 1, 1); // TODO tout les if 

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;
	}

	public static Object findAllComments() {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean updateComment(String id, String newText) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean deleteCommet(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	// Other methods

}
