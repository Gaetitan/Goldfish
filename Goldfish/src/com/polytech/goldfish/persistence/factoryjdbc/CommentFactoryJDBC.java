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
	public Integer createComment(String text, Integer poster, String concernedPerson) throws GoldfishException {
		return CommentJDBC.createComment(text, poster, concernedPerson);
	}

	@Override
	public Collection<Comment> getAllComments() {
		// Creation of a collection of Comments
		Collection<CommentJDBC> listCommentsJDBC = CommentJDBC.findAllComments();
		Collection<Comment> listComments = new ArrayList<Comment>();
		
		// Put the CommentJDBC as Comment in a new list
		for(Comment comment : listCommentsJDBC) {
			listComments.add(comment);
		}

		// Return the new list
		return listComments;
	}

	@Override
	public Integer updateComment(Integer id, String newText) throws GoldfishException {
		return CommentJDBC.updateComment(id, newText);
	}

	@Override
	public Boolean deleteComment(Integer id) throws GoldfishException {
		return CommentJDBC.deleteComment(id);
	}

	@Override
	public Comment findCommentById(Integer idComment) {
		return CommentJDBC.findCommentById(idComment);
	}

	@Override
	public boolean ownComment(Integer idComment, Integer idUser) {
		return CommentJDBC.ownComment(idComment, idUser);
	}



}
