package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.polytech.goldfish.businesslogic.business.Administrator;
import com.polytech.goldfish.util.Connect;

/**
 * Persitence class for an Administrator
 * @author Ga�tan FRAN�OIS
 *
 */
public class AdministratorJDBC extends Administrator {

	// Queries
	private static final String queryInsertOne = "INSERT INTO admin (idperson) VALUES(?);";
	private static final String queryDeleteOne = "DELETE FROM admin WHERE idperson = ?;";
	
	// Constructors
	public AdministratorJDBC(Integer id, String name, String surname,
			String phone_number, String email, String password) {
		super(id, name, surname, phone_number, email, password);
	}
	
	// Other methods
	public static Integer createAdministrator(Integer idPerson){
		Integer idToReturn = null;
		
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idPerson);

			int affectedRows = instruction.executeUpdate();
			connect.commit();
				
			if(affectedRows == 0){
				throw new SQLException("Creating administrator failed, no rows affected.");
			}
				
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating administrator failed, no ID obtained.");
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

	public static void deleteOne(Integer idPerson) {
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryDeleteOne);
			instruction.setInt(1, idPerson);

			int affectedRows = instruction.executeUpdate();
				
			if(affectedRows == 0){
				throw new SQLException("Deleting administrator failed, no rows affected.");
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
	}

}
