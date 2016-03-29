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
	private static final String queryUpdateOne = "UPDATE seller SET shopname = ?, description = ?, siret = ?, activitydomain = ?, webaddress = ? WHERE idperson = ?;";
	private static final String queryGetSellerById = "SELECT * FROM seller WHERE idperson = ?;";
	private static final String queryDeleteOne = "DELETE FROM seller WHERE idperson = ?;";
	
	// Constructors
	public SellerJDBC(Integer id, String name, String surname,
			String phone_number, String email, String password,
			String shop_name, String description, Integer siret,
			String activity_domain, String web_adress) {
		super(id, name, surname, phone_number, email, password, shop_name, description,
				siret, activity_domain, web_adress);
	}
	
	public SellerJDBC(String shop_name, String description, Integer siret, String activity_domain, String web_adress){
		super(shop_name, description, siret, activity_domain, web_adress);
	}
	
	// Other methods
	public static Integer createSeller(Integer idPerson, String shopname, String description, Integer siret, String activitydomain, String webaddress){
		Integer idToReturn = null;
		
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryInsertOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, idPerson);
			instruction.setString(2, shopname);
			instruction.setString(3, description);
			instruction.setInt(4, siret);
			instruction.setString(5, activitydomain);
			instruction.setString(6, webaddress);

			int affectedRows = instruction.executeUpdate();
			connect.commit();
				
			if(affectedRows == 0){
				throw new SQLException("Creating seller failed, no rows affected.");
			}
				
			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating seller failed, no ID obtained.");
				}
			}
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
	 * This method updates a seller
	 * 
	 * @param id
	 * @param surname
	 * @param name
	 * @param phone_number
	 * @param email
	 * @param street
	 * @param street_number
	 * @param zip_code
	 * @param city
	 * @param shopname
	 * @param description
	 * @param siret
	 * @param activitydomain
	 * @param webaddress
	 * @return the updated Seller's id
	 */
	public static Integer updateSeller(Integer id, String shopname, String description, Integer siret, String activitydomain, String webaddress){
				
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareStatement(queryUpdateOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, shopname);
			instruction.setString(2, description);
			instruction.setInt(3, siret);
			instruction.setString(4, activitydomain);
			instruction.setString(5, webaddress);
			instruction.setInt(6, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			
			if(affectedRows == 0){
				throw new SQLException("Updating a seller failed, no rows affected.");
			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return id;
	}
	
	/**
	 * This method finds a Seller thanks to its id
	 * @param id the Seller's id
	 * @return a Seller
	 */
	public static SellerJDBC findPersonById(Integer id) {
		SellerJDBC seller = null;
		try{
			Connection connect = Connect.getInstance().getConnection();
			
			PreparedStatement instruction = connect.prepareCall(queryGetSellerById);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();
			
			while(rs.next()){
				seller = new SellerJDBC(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return seller;
	}

	public static void deleteOne(Integer idPerson) {
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryDeleteOne);
			instruction.setInt(1, idPerson);

			int affectedRows = instruction.executeUpdate();
				
			if(affectedRows == 0){
				throw new SQLException("Deleting seller failed, no rows affected.");
			}
			
			connect.commit();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
	}
}
