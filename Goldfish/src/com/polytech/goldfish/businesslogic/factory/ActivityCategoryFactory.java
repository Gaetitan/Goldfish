package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ActivityCategory;

/**
 * Factory class
 * This class provides the methods necessary to create the activities categories used in the application
 * 
 * @author Pierre Laborde
 *
 */
public abstract class ActivityCategoryFactory {
	
	/**
	 * This methods gets an ActivityCategory thanks to its id
	 * @param id the activity id
	 * @return an ActivityCategory
	 */
	public abstract ActivityCategory getActivityCategoryById(Integer id);
	
	/**
	 * This method creates a new ActivityCategory
	 * 
	 * @param name the activity name
	 * @param shortDescription a short description of the activity
	 * @param detailledDescription a detailed description of the activity
	 * @return the activity id
	 */
	public abstract Integer createActivityCategory(String name, String shortDescription, String detailledDescription);
	
	/**
	 * This method updates an ActivityCategory
	 * 
	 * @param name the activity name
	 * @param shortDescription the activity short description
	 * @param detailledDescription the detailed description of the activity
	 * @return the ActivityCategory's id
	 */
	public abstract Integer updateActivityCategory(Integer id, String name, String shortDescription, String detailledDescription);
	
	/**
	 * This method deletes an ActivityCategory
	 * 
	 * @param id the activity category's id
	 * @return the ActivityCategory's id
	 */
	public abstract Integer deleteActivityCategory(Integer id);
	
	/**
	 * This methods gets all existing ActivitiesCategories
	 * 
	 * @return all existing ActivitiesCategories
	 */
	public abstract Collection <ActivityCategory> getAllActivitiesCategories();

}
