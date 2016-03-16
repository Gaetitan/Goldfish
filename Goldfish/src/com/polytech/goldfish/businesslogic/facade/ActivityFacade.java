package com.polytech.goldfish.businesslogic.facade;

import com.polytech.goldfish.businesslogic.business.Activity;
import com.polytech.goldfish.businesslogic.manager.ActivityManager;

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
	
	public int createActivity(String name, String description){
		return this.activityManager.createActivity(name, description);
	}
	
	public Activity findActivityById(Integer id){
		return this.activityManager.findActivityById(id);
	}

}
