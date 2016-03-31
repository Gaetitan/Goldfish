package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.polytech.goldfish.businesslogic.business.Address;
import com.polytech.goldfish.util.Connect;

/**
 * Persistence class for an Adress
 * @author Ga�tan FRAN�OIS
 *
 */
public class AddressJDBC extends Address{

	// Queries
	private static final String queryGetAddressById = "SELECT * FROM address WHERE idaddress = ?;";
	private static final String queryInsertOne = "INSERT INTO address (street, numstreet, postalcode, city) VALUES(?,?,?,?);";
	//private static final String queryGetAddressOfAPerson = "SELECT * FROM address a, haveaddress h, person p WHERE a.idaddress = h.id address AND h.idperson = a.idperson AND idperson = ?;";
	private static final String queryUpdateOne = "UPDATE address SET street = ?, numstreet = ?, postalcode = ?, city = ? WHERE idaddress = ?;";
	
	// Constructors
	public AddressJDBC(Integer id, String street, Integer street_number, Integer zip_code,
			String city) {
		super(id, street, street_number, zip_code, city);
	}
	
	// Other methods
	/**
	 * This methods finds an Address in the database thanks to its id
	 * @param id
	 * @return the Address which has the looked for id
	 */
	public static AddressJDBC findAddressById(Integer id) {
		AddressJDBC address = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetAddressById);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				address = new AddressJDBC(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}	
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return address;
	}
	
	/**
	 * This method inserts an Address in the database
	 * @param street
	 * @param street_number
	 * @param zip_code
	 * @param city
	 * @return the id the new Adress
	 */
	public static int createAddress(String street, Integer street_number, Integer zip_code, String city) {
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, street);
			instruction.setInt(2, street_number);
			instruction.setInt(3, zip_code);
			instruction.setString(4, city);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating address failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating address failed, no ID obtained.");
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
	 * This methods finds an Address in the database thanks to its id
	 * @param id
	 * @return the Address which has the looked for id
	 */
	public static AddressJDBC findAddressOfAPerson(Integer idPerson) {
		AddressJDBC address = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetAddressById);
			instruction.setInt(1, idPerson);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				address = new AddressJDBC(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}	
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return address;
	}
	
	public static Integer updateAddress(Integer id, String street, Integer street_number, Integer zip_code, String city){
		
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryUpdateOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, street);
			instruction.setInt(2, street_number);
			instruction.setInt(3, zip_code);
			instruction.setString(4, city);
			instruction.setInt(5, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Updating a person failed, no rows affected.");
			}
			connect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return id;
	}
}
