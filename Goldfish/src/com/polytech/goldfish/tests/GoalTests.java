package com.polytech.goldfish.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.polytech.goldfish.persistence.jdbc.GoalJDBC;

public class GoalTests {
	
	protected GoalJDBC goalJDBC;
	
	@Before
	public void setUp(){
		goalJDBC = new GoalJDBC();
	}

	@After
	public void tearDown(){
		
	}
	
	@Test
	public void test() {
		String name = "regime";
		String description = "perdre 5 kilos";
		Date deadline = Date.valueOf("2016-03-31");
		Date date_creation = Date.valueOf("2016-03-25");
		
		goalJDBC.setName(name);
		goalJDBC.setDescription(description);
		goalJDBC.setDeadline(deadline);
		goalJDBC.setDate_creation(date_creation);
		
		assertNotNull(goalJDBC);
		assertEquals(name, goalJDBC.getName());
		assertEquals(description, goalJDBC.getDescription());
		assertEquals(deadline, goalJDBC.getDeadline());
		assertEquals(date_creation, goalJDBC.getDate_creation());
	}

}
