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
	
	public Integer createComment(String text, Integer poster, Integer concernedPerson) throws GoldfishException{
		return this.commentManager.createComment(text, poster, concernedPerson);
	}
	
	public Integer updateComment(Integer id, String newText) throws GoldfishException{
		return this.commentManager.updateComment(id, newText);
	}
	
	public Integer deleteComment(Integer id) throws GoldfishException{
		return this.commentManager.deleteComment(id);
	}
	
	public Collection<Comment> findAllComments(){
		return this.commentManager.findAllComments();
	}
}
