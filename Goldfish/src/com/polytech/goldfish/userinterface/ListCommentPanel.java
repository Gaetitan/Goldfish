package com.polytech.goldfish.userinterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.polytech.goldfish.businesslogic.facade.CommentFacade;

public class ListCommentPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final CommentFacade commentFacade;
	
	private final CommentTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListCommentPanel(){
	
		commentFacade = new CommentFacade();
		
		myTableModel = new CommentTableModel(commentFacade.findAllComments());
		myTable = new JTable(myTableModel);
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}


}
