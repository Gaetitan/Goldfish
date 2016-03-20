package com.polytech.goldfish.businesslogic.factory;

import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.util.GoldfishException;



/**
 * @author RedaM
 *
 */
public abstract class CommentFactory {

	public abstract Comment createComment(String text, Integer poster, Integer concernedPerson) throws GoldfishException;

	public abstract boolean updateComment(String id, String newText) throws GoldfishException;

	public abstract boolean deleteComment(String id) throws GoldfishException;

	public abstract Collection<Comment> getAllComments();
}
