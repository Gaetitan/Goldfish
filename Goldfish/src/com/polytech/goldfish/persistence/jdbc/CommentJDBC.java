package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.util.Connect;
import com.polytech.goldfish.util.GoldfishException;


/**
 * @author RedaM
 *
 */
public class CommentJDBC extends Comment{	
	// Queries
	private static final String queryDeleteCommentById = "DELETE FROM comment WHERE idcomment = ?;";
	private static final String querySelectCommentById = "SELECT * FROM comment WHERE idcomment = ?;";
	private static final String queryInsertComment = "INSERT INTO comment (text, date, idpersonposter, idconcernedperson) VALUES(?,?,?,?);";
	private static final String queryGetAllComments = "SELECT * FROM comment;";
	private static final String queryUpdateComment = "UPDATE comment SET text = ?, date = ? WHERE idcomment = ?;";	
	private static final String queryOwnComment = "SELECT idcomment FROM comment WHERE idpersonposter = ?;";	
	// Constructors
	public CommentJDBC(Integer id, String nameConcerned, String poster, String text, Date date) {
		super(id, nameConcerned, poster, text, date);
	}


	/**
	 * <p>
	 * Open a connection to the database, Create a comment in the database
	 * then close the connection
	 * </p>
	 * @param text
	 * @param poster
	 * @param concernedPerson
	 * @return the id of the newly created comment
	 * @throws GoldfishException if person does not exists or if the comment is adressed to and admin
	 * @throws SQLException if an sql error occured
	 */
	public static Integer createComment(String text, Integer poster, String concernedPerson) throws GoldfishException {
		Integer idToReturn = null;
		Integer idPerson = PersonJDBC.findPersonByEmail(concernedPerson).getId();
		if(PersonJDBC.isAdministrator(idPerson)){
			throw new GoldfishException("You can't comment to an administrator");
		}
		else if(PersonJDBC.findPersonByEmail(concernedPerson) == null){
			throw new GoldfishException("Concerned person does not exist");
		}
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		try{
			Connection connect = Connect.getInstance().getConnection();
			PreparedStatement instruction = connect.prepareStatement(queryInsertComment, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, text);
			instruction.setDate(2, sqlDate);
			instruction.setInt(3, poster);
			instruction.setInt(4, idPerson);


			// Insert Comment in databse
			int affectedRows = instruction.executeUpdate();
			connect.commit();


			if(affectedRows == 0){
				throw new SQLException("Creating comment failed, no rows affected.");
			}	

			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Creating comment failed, no ID obtained.");
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
	 * <p>
	 * Open a connection to the database
	 * Fetch all the comments from the database
	 * the close the connection
	 * </p>
	 * @return a collection of comments
	 * @throws SQLException if an sql error occured
	 */
	public static Collection<CommentJDBC> findAllComments() {
		Collection<CommentJDBC> listComments = null;
		try{
			listComments = new ArrayList<CommentJDBC>();
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(queryGetAllComments);
			ResultSet rs = instruction.executeQuery();

			while(rs.next()){
				String posterName = (PersonJDBC.findPersonById(rs.getInt(4))).getName();
				String concernedName = (PersonJDBC.findPersonById(rs.getInt(5))).getName();
				listComments.add(new CommentJDBC(rs.getInt(1), concernedName, posterName, rs.getString(2), rs.getDate(3)));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}

		return listComments;
	}

	/**
	 * <p>
	 * Open a connection to the database, then update a comment in the database (newText and newDate)
	 * the close the connection
	 * </p>
	 * @param id
	 * @param newText
	 * @return the id of the newly created comment
	 * @throws SQLException if an sql error occured
	 */
	public static Integer updateComment(Integer id, String newText) {
		Date dNow = new Date();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryUpdateComment, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, newText);
			instruction.setDate(2, sqlDate);
			instruction.setInt(3, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();

			if(affectedRows == 0){
				throw new SQLException("Updating comment failed, no rows affected.");
			}

			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Updating comment failed, no ID obtained.");
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
	 * <p>
	 * Open a connection to the database, delete a comment in the database
	 * the close the connection
	 * </p>
	 * @param id
	 * @return true if the deletion has been done, false otherwise
	 * @throws SQLException if an sql error occured
	 */
	public static Boolean deleteComment(Integer id) {
		Boolean deleted = false;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryDeleteCommentById, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();
			deleted = true;

			if(affectedRows == 0){
				throw new SQLException("Deleting comment failed, no rows deleted.");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return deleted;
	}
	
	/**
	 * <p>
	 * Open a connection to the database, fetch a comment in the database
	 * the close the connection
	 * </p>
	 * @param idComment
	 * @return the comment
	 * @throws SQLException if an sql error occured
	 */
	public static Comment findCommentById(Integer idComment) {
		CommentJDBC comment = null;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(querySelectCommentById);
			instruction.setInt(1, idComment);
			ResultSet rs = instruction.executeQuery();

			while(rs.next()){
				//String posterName = (PersonJDBC.findPersonById(rs.getInt(4))).getName();
				//String concernedName = (PersonJDBC.findPersonById(rs.getInt(5))).getName();
				comment = new CommentJDBC(rs.getInt(1), "Unknown", "Unknown", rs.getString(2), rs.getDate(3));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return comment;
	}


	/**
	 * <p>
	 *  Does open a connection to the database, then tell if a person has comment a certain comment
	 * 	and close the connection
	 * </p>
	 * @param idComment
	 * @param idPerson
	 * @return true or false
	 */
	public static boolean ownComment(Integer idComment, Integer idPerson) {
		boolean effectiveOwnComment = false;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(queryOwnComment);
			instruction.setInt(1, idPerson);
			ResultSet rs = instruction.executeQuery();
			if(rs.next()){
				effectiveOwnComment = true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return effectiveOwnComment;
	}
}