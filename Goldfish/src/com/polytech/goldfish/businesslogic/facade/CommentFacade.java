package com.polytech.goldfish.businesslogic.facade;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.businesslogic.manager.CommentManager;
import com.polytech.goldfish.util.GoldfishException;

/**
 * @author RedaM
 *
 */
public class CommentFacade {

	private final CommentManager commentManager;
	
	public CommentFacade(){
		this.commentManager = new CommentManager();
	}
	
	public Comment createComment(String text, Integer poster, Integer concernedPerson) throws GoldfishException{
		return this.commentManager.createComment(text);
	}
	
	public boolean updateComment(String id, String newText) throws GoldfishException{
		return this.commentManager.updateComment(id, newText);
	}
	
	public boolean deleteComment(String id) throws GoldfishException{
		return this.commentManager.deleteComment(id);
	}
	
	public Collection<Comment> findAllComments(){
		return this.commentManager.findAllComments();
	}
}
