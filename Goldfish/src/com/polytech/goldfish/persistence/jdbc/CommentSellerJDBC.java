package com.polytech.goldfish.persistence.jdbc;

import java.sql.Date;

import com.polytech.goldfish.businesslogic.business.CommentSeller;

/**
 * Persistence class for a CommentUser
 * @author Gaëtan FRANÇOIS
 *
 */
public class CommentSellerJDBC extends CommentSeller {

	// Constructors
	public CommentSellerJDBC(Integer id, String text, Date date) {
		super(id, text, date);
	}
	
	// Other methods

}
