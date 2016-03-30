package com.polytech.goldfish.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.polytech.goldfish.persistence.jdbc.ActivityCategoryJDBC;

public class ActivityCategoryTests {
	
	protected ActivityCategoryJDBC activityCategoryJDBC;
	
	@Before
	public void setUp(){
		activityCategoryJDBC = new ActivityCategoryJDBC();
	}

	@After
	public void tearDown(){
		
	}
	
	@Test
	public void test() {
		String name = "Courir";
		String short_description = "Course à pied";
		String detailed_description = "Action de mettre un pied devant l'autre très vite !";
		
		activityCategoryJDBC.setName(name);
		activityCategoryJDBC.setShort_description(short_description);
		activityCategoryJDBC.setDetailed_description(detailed_description);
		
		assertNotNull(activityCategoryJDBC);
		assertEquals(name, activityCategoryJDBC.getName());
		assertEquals(short_description, activityCategoryJDBC.getShort_description());
		assertEquals(detailed_description, activityCategoryJDBC.getDetailed_description());
	}

}
