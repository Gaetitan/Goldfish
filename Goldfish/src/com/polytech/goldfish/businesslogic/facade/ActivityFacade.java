package com.polytech.goldfish.businesslogic.facade;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Activity;
import com.polytech.goldfish.businesslogic.manager.ActivityManager;
import com.polytech.goldfish.util.GoldfishException;

/**
 * Facade for an Activity
 * 
 * @author Pierre Laborde
 *
 */
public class ActivityFacade {
	
	private final ActivityManager activityManager;
	
	public ActivityFacade(){
		this.activityManager = new ActivityManager();
	}
	
	public Integer createActivity(String name, String description) throws GoldfishException {
		return this.activityManager.createActivity(name, description);
	}
	
	public Integer updateActivity(Integer id, String name, String description) throws GoldfishException {
		return this.activityManager.updateActivity(id, name, description);
	}
	
	public Integer deleteActivity(Integer id) throws GoldfishException {
		return this.activityManager.deleteActivity(id);
	}
	
	public Activity findActivityById(Integer id){
		return this.activityManager.findActivityById(id);
	}
	
	public Collection<Activity> findAllActivities(){
		return this.activityManager.findAllActivities();
	}
	
	

}
