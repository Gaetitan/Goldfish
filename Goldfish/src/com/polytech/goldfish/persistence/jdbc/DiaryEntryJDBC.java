package com.polytech.goldfish.persistence.jdbc;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.DiaryEntry;

/**
 * Persistence class for a DiaryEntry
 * @author Ga�tan FRAN�OIS
 *
 */
public class DiaryEntryJDBC extends DiaryEntry {

	// Queries
	private static final String queryDeleteEntryById = "DELETE FROM comment WHERE idcomment = ?;";
	private static final String queryInsertEntry = "INSERT INTO comment (text, date) VALUES(?,?);";
	private static final String queryGetAllEntrys = "SELECT * FROM comment;";
	private static final String queryUpdateEntry = "UPDATE comment SET text = ?, date = ? WHERE idcomment = ?;";	
	// TODO WRITE REAL QUERIES
	// Constructors
	public DiaryEntryJDBC(Integer id, String name, Date date, Time time,
			boolean visibility) {
		super(id, name, date, time, visibility);
	}

	public static Integer createEntry(String name, Date date, Time time, Boolean visibility) {
		return null;
	}

	public static Collection<DiaryEntryJDBC> findAllDiarys() {
		return null;
	}

	public static Integer updateEntry(Integer id, String newName, Date newDate, Time newTime, Boolean newVisibility) {
		return null;
	}

	public static Integer deleteEntry(Integer id) {
		return null;
	}
}