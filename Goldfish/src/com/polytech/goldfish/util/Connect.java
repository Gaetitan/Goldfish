package com.polytech.goldfish.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class connects the application to a database
 * @author Ga�tan FRAN�OIS
 *
 */
public class Connect {
	private static Connect instance = null;
	private final String driverName = "org.postgresql.Driver";
	private final String url;
	private final String user;
	private final String password;
	
	private Connect() {
		this.url = "jdbc:postgresql://ec2-107-20-153-141.compute-1.amazonaws.com:5432/deo26s6g50b66u?sslmode=require";
		this.user = "neuakxuifmnrfv";
		this.password = "tlK7w4GuufFaIzOyvaoTmu8KkK";
		try{
			Class.forName(this.driverName);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static synchronized Connect getInstance(){
		if(instance == null){
			instance = new Connect();
		}
		return instance;
	}
	
	/**
	 * This method allows the connection to the database
	 * 
	 * @return the connection to the database
	 */
	public Connection getConnection(){
		Connection connection = null;
		try{
			connection = DriverManager.getConnection(this.url, this.user, this.password);
			connection.setAutoCommit(false);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeConnection(){
		try {
			this.getConnection().close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}