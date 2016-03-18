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
	 * @param id
	 * @return an ActivityCategory
	 */
	public abstract ActivityCategory getActivityCategoryById(Integer id);
	
	/**
	 * This method creates a new ActivityCategory
	 * 
	 * @param name
	 * @param shortDescription
	 * @param detailledDescription
	 */
	public abstract Integer createActivityCategory(String name, String shortDescription, String detailledDescription);
	
	/**
	 * This method updates an ActivityCategory
	 * 
	 * @param name
	 * @param shortDescription
	 * @param detailledDescription
	 * @return the Person's id
	 */
	public abstract Integer updateActivityCategory(Integer id, String name, String shortDescription, String detailledDescription);
	
	/**
	 * This methods gets all existing ActivitiesCategories
	 * 
	 * @return all existing ActivitiesCategories
	 */
	public abstract Collection <ActivityCategory> getAllActivitiesCategories();

}
