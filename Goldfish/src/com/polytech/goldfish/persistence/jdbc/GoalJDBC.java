package com.polytech.goldfish.persistence.jdbc;

import java.sql.Date;

import com.polytech.goldfish.businesslogic.business.Goal;

/**
 * Persitence class for a Goal
 * @author Gaëtan FRANÇOIS
 *
 */
public class GoalJDBC extends Goal {
	
	// Queries
	
	// Constructors
	public GoalJDBC(Integer id, String name, String description, Date deadline,
			Date date_creation) {
		super(id, name, description, deadline, date_creation);
	}
	
	// Other methods

}
