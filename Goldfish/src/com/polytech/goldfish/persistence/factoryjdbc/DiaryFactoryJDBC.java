package com.polytech.goldfish.persistence.factoryjdbc;

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
	public Integer createEntry(Integer idPerson, String name, boolean visibility) {
		return DiaryEntryJDBC.createEntry(idPerson, name, visibility);
	}

	@Override
	public Collection<DiaryEntry> getAllEntrys() {
		// Creation of a collection of Diarys
		Collection<DiaryEntryJDBC> listDiarysJDBC = DiaryEntryJDBC.findAllEntrys();
		Collection<DiaryEntry> listDiarys = new ArrayList<DiaryEntry>();

		// Put the DiaryJDBC as Diary in a new list
		for(DiaryEntry entry : listDiarysJDBC) {
			listDiarys.add(entry);
		}

		// Return the new list
		return listDiarys;
	}

	@Override
	public Integer updateEntry(Integer id, String newName, boolean newVisibility) throws GoldfishException {
		return DiaryEntryJDBC.updateEntry(id, newName, newVisibility);
	}

	@Override
	public boolean deleteEntry(Integer id) {
		return DiaryEntryJDBC.deleteEntry(id);
	}

	@Override
	public Collection<DiaryEntry> findEntryByPersonId(Integer idPerson){
		// Creation of a collection of Diarys
		Collection<DiaryEntryJDBC> listDiarysJDBC = DiaryEntryJDBC.findEntryByPersonId(idPerson);
		Collection<DiaryEntry> listDiarys = new ArrayList<DiaryEntry>();

		// Put the DiaryJDBC as Diary in a new list
		for(DiaryEntry entry : listDiarysJDBC) {
			listDiarys.add(entry);
		}
		// Return the new list
		return listDiarys;
	}

	@Override
	public DiaryEntry findEntryById(Integer idEntry) {
		return DiaryEntryJDBC.findEntryById(idEntry);
	}
}
