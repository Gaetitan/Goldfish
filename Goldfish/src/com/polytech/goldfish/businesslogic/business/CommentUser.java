package com.polytech.goldfish.businesslogic.business;

import java.sql.Date;

/**
 * Business class CommentUser
 * @author Ga�tan FRAN�OIS
 *
 */
public class CommentUser extends Comment {

	// Constructors
	public CommentUser(Integer id, String nameConcerned, String text, Date date) {
		super(id, nameConcerned, nameConcerned, text, date);
	}
	
	// Other methods

}
