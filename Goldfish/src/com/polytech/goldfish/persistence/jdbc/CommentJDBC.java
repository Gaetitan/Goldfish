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
	private static final String queryInsertComment = "INSERT INTO comment (text, date) VALUES(?,?);";
	private static final String queryGetAllComments = "SELECT * FROM comment;";
	private static final String queryUpdateComment = "UPDATE comment SET text = ?, date = ? WHERE idcomment = ?;";	
	private static final String querySelectConcernedUserToUser = "SELECT idpersonconcernuser FROM commentusertouser WHERE idcomment = ?;";
	private static final String querySelectConcernedUserToSeller = "SELECT idpersonconcernseller FROM commentusertoseller WHERE idcomment = ?;";
	private static final String querySelectConcernedSellerToUser = "SELECT idpersonconcernuser FROM commentsellertouser WHERE idcomment = ?;";
	private static final String querySelectConcernedSellerToSeller = "SELECT idpersonconcernseller FROM commentsellertoseller WHERE idcomment = ?;";
	// Constructors
	public CommentJDBC(Integer id, String nameConcerned, String text, Date date) {
		super(id, nameConcerned, text, date);
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
			// Insert Comment and link between Comment and CommentSeller in database
			if(PersonJDBC.isUser(poster)){
				if(PersonJDBC.isUser(concernedPerson)){
					CommentUserJDBC.queryInsertOneUserToUser(idToReturn, poster, concernedPerson);
				}
				else{
					CommentUserJDBC.queryInsertOneUserToSeller(idToReturn, poster, concernedPerson); 
				} 
			}
			else{
				if(PersonJDBC.isUser(concernedPerson)){
					CommentSellerJDBC.queryInsertOneSellerToUser(idToReturn, poster, concernedPerson);
				}
				else{
					CommentSellerJDBC.queryInsertOneSellerToSeller(idToReturn, poster, concernedPerson);	
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
				PreparedStatement instructionConcernUTOU = connect.prepareCall(querySelectConcernedUserToUser);
				instructionConcernUTOU.setInt(1, rs.getInt(1));
				ResultSet ConcernUTOU = instructionConcernUTOU.executeQuery();

				PreparedStatement instructionConcernUTOS = connect.prepareCall(querySelectConcernedUserToSeller);
				instructionConcernUTOS.setInt(1, rs.getInt(1));
				ResultSet ConcernUTOS = instructionConcernUTOS.executeQuery();

				PreparedStatement instructionConcernSTOU = connect.prepareCall(querySelectConcernedSellerToUser);
				instructionConcernSTOU.setInt(1, rs.getInt(1));
				ResultSet ConcernSTOU = instructionConcernSTOU.executeQuery();

				PreparedStatement instructionConcernSTOS = connect.prepareCall(querySelectConcernedSellerToSeller);
				instructionConcernSTOS.setInt(1, rs.getInt(1));
				ResultSet ConcernSTOS = instructionConcernSTOS.executeQuery();


				while(ConcernUTOU.next()){
					listComments.add(new CommentJDBC(rs.getInt(1), (PersonJDBC.findPersonById(ConcernUTOU.getInt(1))).getName(), rs.getString(2), rs.getDate(3)));
				}
				while(ConcernUTOS.next()){
					listComments.add(new CommentJDBC(rs.getInt(1), (PersonJDBC.findPersonById(ConcernUTOS.getInt(1))).getName(), rs.getString(2), rs.getDate(3)));
				}
				while(ConcernSTOU.next()){
					listComments.add(new CommentJDBC(rs.getInt(1), (PersonJDBC.findPersonById(ConcernSTOU.getInt(1))).getName(), rs.getString(2), rs.getDate(3)));
				}
				while(ConcernSTOS.next()){
					listComments.add(new CommentJDBC(rs.getInt(1), (PersonJDBC.findPersonById(ConcernSTOS.getInt(1))).getName(), rs.getString(2), rs.getDate(3)));
				}

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

			// Delete links between Comment and CommentSeller in database
			CommentUserJDBC.queryDeleteOneUserToUser(idToReturn);
			CommentUserJDBC.queryDeleteOneUserToSeller(idToReturn); 
			CommentSellerJDBC.queryDeleteOneSellerToUser(idToReturn);
			CommentSellerJDBC.queryDeleteOneSellerToSeller(idToReturn);	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connect.getInstance().closeConnection();
		}
		return idToReturn;
	}

	public static Integer findPoster(Integer idComment){
		int idPoster = 0;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instructionConcernUTOU = connect.prepareCall(querySelectConcernedUserToUser);
			instructionConcernUTOU.setInt(1, idComment);
			ResultSet ConcernUTOU = instructionConcernUTOU.executeQuery();

			PreparedStatement instructionConcernUTOS = connect.prepareCall(querySelectConcernedUserToSeller);
			instructionConcernUTOS.setInt(1, idComment);
			ResultSet ConcernUTOS = instructionConcernUTOS.executeQuery();

			PreparedStatement instructionConcernSTOU = connect.prepareCall(querySelectConcernedSellerToUser);
			instructionConcernSTOU.setInt(1, idComment);
			ResultSet ConcernSTOU = instructionConcernSTOU.executeQuery();

			PreparedStatement instructionConcernSTOS = connect.prepareCall(querySelectConcernedSellerToSeller);
			instructionConcernSTOS.setInt(1, idComment);
			ResultSet ConcernSTOS = instructionConcernSTOS.executeQuery();
			
			while(ConcernUTOU.next()){
				idPoster = ConcernUTOU.getInt(1);
			}
			while(ConcernUTOS.next()){
				idPoster = ConcernUTOS.getInt(1);
			}
			while(ConcernSTOU.next()){
				idPoster = ConcernSTOU.getInt(1);
			}
			while(ConcernSTOS.next()){
				idPoster = ConcernSTOS.getInt(1);
			}}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				Connect.getInstance().closeConnection();
			}
			return idPoster;
	}
	public static Comment findCommentById(Integer idComment) {
		CommentJDBC comment = null;
		try{
			Connection connect = Connect.getInstance().getConnection();

			PreparedStatement instruction = connect.prepareCall(querySelectCommentById);
			instruction.setInt(1, idComment);
			ResultSet rs = instruction.executeQuery();

			while(rs.next()){
				String posterName = (PersonJDBC.findPersonById(findPoster(idComment)).getName());
				comment = new CommentJDBC(rs.getInt(1), posterName, rs.getString(2), rs.getDate(3));
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