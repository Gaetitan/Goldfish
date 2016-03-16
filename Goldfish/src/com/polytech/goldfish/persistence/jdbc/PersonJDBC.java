package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.util.Connect;

/**
 * Persistence class for a Person
 * @author Gaëtan FRANÇOIS
 *
 */
public class PersonJDBC extends Person {

	// Queries
	private static final String queryGetPersonByEmail = "SELECT * FROM person WHERE email = ?;";
	private static final String queryGetPersonById = "SELECT * FROM person WHERE idperson = ?;";
	private static final String queryInsertOne = "INSERT INTO person (surname, name, phonenumber, email, password) VALUES(?,?,?,?,?);";
	
	// Constructors
	public PersonJDBC(Integer id, String surname, String name, String phone_number, String email, String password) {
		super(id, surname, name, phone_number, email, password);
	}

	// Other methods
	/**
	 * This methods finds a Person in the database thanks to its login information
	 * 
	 * @param email the Person's email
	 * @param password the Person's password
	 * @return the Person found in the database with his information
	 */
	public static PersonJDBC findPersonByLogin(String email, String password) {
		PersonJDBC person = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetPersonByEmail);
			instruction.setString(1, email);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				if(rs.getString(6).equals(password)){
					person = new PersonJDBC(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				}
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return person;
	}
	
	
	/**
	 * This methods inserts a Person in the database
	 * @param surname
	 * @param name
	 * @param phone_number
	 * @param email
	 * @param password
	 * @return 
	 * @return the new Person
	 */
	public static int createPerson(String surname, String name, String phone_number, String email, String password) {
		int idToReturn = -1;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, surname);
			instruction.setString(2, name);
			instruction.setString(3, phone_number);
			instruction.setString(4, email);
			instruction.setString(5, password);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Creating person failed, no rows affected.");
			}
			
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating person failed, no ID obtained.");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;
		
		
	}
	
	/**
	 * This method finds a Person thanks to its email
	 * @param email
	 * @return a Person
	 */
	public static PersonJDBC findPersonByEmail(String email) {
		PersonJDBC person = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetPersonByEmail);
			instruction.setString(1, email);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				person = new PersonJDBC(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return person;
	}
	
	/**
	 * This method finds a Person thanks to its id
	 * @param id the Person's id
	 * @return a Person
	 */
	public static PersonJDBC findPersonById(Integer id) {
		PersonJDBC person = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetPersonById);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				person = new PersonJDBC(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return person;
	}
	
}
