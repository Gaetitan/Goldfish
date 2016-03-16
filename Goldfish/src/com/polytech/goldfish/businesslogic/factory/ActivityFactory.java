package com.polytech.goldfish.businesslogic.factory;

import com.polytech.goldfish.businesslogic.business.Activity;

/**
 * Factory class
 * This class provides the methods necessary to create the activities used in the application
 * 
 * @author Pierre Laborde
 *
 */
public abstract class ActivityFactory {

	/**
	 * This methods gets an Activity thanks to its id
	 * @param id
	 * @return an Activity
	 */
	public abstract Activity getActivityById(Integer id);
	
	/**
	 * This method creates a new Activity
	 * 
	 * @param name
	 * @param description
	 */
	public abstract int createActivity(String name, String description);
}
