package com.polytech.goldfish.persistence.jdbc;

import java.sql.Date;
import java.sql.Time;

import com.polytech.goldfish.businesslogic.business.DiaryEntry;

/**
 * Persistence class for a DiaryEntry
 * @author Gaëtan FRANÇOIS
 *
 */
public class DiaryEntryJDBC extends DiaryEntry {

	// Queries
	
	
	// Constructors
	public DiaryEntryJDBC(Integer id, String name, Date date, Time time,
			boolean visibility) {
		super(id, name, date, time, visibility);
	}

	// Other methods
}
