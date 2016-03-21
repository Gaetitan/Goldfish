package com.polytech.goldfish.businesslogic.business;

import java.sql.Date;

/**
 * Business class CommentUser
 * @author Ga�tan FRAN�OIS
 *
 */
public class CommentUser extends Comment {

	// Constructors
	public CommentUser(Integer id, Integer idConcerned, String text, Date date) {
		super(id, idConcerned, text, date);
	}
	
	// Other methods

}
