package com.polytech.goldfish.businesslogic.manager;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.businesslogic.factory.CommentFactory;
import com.polytech.goldfish.persistence.factoryjdbc.CommentFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;



public class CommentManager {
	
	private final CommentFactory factory;
	
	public CommentManager(){
		this.factory = new CommentFactoryJDBC();
	}
	
	public Integer createComment(String text, Integer poster, Integer concernedPerson) throws GoldfishException{
		if(text.isEmpty() || text == ""){
			throw new GoldfishException("Comment cannot be empty.");
		}
		else{
			return this.factory.createComment(text, poster, concernedPerson);	
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
}
