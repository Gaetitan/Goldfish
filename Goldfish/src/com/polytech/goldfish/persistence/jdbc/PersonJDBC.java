package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.util.Connect;

/**.
 * Persitence class for a Person
 * @author Gaëtan FRANÇOIS
 *
 */
public class PersonJDBC extends Person {

	// Queries
	private static final String queryLogin = "SELECT * FROM person WHERE email = ?;";
	
	// Constructors
	public PersonJDBC(Integer id, String name, String surname, String phone_number, String email, String password) {
		super(id, name, surname, phone_number, email, password);
	}

	// Other methods
	/**
	 * This methods finds a Person in the database thanks to his login information
	 * 
	 * @param email the Person's email
	 * @param password the Person's password
	 * @return the Person found in the database with his information
	 */
	public static PersonJDBC findPersonByLogin(String email, String password) {
		PersonJDBC person = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryLogin);
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
	
}
