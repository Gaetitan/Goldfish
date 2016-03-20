package com.polytech.goldfish.persistence.factoryjdbc;

import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.businesslogic.factory.CommentFactory;
import com.polytech.goldfish.persistence.jdbc.CommentJDBC;
import com.polytech.goldfish.util.GoldfishException;


/**
 * @author RedaM
 *
 */
public class CommentFactoryJDBC extends CommentFactory {

	@Override
	public Comment createComment(String text) {
		return CommentJDBC.createComment(text);
	}

	@Override
	public Collection<Comment> getAllComments() {
		// Creation of a collection of Comments
		Collection<Comment> listComments = new ArrayList<Comment>();
		
		// Put the CommentJDBC as Comment in a new list
		for(Comment comment : CommentJDBC.findAllComments()) {
			listComments.add(comment);
		}

		// Return the new list
		return listComments;
	}

	@Override
	public boolean updateComment(String id, String newText) throws GoldfishException {
		return CommentJDBC.updateComment(id, newText);
	}

	@Override
	public boolean deleteComment(String id) throws GoldfishException {
		return CommentJDBC.deleteCommet(id);
	}



}
