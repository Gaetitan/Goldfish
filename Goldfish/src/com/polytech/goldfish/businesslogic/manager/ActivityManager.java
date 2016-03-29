package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Activity;
import com.polytech.goldfish.businesslogic.factory.ActivityFactory;
import com.polytech.goldfish.persistence.factoryjdbc.ActivityFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;

/**
 * This class allows a user to create a new activity
 * 
 * @author Pierre Laborde
 *
 */
public class ActivityManager {
	
	private static final Integer Integer = null;
	private final ActivityFactory factory;
	
	public ActivityManager(){
		this.factory = new ActivityFactoryJDBC();
	}
	
	public Integer createActivity(String name, String description, Integer id) throws GoldfishException {
		if(name.isEmpty() || description.isEmpty()) {
			throw new GoldfishException("Please fill all the fields.");
		}
		else {
			return this.factory.createActivity(name, description, id);
		}
		
	}
	
	public Integer updateActivity(Integer id, String name, String description) throws GoldfishException {
		if(name.isEmpty() || description.isEmpty()) {
			throw new GoldfishException("Please fill all the fields.");
		}
		else {
			return this.factory.updateActivity(id, name, description);
		}
	}
	
	public Integer deleteActivity(Integer id) throws GoldfishException {
			return this.factory.deleteActivity(id);
	}
	
	public Activity findActivityById(Integer id){
		return this.factory.getActivityById(id);
	}
	
	public Collection<Activity> findAllActivities(){
		return this.factory.getAllActivities();
	}
	
	public Collection<Activity> findAllActivitiesOfAnUser(Integer id){
		return this.factory.getAllActivitiesOfAnUser(id);
	}
}
