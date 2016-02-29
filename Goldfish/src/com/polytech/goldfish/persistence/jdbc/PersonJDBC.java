package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.util.Connect;

public class PersonJDBC extends Person {

	private static final String queryLogin = "SELECT * FROM login WHERE email = ?;";
	
	public PersonJDBC(Integer id, String email, String password) {
		super(id, email, password);
	}

	public static PersonJDBC findPersonByLogin(String email, String password) {
		PersonJDBC person = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryLogin);
			instruction.setString(1, email);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				if(rs.getString(3).equals(password)){
					person = new PersonJDBC(rs.getInt(1), rs.getString(2), rs.getString(3));
				}
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return person;
	}
	
}
