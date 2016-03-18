package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

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
	public abstract Integer createActivity(String name, String description);
	
	/**
	 * This method updates an Activity
	 * 
	 * @param name
	 * @param description
	 * @return the Person's id
	 */
	public abstract Integer updateActivity(Integer id, String name, String description);
	
	/**
	 * This methods gets all existing Activities
	 * 
	 * @return all existing Activities
	 */
	public abstract Collection <Activity> getAllActivities();

}
