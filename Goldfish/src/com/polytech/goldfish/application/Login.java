package com.polytech.goldfish.application;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.polytech.goldfish.presentation.FrameLogin;
import com.polytech.goldfish.util.Connect;


/**
 * This class allows a user to login the application
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class Login {
	
	private static final String queryLogin = "SELECT * FROM login WHERE email = ?;";
	
	public static boolean authenticate(String email, String password){
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
	
	public static void main (String[] args){
	    if(authenticate("gaetitan@gmail.com", "leswagdu34")){
	    	System.out.println("Connection OK!");
	    }
	    else{
	    	System.out.println("Incorrect email/password.");
	    }
	}
	
}
