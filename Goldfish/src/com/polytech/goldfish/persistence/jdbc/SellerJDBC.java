package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.polytech.goldfish.businesslogic.business.Seller;
import com.polytech.goldfish.util.Connect;

/**
 * Persistence class for a Seller
 * @author Gaëtan FRANÇOIS
 *
 */
public class SellerJDBC extends Seller {

	// Queries
	private static final String queryInsertOne = "INSERT INTO seller (idperson, shopname, description, siret, activitydomain, webaddress) VALUES(?,?,?,?,?,?);";
	
	// Constructors
	public SellerJDBC(Integer id, String name, String surname,
			String phone_number, String email, String password,
			String shop_name, String description, String siret,
			String activity_domain, String web_adress) {
		super(id, name, surname, phone_number, email, password, shop_name, description,
				siret, activity_domain, web_adress);
	}
	
	// Other methods
	public static Integer createSeller(Integer idPerson, String shopname, String description, Integer siret, String activity_domain, String web_address){
		Integer idToReturn = null;
		
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idPerson);
			instruction.setString(2, shopname);
			instruction.setString(3, description);
			instruction.setInt(4, siret);
			instruction.setString(5, activity_domain);
			instruction.setString(6, web_address);

			int affectedRows = instruction.executeUpdate();
			connect.commit();
				
			if(affectedRows == 0){
				throw new SQLException("Creating user failed, no rows affected.");
			}
				
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return idToReturn;	
	}
}
