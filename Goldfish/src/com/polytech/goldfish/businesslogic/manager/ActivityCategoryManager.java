package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.ActivityCategory;
import com.polytech.goldfish.businesslogic.factory.ActivityCategoryFactory;
import com.polytech.goldfish.persistence.factoryjdbc.ActivityCategoryFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;

/**
 * This class allows an administrator to create a new activity category
 * 
 * @author Pierre Laborde
 *
 */
public class ActivityCategoryManager {
	
	private final ActivityCategoryFactory factory;
	
	public ActivityCategoryManager(){
		this.factory = new ActivityCategoryFactoryJDBC();
	}
	
	public Integer createActivityCategory(String name, String shortDescription, String detailledDescription) throws GoldfishException {
		if(name.isEmpty() || shortDescription.isEmpty() || detailledDescription.isEmpty()) {
			throw new GoldfishException("Please fill all the fields.");
		}
		else {
			return this.factory.createActivityCategory(name, shortDescription, detailledDescription);
		}
		
	}
	
	public Integer updateActivityCategory(Integer id, String name, String shortDescription, String detailledDescription) throws GoldfishException {
		if(name.isEmpty() || shortDescription.isEmpty() || detailledDescription.isEmpty()) {
			throw new GoldfishException("Please fill all the fields.");
		}
		else {
			return this.factory.updateActivityCategory(id, name, shortDescription, detailledDescription);
		}
	}
	
	public Integer deleteActivityCategory(Integer id) throws GoldfishException {
		return this.factory.deleteActivityCategory(id);
	}
	
	public ActivityCategory findActivityCategoryById(Integer id){
		return this.factory.getActivityCategoryById(id);
	}
	
	public Collection<ActivityCategory> findAllActivitiesCategories(){
		return this.factory.getAllActivitiesCategories();
	}

}
