package com.polytech.goldfish.businesslogic.business;

import java.sql.Date;

/**
 * Business class CommentSeller
 * @author Ga�tan FRAN�OIS
 *
 */
public class CommentSeller extends Comment {

	// Constructors
	public CommentSeller(Integer id, String nameConcerned, String text, Date date) {
		super(id, nameConcerned, nameConcerned, text, date);
	}

}
