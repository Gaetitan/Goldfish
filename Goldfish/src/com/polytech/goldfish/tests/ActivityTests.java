package com.polytech.goldfish.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.polytech.goldfish.persistence.jdbc.ActivityJDBC;

public class ActivityTests {
	
	protected ActivityJDBC activityJDBC;
	
	@Before
	public void setUp(){
		activityJDBC = new ActivityJDBC();
	}

	@After
	public void tearDown(){
		
	}
	
	@Test
	public void test() {
		String name = "Courir";
		String description = "Course à pied ou à cheval";
		
		activityJDBC.setName(name);
		activityJDBC.setDescription(description);
		
		assertNotNull(activityJDBC);
		assertEquals(name, activityJDBC.getName());
		assertEquals(description, activityJDBC.getDescription());
	}

}
