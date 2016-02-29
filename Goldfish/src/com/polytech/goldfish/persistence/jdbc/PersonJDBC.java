package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.polytech.goldfish.util.Connect;

public class PersonJDBC {

	private static final String queryLogin = "SELECT * FROM login WHERE email = ?;";
	
	public PersonJDBC(){}
	
	public boolean queryLogin(String email, String password) {
		boolean bool = false;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryLogin);
			instruction.setString(1, email);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				if(rs.getString(3).equals(password)){
					bool = true;
				}
				else{
					bool = false;
				}
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return bool;
	}
	
}
