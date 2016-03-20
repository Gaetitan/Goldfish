package com.polytech.goldfish.persistence.jdbc;

import java.sql.Date;

import com.polytech.goldfish.businesslogic.business.Comment;


public class CommentJDBC extends Comment{
	// Queries
		private static final String queryGetCommentById = "SELECT * FROM comment WHERE idcomment = ?;";
		private static final String queryInsertComment = "INSERT INTO comment (id, text, date) VALUES(?,?,?);";
		private static final String queryGetAllComments = "SELECT * FROM comment;";
		private static final String queryUpdateComment = "UPDATE comment SET text = ?, date = ? WHERE idcomment = ?;";
		
	// Constructors
	public CommentJDBC(Integer id, String text, Date date) {
		super(id, text, date);
	}

	public static Comment createComment(String text, Integer poster, Integer concernedPerson) {
		return null;
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
