package com.polytech.goldfish.businesslogic.business;

import java.sql.Date;

/**
 * Business class CommentSeller
 * @author Ga�tan FRAN�OIS
 *
 */
public class CommentSeller extends Comment {

	// Constructors
	public CommentSeller(Integer id, Integer idConcerned, String text, Date date) {
		super(id, idConcerned, text, date);
	}

}
