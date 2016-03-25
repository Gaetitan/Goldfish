package com.polytech.goldfish.persistence.factoryjdbc;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.DiaryEntry;
import com.polytech.goldfish.businesslogic.factory.DiaryFactory;
import com.polytech.goldfish.persistence.jdbc.DiaryEntryJDBC;
import com.polytech.goldfish.util.GoldfishException;


/**
 * @author RedaM
 *
 */
public class DiaryFactoryJDBC extends DiaryFactory {

	@Override
	public Integer createEntry(String name, Date date, Time time, boolean visibility) {
		return DiaryEntryJDBC.createEntry(name, date, time, visibility);
	}

	@Override
	public Collection<DiaryEntry> getAllEntrys() {
		// Creation of a collection of Diarys
		Collection<DiaryEntryJDBC> listDiarysJDBC = DiaryEntryJDBC.findAllDiarys();
		Collection<DiaryEntry> listDiarys = new ArrayList<DiaryEntry>();
		
		// Put the DiaryJDBC as Diary in a new list
		for(DiaryEntry entry : listDiarysJDBC) {
			listDiarys.add(entry);
		}

		// Return the new list
		return listDiarys;
	}

	@Override
	public Integer updateEntry(Integer id, String newName, Date newDate, Time newTime, boolean newVisibility) throws GoldfishException {
		return DiaryEntryJDBC.updateEntry(id, newName, newDate, newTime, newVisibility);
	}

	@Override
	public Integer deleteEntry(Integer id) throws GoldfishException {
		return DiaryEntryJDBC.deleteEntry(id);
	}




}
