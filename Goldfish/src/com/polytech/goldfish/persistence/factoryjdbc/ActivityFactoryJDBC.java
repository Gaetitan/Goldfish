package com.polytech.goldfish.persistence.factoryjdbc;

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
	public int createActivity(String name, String description) {
		return ActivityJDBC.createActivity(name, description);
	}

	@Override
	public Activity getActivityById(Integer id) {
		return ActivityJDBC.findActivityById(id);
	}
}
