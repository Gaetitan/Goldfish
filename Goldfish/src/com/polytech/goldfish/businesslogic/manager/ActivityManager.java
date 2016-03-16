package com.polytech.goldfish.businesslogic.manager;

import com.polytech.goldfish.businesslogic.business.Activity;
import com.polytech.goldfish.businesslogic.factory.ActivityFactory;
import com.polytech.goldfish.persistence.factoryjdbc.ActivityFactoryJDBC;

/**
 * This class allows a user to create a new activity
 * 
 * @author Pierre Laborde
 *
 */
public class ActivityManager {
	private final ActivityFactory factory;
	
	public ActivityManager(){
		this.factory = new ActivityFactoryJDBC();
	}
	
	public int createActivity(String name, String description){
		return this.factory.createActivity(name, description);
	}
	
	public Activity findActivityById(Integer id){
		return this.factory.getActivityById(id);
	}
}
