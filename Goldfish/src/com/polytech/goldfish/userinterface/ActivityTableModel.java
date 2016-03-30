package com.polytech.goldfish.userinterface;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import com.polytech.goldfish.businesslogic.business.Activity;

public class ActivityTableModel  extends AbstractTableModel {

	// Attributes
		private static final long serialVersionUID = 1L;
		
		private final Collection <Activity> data;
		private final String[] columnNames = {"Id", "Name", "Description"};
		
		// Constructor
		public ActivityTableModel(Collection <Activity> data){
			this.data = data;
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
			Activity activity = (Activity) data.toArray()[rowIndex];
			switch(columnIndex){
				case 0 : return activity.getId();
				case 1 : return activity.getName();
				case 2 : return activity.getDescription();
				default : throw new IllegalArgumentException("Unknown column " + columnIndex);
			}
		}
		
		@Override
		public String getColumnName(int arg0) {
			return this.columnNames[arg0];
		}
}
