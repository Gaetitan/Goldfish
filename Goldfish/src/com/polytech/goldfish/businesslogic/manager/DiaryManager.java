package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.DiaryEntry;
import com.polytech.goldfish.businesslogic.factory.DiaryFactory;
import com.polytech.goldfish.persistence.factoryjdbc.DiaryFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;



/**
 * @author RedaM
 *
 */
public class DiaryManager {

	private final DiaryFactory factory;
	private PersonManager person;

	public DiaryManager(){
		this.factory = new DiaryFactoryJDBC();
	}

	public Integer createEntry(Integer idPerson, String name, boolean visibility) throws GoldfishException{
		if(name.isEmpty() || name == ""){
			throw new GoldfishException("Entry cannot be empty.");
		}
		else{
			return this.factory.createEntry(idPerson, name, visibility);	
		}
	}

	public Integer updateEntry(Integer id, String newName, boolean newVisibility) throws GoldfishException{
		if(newName.isEmpty() || newName == ""){
			throw new GoldfishException("Entry cannot be empty.");
		}
		else{
			return this.factory.updateEntry(id, newName, newVisibility);	
		}
	}

	public Integer deleteEntry(Integer id){
		return this.factory.deleteEntry(id);
	}

	public Collection<DiaryEntry> findAllEntrys(){
		return this.factory.getAllEntrys();
	}

	public Collection<DiaryEntry> findEntryByPersonId(Integer idPerson) throws GoldfishException{
		if(person.findPersonById(idPerson) == null){
			throw new GoldfishException("A person must exist.");
		}
		return this.factory.findEntryByPersonId(idPerson);
	}
}