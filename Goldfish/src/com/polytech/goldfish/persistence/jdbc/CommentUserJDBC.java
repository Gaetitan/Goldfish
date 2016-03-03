package com.polytech.goldfish.persistence.jdbc;

import java.sql.Date;

import com.polytech.goldfish.businesslogic.business.Comment;

/**
 * Persistence class for a CommentUser
 * @author Gaëtan FRANÇOIS
 *
 */
public class CommentUserJDBC extends Comment {

	// Constructors
	public CommentUserJDBC(Integer id, String text, Date date) {
		super(id, text, date);
	}
	
	// Other methods

}
