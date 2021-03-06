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
	
	private static final Integer Integer = null;

	@Override
	public Integer createActivity(String name, String description, Integer id) {
		return ActivityJDBC.createActivity(name, description, id);
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
	public Integer deleteActivity(Integer id) {
		return ActivityJDBC.deleteActivity(id);
	}
	
	@Override
	public Collection<Activity> getAllActivities() {
		// Creation of a collection of Activities
		Collection<ActivityJDBC> listActivitiesJDBC = ActivityJDBC.findAllActivities();
		Collection<Activity> listActivities = new ArrayList<Activity>();
		
		// Put the ActivityJDBC as Activity in a new list
		for(Activity activity : listActivitiesJDBC) {
			listActivities.add(activity);
		}

		// Return the new list
		return listActivities;
	}
	
	@Override
	public Collection<Activity> getAllActivitiesOfAnUser(Integer id) {
		// Creation of a collection of Activities
		Collection<ActivityJDBC> listActivitiesJDBC = ActivityJDBC.findAllActivitiesOfAnUser(id);
		Collection<Activity> listActivities = new ArrayList<Activity>();
		
		// Put the ActivityJDBC as Activity in a new list
		for(Activity activity : listActivitiesJDBC) {
			listActivities.add(activity);
		}

		// Return the new list
		return listActivities;
	}
}
