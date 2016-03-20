package com.polytech.goldfish.persistence.jdbc;

import java.sql.Date;

import com.polytech.goldfish.businesslogic.business.Comment;


public class CommentJDBC extends Comment{
	// Queries
		private static final String queryGetCommentById = "SELECT * FROM comment WHERE idcomment = ?;";
		private static final String queryInsertComment = "INSERT INTO comment (id, text, date) VALUES(?,?,?,?,?,?);";
		private static final String queryGetAllPersons = "SELECT * FROM person;";
		private static final String queryUpdateOne = "UPDATE person SET surname = ?, name = ?, phonenumber = ?, email = ?, password = ? WHERE idperson = ?;";
		private static final String queryGetUserById = "SELECT * FROM \"user\" u, person p WHERE u.idperson=p.idperson AND p.idperson = ?;";
		private static final String queryGetAdministratorById = "SELECT * FROM admin a, person p WHERE a.idperson=p.idperson AND p.idperson = ?;";
		
	// Constructors
	public CommentJDBC(Integer id, String text, Date date) {
		super(id, text, date);
	}

	public static Comment createComment(String text) {
		// TODO Auto-generated method stub
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
