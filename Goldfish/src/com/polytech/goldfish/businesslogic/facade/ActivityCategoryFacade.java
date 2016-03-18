package com.polytech.goldfish.businesslogic.facade;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ActivityCategory;
import com.polytech.goldfish.businesslogic.manager.ActivityCategoryManager;
import com.polytech.goldfish.util.GoldfishException;

/**
 * Facade for an ActivityCategory
 * 
 * @author Pierre Laborde
 *
 */
public class ActivityCategoryFacade {
	
	private final ActivityCategoryManager activityCategoryManager;
	
	public ActivityCategoryFacade(){
		this.activityCategoryManager = new ActivityCategoryManager();
	}
	
	public Integer createActivityCategory(String name, String shortDescription, String detailledDescription) throws GoldfishException {
		return this.activityCategoryManager.createActivityCategory(name, shortDescription, detailledDescription);
	}
	
	public Integer updateActivityCategory(Integer id, String name, String shortDescription, String detailledDescription) throws GoldfishException {
		return this.activityCategoryManager.updateActivityCategory(id, name, shortDescription, detailledDescription);
	}
	
	public ActivityCategory findActivityCategoryById(Integer id){
		return this.activityCategoryManager.findActivityCategoryById(id);
	}
	
	public Collection<ActivityCategory> findAllActivitiesCategories(){
		return this.activityCategoryManager.findAllActivitiesCategories();
	}

}
