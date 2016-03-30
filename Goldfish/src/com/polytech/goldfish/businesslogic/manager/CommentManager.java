package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.businesslogic.factory.CommentFactory;
import com.polytech.goldfish.persistence.factoryjdbc.CommentFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;



public class CommentManager {
	
	/**
	 * <p>
	 * 	A commentFactory object
	 * </p>
	 */
	private final CommentFactory factory;
	
	/**
	 * <p>
	 * Does check if a string contains only numbers
	 * </p>
	 * @param number
	 * @return true or false
	 */
	boolean checkNumber(String number){
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(number);
		return m.matches();
	}

	public CommentManager(){
		this.factory = new CommentFactoryJDBC();
	}
	
	/**
	 * <p>
	 * Does all the fonctional checking then create a comment
	 * </p>
	 * @param text
	 * @param poster
	 * @param concernedPerson
	 * @return
	 * @throws GoldfishException
	 */
	public Integer createComment(String text, Integer poster, String concernedPerson) throws GoldfishException{
		if(text.isEmpty() || text == ""){
			throw new GoldfishException("Comment cannot be empty.");
		}
		else if(concernedPerson.isEmpty() || concernedPerson == ""){
			throw new GoldfishException("You must specify a concerned person.");
		}
		else if(!checkNumber(concernedPerson)){
			throw new GoldfishException("Please entre a valid ID for concerned person.");
		}
		else{
			return this.factory.createComment(text, poster, Integer.parseInt(concernedPerson));	
		}
	}

	/**
	 * <p>
	 * Does all the fonctional checking then update a comment
	 * </p>
	 * @param id
	 * @param newText
	 * @return
	 * @throws GoldfishException
	 */
	public Integer updateComment(Integer id, String newText) throws GoldfishException{
		if(newText.isEmpty() || newText == ""){
			throw new GoldfishException("Comment cannot be empty.");
		}
		else{
			return this.factory.updateComment(id, newText);	
		}
	}

	/**
	 * <p>
	 * Delete a comment
	 * </p>
	 * @param id
	 * @return
	 * @throws GoldfishException
	 */
	public Boolean deleteComment(Integer id) throws GoldfishException{
		return this.factory.deleteComment(id);
	}

	/**
	 * @return
	 */
	public Collection<Comment> findAllComments(){
		return this.factory.getAllComments();
	}

	/**
	 * <p>
	 * Find a comment by Id
	 * </p>
	 * @param idComment
	 * @return
	 */
	public Comment findCommentById(Integer idComment) {
		return this.factory.findCommentById(idComment);
	}

	/**
	 * <p>
	 * Tell if a comment was written by a certain User
	 * </p>
	 * @param idComment
	 * @param idUser
	 * @return true or false
	 */
	public boolean ownComment(Integer idComment, Integer idUser) {
		return this.factory.ownComment(idComment, idUser);
	}
}
