package com.polytech.goldfish.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.util.Connect;
import com.polytech.goldfish.util.GoldfishException;


public class CommentJDBC extends Comment{	
	// Queries
	private static final String queryDeleteCommentById = "DELETE FROM comment WHERE idcomment = ?;";
	private static final String querySelectCommentById = "SELECT * FROM comment WHERE idcomment = ?;";
	private static final String queryInsertComment = "INSERT INTO comment (text, date, idpersonposter, idconcernedperson) VALUES(?,?,?,?);";
	private static final String queryGetAllComments = "SELECT * FROM comment;";
	private static final String queryUpdateComment = "UPDATE comment SET text = ?, date = ? WHERE idcomment = ?;";	
	// Constructors
	public CommentJDBC(Integer id, String nameConcerned, String poster, String text, Date date) {
		super(id, nameConcerned, poster, text, date);
	}


	public static Integer createComment(String text, Integer poster, Integer concernedPerson) throws GoldfishException {
		Integer idToReturn = null;
		if(PersonJDBC.isAdministrator(concernedPerson)){
			throw new GoldfishException("You can't comment to an administrator");
		}
		else if(PersonJDBC.findPersonById(concernedPerson) == null){
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
			instruction.setInt(4, concernedPerson);


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

	public static Integer updateComment(Integer id, String newText) {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryUpdateComment, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, newText);
			instruction.setString(2, ft.format(dNow));
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

	public static Integer deleteCommet(Integer id) {
		Integer idToReturn = null;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareStatement(queryDeleteCommentById, Statement.RETURN_GENERATED_KEYS);
			instruction.setInt(1, id);
			int affectedRows = instruction.executeUpdate();
			connect.commit();

			if(affectedRows == 0){
				throw new SQLException("Deleting comment failed, no rows deleted.");
			}

			try(ResultSet generatedKeys = instruction.getGeneratedKeys()){
				if(generatedKeys.next()){
					idToReturn = generatedKeys.getInt(1);
				}
				else{
					throw new SQLException("Deleteting comment failed, no ID obtained.");
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
	public static Comment findCommentById(Integer idComment) {
		CommentJDBC comment = null;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(querySelectCommentById);
			instruction.setInt(1, idComment);
			ResultSet rs = instruction.executeQuery();

			while(rs.next()){
				String posterName = (PersonJDBC.findPersonById(rs.getInt(4))).getName();
				String concernedName = (PersonJDBC.findPersonById(rs.getInt(5))).getName();
				comment = new CommentJDBC(rs.getInt(1), concernedName, posterName, rs.getString(2), rs.getDate(3));
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
}