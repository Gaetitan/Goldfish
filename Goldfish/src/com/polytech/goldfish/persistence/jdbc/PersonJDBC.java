package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Person;
import com.polytech.goldfish.util.Connect;
import com.polytech.goldfish.util.GoldfishException;
import com.polytech.goldfish.util.Passwords;

/**
 * Persistence class for a Person
 * 
 * @author Ga�tan FRAN�OIS
 * 
 */
public class PersonJDBC extends Person {

	// Queries
	private static final String queryGetPersonByEmail = "SELECT * FROM person WHERE email = ?;";
	private static final String queryGetPersonById = "SELECT * FROM person WHERE idperson = ?;";
	private static final String queryInsertOne = "INSERT INTO person (surname, name, phonenumber, email, password, salt) VALUES(?,?,?,?,?,?);";
	private static final String queryGetAllPersons = "SELECT * FROM person;";
	private static final String queryUpdateOne = "UPDATE person SET surname = ?, name = ?, phonenumber = ?, email = ? WHERE idperson = ?;";
	private static final String queryGetUserById = "SELECT * FROM \"user\" u, person p WHERE u.idperson=p.idperson AND p.idperson = ?;";
	private static final String queryGetAdministratorById = "SELECT * FROM admin a, person p WHERE a.idperson=p.idperson AND p.idperson = ?;";
	private static final String queryGetSellerById = "SELECT * FROM seller s, person p WHERE s.idperson=p.idperson AND p.idperson = ?;";
	private static final String queryDeleteOne = "DELETE FROM person WHERE idPerson = ?;";

	// Constructors
	public PersonJDBC(Integer id, String surname, String name,
			String phone_number, String email, String password) {
		super(id, surname, name, phone_number, email, password);
	}

	// Other methods
	/**
	 * This methods finds a Person in the database thanks to its login
	 * information
	 * 
	 * @param email
	 *            the Person's email
	 * @param password
	 *            the Person's password
	 * @return the Person found in the database with his information
	 */
	public static PersonJDBC findPersonByLogin(String email, String password) {
		PersonJDBC person = null;
		try {
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect
					.prepareCall(queryGetPersonByEmail);
			instruction.setString(1, email);
			ResultSet rs = instruction.executeQuery();

			while (rs.next()) {
				if (Passwords.isExpectedPassword(password.toCharArray(),
						rs.getBytes(7), rs.getBytes(6))) {
					person = new PersonJDBC(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6));
				}
			}
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.getInstance().closeConnection();
		}
		return person;
	}

	/**
	 * This methods inserts a Person in the database
	 * 
	 * @param surname
	 * @param name
	 * @param phone_number
	 * @param email
	 * @param password
	 * @return
	 * @return the id the new Person
	 * @throws GoldfishException
	 */
	public static Integer createPerson(Object typePerson, String surname,
			String name, String phone_number, String email, String password,
			String street, Integer street_number, Integer zip_code,
			String city, String shopname, String description, Integer siret,
			String activitydomain, String webaddress) throws GoldfishException {
		Integer idToReturn = null;

		// salt to mix with password
		byte[] salt = Passwords.getNextSalt();

		try {
			Connection connect = Connect.getInstance().getConnection();

			// Verifying if a Person using the email already exists
			if (PersonJDBC.findPersonByEmail(email) != null) {
				throw new GoldfishException(
						"A person with this email already exists.");
			} else {
				PreparedStatement instruction = connect.prepareStatement(
						queryInsertOne, Statement.RETURN_GENERATED_KEYS);
				instruction.setString(1, surname);
				instruction.setString(2, name);
				instruction.setString(3, phone_number);
				instruction.setString(4, email);
				instruction.setBytes(5,
						Passwords.hash(password.toCharArray(), salt));
				instruction.setBytes(6, salt);

				// Insert Person in database
				int affectedRows = instruction.executeUpdate();
				connect.commit();

				if (affectedRows == 0) {
					throw new SQLException(
							"Creating person failed, no rows affected.");
				}

				try (ResultSet generatedKeys = instruction.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						idToReturn = generatedKeys.getInt(1);
					} else {
						throw new SQLException(
								"Creating person failed, no ID obtained.");
					}
				}
				// Insert Address and link between Person and Address in
				// database
				HaveAddressJDBC.insertOne(idToReturn, AddressJDBC
						.createAddress(street, street_number, zip_code, city));

				// Insert Person as a User or an Administrator
				switch (typePerson.toString()) {
				case "Administrator":
					AdministratorJDBC.createAdministrator(idToReturn);
					break;
				case "User":
					UserJDBC.createUser(idToReturn);
					break;
				case "Seller":
					SellerJDBC.createSeller(idToReturn, shopname, description,
							siret, activitydomain, webaddress);
					break;
				default:
					throw new GoldfishException(
							"Cannot determine type of person.");
				}
				connect.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.getInstance().closeConnection();
		}
		return idToReturn;
	}

	/**
	 * This method updates a Person in the database
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
	 * @return the updated Person's id
	 */
	public static Integer updatePerson(Integer id, String surname, String name,
			String phone_number, String email, String street,
			Integer street_number, Integer zip_code, String city,
			String shopname, String description, Integer siret,
			String activitydomain, String webaddress) {

		try {
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(
					queryUpdateOne, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, surname);
			instruction.setString(2, name);
			instruction.setString(3, phone_number);
			instruction.setString(4, email);
			instruction.setInt(5, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();

			if (affectedRows == 0) {
				throw new SQLException(
						"Updating a person failed, no rows affected.");
			}

			AddressJDBC.updateAddress(AddressJDBC.findAddressOfAPerson(id)
					.getId(), street, street_number, zip_code, city);

			if (shopname != null) {
				SellerJDBC.updateSeller(id, shopname, description, siret,
						activitydomain, webaddress);
			}
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.getInstance().closeConnection();
		}
		return id;
	}

	/**
	 * This method finds a Person thanks to its email
	 * 
	 * @param email
	 * @return a Person
	 */
	public static PersonJDBC findPersonByEmail(String email) {
		PersonJDBC person = null;
		try {
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect
					.prepareCall(queryGetPersonByEmail);
			instruction.setString(1, email);
			ResultSet rs = instruction.executeQuery();

			while (rs.next()) {
				person = new PersonJDBC(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.getInstance().closeConnection();
		}
		return person;
	}

	/**
	 * This method finds a Person thanks to its id
	 * 
	 * @param id
	 *            the Person's id
	 * @return a Person
	 */
	public static PersonJDBC findPersonById(Integer id) {
		PersonJDBC person = null;
		try {
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect
					.prepareCall(queryGetPersonById);
			instruction.setInt(1, id);
			ResultSet rs = instruction.executeQuery();

			while (rs.next()) {
				person = new PersonJDBC(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.getInstance().closeConnection();
		}
		return person;
	}

	/**
	 * This methods get all Persons in the database
	 * 
	 * @return all Persons in the database
	 */
	public static Collection<PersonJDBC> findAllPersons() {
		Collection<PersonJDBC> listPersons = null;
		try {
			listPersons = new ArrayList<PersonJDBC>();

			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect
					.prepareCall(queryGetAllPersons);
			ResultSet rs = instruction.executeQuery();

			while (rs.next()) {
				listPersons.add(new PersonJDBC(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5), rs
								.getString(6)));
			}
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.getInstance().closeConnection();
		}

		return listPersons;
	}

	/**
	 * This method checks if a Person is a User
	 * 
	 * @param idPerson
	 * @return true if the Person is a User, false otherwise
	 */
	public static boolean isUser(Integer idPerson) {
		Integer myId = null;
		boolean bool = false;

		try {
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect
					.prepareCall(queryGetUserById);
			instruction.setInt(1, idPerson);
			ResultSet rs = instruction.executeQuery();
			while (rs.next()) {
				myId = rs.getInt(1);
			}
			bool = myId != null;
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.getInstance().closeConnection();
		}

		return bool;
	}

	/**
	 * This method checks if a Person is an Administrator
	 * 
	 * @param idPerson
	 * @return true if the Person is an Administrator, false otherwise
	 */
	public static boolean isAdministrator(Integer idPerson) {
		Integer myId = null;
		boolean bool = false;

		try {
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect
					.prepareCall(queryGetAdministratorById);
			instruction.setInt(1, idPerson);
			ResultSet rs = instruction.executeQuery();
			while (rs.next()) {
				myId = rs.getInt(1);
			}
			bool = myId != (null);
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.getInstance().closeConnection();
		}

		return bool;
	}

	/**
	 * This method checks if a Person is a Seller
	 * 
	 * @param idPerson
	 * @return true if the Person is a Seller, false otherwise
	 */
	public static boolean isSeller(Integer idPerson) {
		Integer myId = null;
		boolean bool = false;

		try {
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect
					.prepareCall(queryGetSellerById);
			instruction.setInt(1, idPerson);
			ResultSet rs = instruction.executeQuery();
			while (rs.next()) {
				myId = rs.getInt(1);
			}
			bool = myId != (null);
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.getInstance().closeConnection();
		}

		return bool;
	}

	public static boolean verifyPasswordById(Integer idPerson, String password) {
		boolean bool = false;

		try {
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect
					.prepareCall(queryGetPersonById);
			instruction.setInt(1, idPerson);
			ResultSet rs = instruction.executeQuery();
			while (rs.next()) {
				bool = Passwords.isExpectedPassword(password.toCharArray(),
						rs.getBytes(7), rs.getBytes(6));
			}
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.getInstance().closeConnection();
		}

		return bool;
	}

	/**
	 * This method deletes a Person from the database
	 * @param idPerson
	 * @return true if the deletion has been done, false otherwise
	 */
	public static boolean deletePerson(Integer idPerson) {
		boolean bool = false;
		// Delete link between Person and Address in database
		if (HaveAddressJDBC.deleteOneFromPerson(idPerson)) {
			try {
				Connection connect = Connect.getInstance().getConnection();

				PreparedStatement instruction = connect.prepareStatement(queryDeleteOne);
				instruction.setInt(1, idPerson);

				// Insert Person in database
				int affectedRows = instruction.executeUpdate();

				if (affectedRows == 0) {
					throw new SQLException(
							"Deleting person failed, no rows affected.");
				}

				// Delete Person as a User or an Administrator or a Seller
				if(PersonJDBC.isUser(idPerson)){
					UserJDBC.deleteOne(idPerson);
				}
				if(PersonJDBC.isAdministrator(idPerson)){
					AdministratorJDBC.deleteOne(idPerson);
				}
				if(PersonJDBC.isSeller(idPerson)){
					SellerJDBC.deleteOne(idPerson);
				}
				
				connect.commit();
				bool = true;
				connect.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				Connect.getInstance().closeConnection();
			}
		}
		
		return bool;
	}
}
