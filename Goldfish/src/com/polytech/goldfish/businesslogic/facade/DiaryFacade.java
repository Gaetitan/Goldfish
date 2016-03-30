package com.polytech.goldfish.businesslogic.facade;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.DiaryEntry;
import com.polytech.goldfish.businesslogic.manager.DiaryManager;
import com.polytech.goldfish.util.GoldfishException;

/**
 * @author RedaM
 *
 */
public class DiaryFacade {

	private static DiaryManager diaryManager;
	
	public DiaryFacade(){
		DiaryFacade.diaryManager = new DiaryManager();
	}
	
	public Integer createEntry(Integer idPerson, String name, boolean visibility) throws GoldfishException{
		return diaryManager.createEntry(idPerson, name, visibility);
	}
	
	public Integer updateEntry(Integer id, String newName, boolean newVisibility) throws GoldfishException{
		return diaryManager.updateEntry(id, newName, newVisibility);
	}
	
	public Integer deleteEntry(Integer id) throws GoldfishException{
		return diaryManager.deleteEntry(id);
	}
	
	public Collection<DiaryEntry> findEntryByPersonId(Integer idPerson){
		return diaryManager.findEntryByPersonId(idPerson);
	}
	
	public Collection<DiaryEntry> findAllEntrys(){
		return diaryManager.findAllEntrys();
	}
}