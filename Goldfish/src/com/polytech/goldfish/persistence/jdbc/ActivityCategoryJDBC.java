package com.polytech.goldfish.persistence.jdbc;

import com.polytech.goldfish.businesslogic.business.ActivityCategory;

/**
 * Persistence class for an ActivityCategory
 * @author Ga�tan FRAN�OIS
 *
 */
public class ActivityCategoryJDBC extends ActivityCategory{

	// Queries
	
	
	// Constructors
	public ActivityCategoryJDBC(Integer id, String name,
			String short_description, String detailed_description) {
		super(id, name, short_description, detailed_description);
	}

}
