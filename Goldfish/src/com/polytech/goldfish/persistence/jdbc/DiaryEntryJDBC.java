package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.DiaryEntry;
import com.polytech.goldfish.util.Connect;

/**
 * @author RedaM
 *
 */
public class DiaryEntryJDBC extends DiaryEntry {

	// Queries
	private static final String queryDeleteEntryById = "DELETE FROM DiaryEntry WHERE identry = ?;";
	private static final String queryInsertEntry = "INSERT INTO DiaryEntry (idperson, name, date, time, visibility) VALUES(?,?,?,?,?);";
	private static final String queryGetAllEntrys = "SELECT * FROM DiaryEntry;";
	private static final String queryUpdateEntry = "UPDATE DiaryEntry SET name = ?, date = ?, time= ?, visibility = ? WHERE identry = ?;";
	private static final String queryGetEntrysByIdPerson = "SELECT * FROM DiaryEntry WHERE idperson = ? ;";
	private static final String queryGetEntrysByIdEntry = "SELECT * FROM DiaryEntry WHERE identry = ? ;";

	// Constructors
	public DiaryEntryJDBC(Integer id, Integer idPerson, String name, Date date, Time time, boolean visibility) {
		super(id, idPerson, name, date, time, visibility);
	}



	// Other methods

	public DiaryEntryJDBC() {
		super();
	}



	/**
	 * <p>
	 * Does insert an entry in the database
	 * </p>
	 * @param idPerson
	 * @param name
	 * @param visibility
	 * @return the id of the newly created entry
	 */
	public static Integer createEntry(Integer idPerson, String name, Boolean visibility) {
		Integer idToReturn = null;

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
		try{
			Connection connect = Connect.getInstance().getConnection();
			PreparedStatement instruction = connect.prepareStatement(queryInsertEntry, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idPerson);
			instruction.setString(2, name);
			instruction.setDate(3, sqlDate);
			instruction.setTime(4, sqlTime);
			instruction.setBoolean(5, visibility);

			// Insert Entry in databse
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			if(affectedRows == 0){
				throw new SQLException("Creating entry failed, no rows affected.");
			}	
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating entry failed, no ID obtained.");
				}
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;
	}

	/**
	 * <p>
	 * Find entrys of a person thanks to his id
	 * </p>
	 * @param idPerson
	 * @return a collection of entrys
	 */
	public static Collection<DiaryEntryJDBC> findEntryByPersonId(Integer idPerson){
		Collection<DiaryEntryJDBC> listEntrysPerson = null;
		try{
			listEntrysPerson = new ArrayList<DiaryEntryJDBC>();

			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(queryGetEntrysByIdPerson);
			instruction.setInt(1, idPerson);
			ResultSet rs = instruction.executeQuery();

			while(rs.next()){
				listEntrysPerson.add(new DiaryEntryJDBC(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getTime(5), rs.getBoolean(6)));
			}	
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}

		return listEntrysPerson;
	}

	/**
	 * <p>
	 * Does find all the entrys in the database
	 * </p>
	 * @return a collection of entrys
	 */
	public static Collection<DiaryEntryJDBC> findAllEntrys() {
		Collection<DiaryEntryJDBC> listEntrys = null;
		try{
			listEntrys = new ArrayList<DiaryEntryJDBC>();

			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(queryGetAllEntrys);
			ResultSet rs = instruction.executeQuery();

			while(rs.next()){
				listEntrys.add(new DiaryEntryJDBC(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getTime(5), rs.getBoolean(6)));
			}	
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}

		return listEntrys;
	}

	/**
	 * <p>
	 * Does update an entry in the the database thanks to the ID of entry
	 * </p>
	 * @param id
	 * @param newName
	 * @param newVisibility
	 * @return the id on the entry 
	 */
	public static Integer updateEntry(Integer id, String newName, Boolean newVisibility) {
		Integer idToReturn = null;

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
		try{
			Connection connect = Connect.getInstance().getConnection();
			PreparedStatement instruction = connect.prepareStatement(queryUpdateEntry, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, newName);
			instruction.setDate(2, sqlDate);
			instruction.setTime(3, sqlTime);
			instruction.setBoolean(4, newVisibility);
			instruction.setInt(5, id);

			// Update Entry in databse
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			if(affectedRows == 0){
				throw new SQLException("Updating entry failed, no rows affected.");
			}	
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Updating entry failed, no ID obtained.");
				}
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return idToReturn;
	}

	/**
	 * <p>
	 * Does delete an entry in the database
	 * </p>
	 * @param id
	 * @return true if the deletion has been done, false otherwise
	 */
	public static boolean deleteEntry(Integer id) {
		boolean deleted = false;

		try{
			Connection connect = Connect.getInstance().getConnection();
			PreparedStatement instruction = connect.prepareStatement(queryDeleteEntryById, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);

			// Delete Entry from databse
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			deleted = true;
			if(affectedRows == 0){
				throw new SQLException("Deleting entry failed, no rows affected.");
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return deleted;
	}



	public static DiaryEntry findEntryById(Integer idEntry) {
		DiaryEntryJDBC entryById = null;
		try{

			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(queryGetEntrysByIdEntry);
			instruction.setInt(1, idEntry);
			ResultSet rs = instruction.executeQuery();

			rs.next();
			entryById = new DiaryEntryJDBC(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getTime(5), rs.getBoolean(6));	
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}

		return entryById;
	}
}