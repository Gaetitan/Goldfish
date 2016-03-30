package com.polytech.goldfish.persistence.factoryjdbc;

import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ActivityCategory;
import com.polytech.goldfish.businesslogic.factory.ActivityCategoryFactory;
import com.polytech.goldfish.persistence.jdbc.ActivityCategoryJDBC;

/**
 * This class creates the activities categories used in the application
 * 
 * @author Pierre Laborde
 *
 */
public class ActivityCategoryFactoryJDBC extends ActivityCategoryFactory  {
	
	@Override
	public Integer createActivityCategory(String name, String shortDescription, String detailledDescription) {
		return ActivityCategoryJDBC.createActivityCategory(name, shortDescription, detailledDescription);
	}

	@Override
	public ActivityCategory getActivityCategoryById(Integer id) {
		return ActivityCategoryJDBC.findActivityCategoryById(id);
	}
	
	@Override
	public Integer updateActivityCategory(Integer id, String name, String shortDescription, String detailledDescription) {
		return ActivityCategoryJDBC.updateActivityCategory(id, name, shortDescription, detailledDescription);
	}
	
	@Override
	public Integer deleteActivityCategory(Integer id) {
		return ActivityCategoryJDBC.deleteActivityCategory(id);
	}
	
	@Override
	public Collection<ActivityCategory> getAllActivitiesCategories() {
		// Creation of a collection of ActivitiesCategories
		Collection<ActivityCategoryJDBC> listActivitiesCategoriesJDBC = ActivityCategoryJDBC.findAllActivitiesCategories();
		Collection<ActivityCategory> listActivitiesCategories = new ArrayList<ActivityCategory>();
		
		// Put the ActivityCategoryJDBC as ActivityCategory in a new list
		for(ActivityCategory activityCategory : listActivitiesCategoriesJDBC) {
			listActivitiesCategories.add(activityCategory);
		}

		// Return the new list
		return listActivitiesCategories;
	}

}
