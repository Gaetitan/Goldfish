package com.polytech.goldfish.businesslogic.facade;

import java.sql.Date;
import java.sql.Time;
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
	
	public Integer createComment(String name, Date date, Time time, boolean visibility) throws GoldfishException{
		return diaryManager.createEntry(name, date, time, visibility);
	}
	
	public Integer updateComment(Integer id, String newName, Date newDate, Time newTime, boolean newVisibility) throws GoldfishException{
		return diaryManager.updateEntry(id, newName, newDate, newTime, newVisibility);
	}
	
	public Integer deleteComment(Integer id) throws GoldfishException{
		return diaryManager.deleteEntry(id);
	}
	
	public Collection<DiaryEntry> findAllComments(){
		return diaryManager.findAllEntrys();
	}
}