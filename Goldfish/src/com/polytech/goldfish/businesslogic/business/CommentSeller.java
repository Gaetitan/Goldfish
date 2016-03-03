package com.polytech.goldfish.businesslogic.business;

import java.sql.Date;

/**
 * Business class CommentSeller
 * @author Gaëtan FRANÇOIS
 *
 */
public class CommentSeller extends Comment {

	// Constructors
	public CommentSeller(Integer id, String text, Date date) {
		super(id, text, date);
	}

}
