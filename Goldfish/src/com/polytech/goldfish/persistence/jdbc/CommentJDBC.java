package com.polytech.goldfish.persistence.jdbc;

import java.sql.Date;

import com.polytech.goldfish.businesslogic.business.Comment;

/**
 * Persistence class for a Comment
 * @author Gaëtan FRANÇOIS
 *
 */
public class CommentJDBC extends Comment{
	// Queries
	
	// Constructors
	public CommentJDBC(Integer id, String text, Date date) {
		super(id, text, date);
	}
	
	// Other methods

}
