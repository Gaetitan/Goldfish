package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.util.GoldfishException;



/**
 * @author RedaM
 *
 */
public abstract class CommentFactory {

	public abstract Integer createComment(String text, Integer poster, Integer concernedPerson) throws GoldfishException;

	public abstract Integer updateComment(Integer id, String newText) throws GoldfishException;

	public abstract Integer deleteComment(Integer id) throws GoldfishException;

	public abstract Collection<Comment> getAllComments();

	public abstract Comment findCommentById(Integer idComment);

	public abstract boolean ownComment(Integer idComment, Integer idUser);
}
