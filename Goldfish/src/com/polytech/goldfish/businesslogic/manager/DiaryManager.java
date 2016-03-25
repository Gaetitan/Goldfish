package com.polytech.goldfish.businesslogic.manager;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.DiaryEntry;
import com.polytech.goldfish.businesslogic.factory.DiaryFactory;
import com.polytech.goldfish.persistence.factoryjdbc.DiaryFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;



public class DiaryManager {
	
	private final DiaryFactory factory;
	
	public DiaryManager(){
		this.factory = new DiaryFactoryJDBC();
	}
	
	public Integer createEntry(String name, Date date, Time time, boolean visibility) throws GoldfishException{
		if(name.isEmpty() || name == ""){
			throw new GoldfishException("Entry cannot be empty.");
		}
		else{
			return this.factory.createEntry(name, date, time, visibility);	
		}
	}

	public Integer updateEntry(Integer id, String newName, Date newDate, Time newTime, boolean newVisibility) throws GoldfishException{
		if(newName.isEmpty() || newName == ""){
			throw new GoldfishException("Entry cannot be empty.");
		}
		else{
			return this.factory.updateEntry(id, newName, newDate, newTime, newVisibility);	
		}
	}

	public Integer deleteEntry(Integer id) throws GoldfishException{
		return this.factory.deleteEntry(id);
	}

	public Collection<DiaryEntry> findAllEntrys(){
		return this.factory.getAllEntrys();
	}
}