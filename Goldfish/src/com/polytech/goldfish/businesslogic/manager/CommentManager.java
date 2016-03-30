package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.businesslogic.factory.CommentFactory;
import com.polytech.goldfish.persistence.factoryjdbc.CommentFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;



public class CommentManager {
	
	private final CommentFactory factory;
	
	boolean checkNumber(String number){
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(number);
		return m.matches();
	}
	
	public CommentManager(){
		this.factory = new CommentFactoryJDBC();
	}
	
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

	public Integer updateComment(Integer id, String newText) throws GoldfishException{
		if(newText.isEmpty() || newText == ""){
			throw new GoldfishException("Comment cannot be empty.");
		}
		else{
			return this.factory.updateComment(id, newText);	
		}
	}

	public Integer deleteComment(Integer id) throws GoldfishException{
		return this.factory.deleteComment(id);
	}

	public Collection<Comment> findAllComments(){
		return this.factory.getAllComments();
	}

	public Comment findCommentById(Integer idComment) {
		return this.factory.findCommentById(idComment);
	}
}
