package com.polytech.goldfish.persistence.factoryjdbc;

import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Activity;
import com.polytech.goldfish.businesslogic.factory.ActivityFactory;
import com.polytech.goldfish.persistence.jdbc.ActivityJDBC;

/**
 * This class creates the activities used in the application
 * 
 * @author Pierre Laborde
 *
 */
public class ActivityFactoryJDBC extends ActivityFactory {
	
	@Override
	public Integer createActivity(String name, String description) {
		return ActivityJDBC.createActivity(name, description);
	}

	@Override
	public Activity getActivityById(Integer id) {
		return ActivityJDBC.findActivityById(id);
	}
	
	@Override
	public Integer updateActivity(Integer id, String name, String description) {
		return ActivityJDBC.updateActivity(id, name, description);
	}
	
	@Override
	public Collection<Activity> getAllActivities() {
		// Creation of a collection of Activities
		Collection<Activity> listActivities = new ArrayList<Activity>();
		
		// Put the ActivityJDBC as Activity in a new list
		for(Activity activity : ActivityJDBC.findAllActivities()) {
			listActivities.add(activity);
		}

		// Return the new list
		return listActivities;
	}
}
