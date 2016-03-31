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
	 * @param id the activity's id
	 * @return an Activity
	 */
	public abstract Activity getActivityById(Integer id);
	
	/**
	 * This method creates a new Activity
	 * 
	 * @param name the activity's name
	 * @param description the activity's description
	 * @return the activity's id
	 */
	public abstract Integer createActivity(String name, String description, Integer id);
	
	/**
	 * This method updates an Activity
	 * 
	 * @param name the activity's name
	 * @param description the activity's description
	 * @return the Person's id
	 */
	public abstract Integer updateActivity(Integer id, String name, String description);
	
	/**
	 * This method deletes an Activity
	 * 
	 * @param id the activity's id
	 * @return the deleted activity's id
	 */
	public abstract Integer deleteActivity(Integer id);
	
	/**
	 * This methods gets all existing Activities
	 * 
	 * @return all existing Activities
	 */
	public abstract Collection <Activity> getAllActivities();
	
	/**
	 * This methods gets all existing Activities of an user
	 * 
	 * @param id user's id
	 * @return all existing Activities of an user
	 */
	public abstract Collection <Activity> getAllActivitiesOfAnUser(Integer id);

}
