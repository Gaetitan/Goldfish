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

	private static CommentManager commentManager;
	
	public CommentFacade(){
		CommentFacade.commentManager = new CommentManager();
	}
	
	public Integer createComment(String text, Integer poster, Integer concernedPerson) throws GoldfishException{
		return commentManager.createComment(text, poster, concernedPerson);
	}
	
	public Integer updateComment(Integer id, String newText) throws GoldfishException{
		return commentManager.updateComment(id, newText);
	}
	
	public Integer deleteComment(Integer id) throws GoldfishException{
		return commentManager.deleteComment(id);
	}
	
	public Collection<Comment> findAllComments(){
		return commentManager.findAllComments();
	}
}
