package com.polytech.goldfish.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.Time;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.polytech.goldfish.persistence.jdbc.DiaryEntryJDBC;

public class DiaryEntryTests {
	
	protected DiaryEntryJDBC diaryEntryJDBC;
	
	@Before
	public void setUp(){
		diaryEntryJDBC = new DiaryEntryJDBC();
	}

	@After
	public void tearDown(){
		
	}
	
	@Test
	public void test() {
		String name = "J'ai couru 42 km";
		
		Date date = Date.valueOf("2016-03-31");
		Time time = Time.valueOf("20:20:20");
		
		Boolean visibility = true;
				
		diaryEntryJDBC.setName(name);
		diaryEntryJDBC.setDate(date);
		diaryEntryJDBC.setTime(time);
		diaryEntryJDBC.setVisibility(visibility);
		
		assertNotNull(diaryEntryJDBC);
		assertEquals(name, diaryEntryJDBC.getName());
		assertEquals(date, diaryEntryJDBC.getDate());
		assertEquals(time, diaryEntryJDBC.getTime());
		assertEquals(visibility, diaryEntryJDBC.getVisibility());
	}

}
