package com.polytech.goldfish.application;

import java.sql.Connection;

import com.polytech.goldfish.util.Connect;


/**
 * This class allows a user to login the application
 * 
 * @author Ga�tan FRAN�OIS
 *
 */
public class Login {
	private Connection connect = Connect.getInstance().getConnection();
	
	public void authenticate(String email, String password){
		
	}
}
