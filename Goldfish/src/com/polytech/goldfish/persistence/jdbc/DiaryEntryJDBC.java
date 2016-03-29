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
	private static final String queryGetEntrysById = "SELECT * FROM DiaryEntry WHERE idperson = ? ;";

	// Constructors
	public DiaryEntryJDBC(Integer id, Integer idPerson, String name, Date date, Time time, boolean visibility) {
		super(id, idPerson, name, date, time, visibility);
	}

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
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;
	}

	public static Collection<DiaryEntryJDBC> findEntryByPersonId(Integer idPerson){
		Collection<DiaryEntryJDBC> listEntrysPerson = null;
		try{
			listEntrysPerson = new ArrayList<DiaryEntryJDBC>();

			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(queryGetEntrysById);
			instruction.setInt(1, idPerson);
			ResultSet rs = instruction.executeQuery();

			while(rs.next()){
				listEntrysPerson.add(new DiaryEntryJDBC(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getTime(5), rs.getBoolean(6)));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}

		return listEntrysPerson;
	}
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
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}

		return listEntrys;
	}

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
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return idToReturn;
	}

	public static Integer deleteEntry(Integer id) {
		Integer idToReturn = null;

		try{
			Connection connect = Connect.getInstance().getConnection();
			PreparedStatement instruction = connect.prepareStatement(queryDeleteEntryById, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);

			// Delete Entry from databse
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			if(affectedRows == 0){
				throw new SQLException("Deleting entry failed, no rows affected.");
			}	
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Deleting entry failed, no ID obtained.");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;
	}
}