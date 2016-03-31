package com.polytech.goldfish.userinterface;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import com.polytech.goldfish.businesslogic.business.Goal;

public class GoalTableModel extends AbstractTableModel {
	
			// Attributes
			private static final long serialVersionUID = 1L;
			
			private final Collection<Goal> data;
			private final String[] columnNames = {"Name", "Description", "Deadline"};
			
			// Constructor
			public GoalTableModel(Collection<Goal> collection){
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
				Goal goal = (Goal) data.toArray()[rowIndex];
				switch(columnIndex){
					case 0 : return goal.getName();
					case 1 : return goal.getDescription();
					case 2 : return goal.getDeadline();
					default : throw new IllegalArgumentException("Unknown column " + columnIndex);
				}
			}
			
			@Override
			public String getColumnName(int arg0) {
				return this.columnNames[arg0];
			}

}
