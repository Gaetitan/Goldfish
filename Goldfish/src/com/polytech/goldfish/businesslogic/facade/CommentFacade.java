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

	/**
	 *  Instanciate a commentmanager
	 */
	private static CommentManager commentManager;
	
	/**
	 *  Constructor of comment facade
	 */
	public CommentFacade(){
		CommentFacade.commentManager = new CommentManager();
	}
	
	/**
	 * <p>
	 *  Create a comment (call the createComment method on commentManager)
	 * </p>
	 * @param text
	 * @param poster
	 * @param concernedPerson
	 * @return an integer
	 * @throws GoldfishException
	 * 
	 */
	public Integer createComment(String text, Integer poster, String concernedPerson) throws GoldfishException{
		return commentManager.createComment(text, poster, concernedPerson);
	}
	
	/**
	 * <p>
	 *  update a comment (call the updateComment method on commentManager)
	 * </p>
	 * @param id
	 * @param newText
	 * @return an integer
	 * @throws GoldfishException
	 */
	public Integer updateComment(Integer id, String newText) throws GoldfishException{
		return commentManager.updateComment(id, newText);
	}
	
	/**
	 * <p>
	 *  delete a comment (call the deleteComment method on commentManager)
	 * </p>
	 * @param id
	 * @return an integer
	 * @throws GoldfishException
	 */
	public Boolean deleteComment(Integer id) throws GoldfishException{
		return commentManager.deleteComment(id);
	}
	
	/**
	 * <p>
	 *  get all comment (call the findAllComments method on commentManager)
	 * </p>
	 * @return a list of all comments
	 */
	public Collection<Comment> findAllComments(){
		return commentManager.findAllComments();
	}

	/**
	 * <p>
	 *  get a comment by his identifier (call the findCommentById method on commentManager)
	 * </p>
	 * @param idComment
	 * @return
	 */
	public Comment findCommentById(Integer idComment) {
		return commentManager.findCommentById(idComment);
	}
	
	/**
	 * <p>
	 *  tell if a comment belongs to a certain user (call the ownComment method on commentManager)
	 * </p>
	 * @param idComment
	 * @param idUser
	 * @return
	 */
	public boolean ownComment(Integer idComment, Integer idUser) {
		return commentManager.ownComment(idComment, idUser);
	}
}
