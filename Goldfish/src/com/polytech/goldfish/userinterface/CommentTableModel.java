package com.polytech.goldfish.userinterface;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import com.polytech.goldfish.businesslogic.business.Comment;

public class CommentTableModel extends AbstractTableModel {

	// Attributes
	private static final long serialVersionUID = 1L;

	private final Collection<Comment> data;
	private final String[] columnNames = {"ID comment", "Concerned", "Text", "Date"};

	// Constructor
	public CommentTableModel(Collection<Comment> collection){
		this.data = collection;
	}

	// Inherited methods
	@Override
	public int getRowCount() {
		if(this.data == null)
			return 0;
		else
			return this.data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Comment comment = (Comment) data.toArray()[rowIndex];
		switch(columnIndex){
			case 0 : return comment.getId();
			case 1 : return comment.getConcerned();
			case 2 : return comment.getText();
			case 3 : return comment.getDate();
			default : throw new IllegalArgumentException("Unknown column " + columnIndex);
		}
	}

	@Override
	public String getColumnName(int arg0) {
		return this.columnNames[arg0];
	}

}
