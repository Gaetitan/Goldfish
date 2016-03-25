package com.polytech.goldfish.businesslogic.factory;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.DiaryEntry;
import com.polytech.goldfish.util.GoldfishException;



/**
 * @author RedaM
 *
 */
public abstract class DiaryFactory {

	public abstract Integer createEntry(String name, Date date, Time time, boolean visibility) throws GoldfishException;

	public abstract Integer updateEntry(Integer id, String newName, Date newDate, Time newTime, boolean newVisibility) throws GoldfishException;

	public abstract Integer deleteEntry(Integer id) throws GoldfishException;

	public abstract Collection<DiaryEntry> getAllEntrys();
}