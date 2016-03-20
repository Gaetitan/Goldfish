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
	
	public static Integer createComment(String text, Integer poster, Integer concernedPerson) throws GoldfishException{
		return commentManager.createComment(text, poster, concernedPerson);
	}
	
	public static Integer updateComment(Integer id, String newText) throws GoldfishException{
		return commentManager.updateComment(id, newText);
	}
	
	public static Integer deleteComment(Integer id) throws GoldfishException{
		return commentManager.deleteComment(id);
	}
	
	public static Collection<Comment> findAllComments(){
		return commentManager.findAllComments();
	}
}
