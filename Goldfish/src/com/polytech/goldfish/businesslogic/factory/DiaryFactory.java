package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.DiaryEntry;
import com.polytech.goldfish.util.GoldfishException;



/**
 * @author RedaM
 *
 */
public abstract class DiaryFactory {

	public abstract Integer createEntry(Integer idPerson, String name, boolean visibility) throws GoldfishException;

	public abstract Integer updateEntry(Integer id, String newName, boolean newVisibility) throws GoldfishException;

	public abstract boolean deleteEntry(Integer id);

	public abstract Collection<DiaryEntry> getAllEntrys();

	public abstract Collection<DiaryEntry> findEntryByPersonId(Integer idPerson);
}