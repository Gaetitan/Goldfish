package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.polytech.goldfish.util.Connect;

public class HaveAddressJDBC {

	// Queries
	private static final String queryInsertOne = "INSERT INTO haveaddress (idperson, idaddress) VALUES(?,?);";
	private static final String queryDeleteOneFromPerson = "DELETE FROM haveaddress WHERE idPerson = ?;";
	
	// Constructors

	
	// Other methods
	/**
	 * This methods inserts a link between a Person and an Address in the database
	 * @param idPerson the Person's id
	 * @param idAddress the Address' id
	 * @return true if  fields inserted, false otherwise
	 */
	public static boolean insertOne(Integer idPerson, Integer idAddress) {
		boolean bool = false;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idPerson);
			instruction.setInt(2, idAddress);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating connection between person and address failed, no rows affected.");
			}
			else {
				bool = true;
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}	
		
		return bool;
	}
	
	
	public static boolean deleteOneFromPerson(Integer idPerson) {
		boolean bool = false;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryDeleteOneFromPerson);
			instruction.setInt(1, idPerson);
			int affectedRows = instruction.executeUpdate();
			
			if(affectedRows == 0){
				throw new SQLException("Deleting connection between person and address failed, no rows affected.");
			}
			else {
				bool = true;
			}
			connect.commit();
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}	
		
		return bool;
	}
}
