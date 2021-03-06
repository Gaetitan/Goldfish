package com.polytech.goldfish.userinterface;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import com.polytech.goldfish.businesslogic.business.DiaryEntry;

public class EntryTableModel  extends AbstractTableModel {

	// Attributes
		private static final long serialVersionUID = 1L;
		
		private final Collection <DiaryEntry> data;
		private final String[] columnNames = {"Entry's ID" ,"Name", "Visibility"};
		
		// Constructor
		public EntryTableModel(Collection <DiaryEntry> data){
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
			DiaryEntry entry = (DiaryEntry) data.toArray()[rowIndex];
			switch(columnIndex){
				case 0 : return entry.getId();
				case 1 : return entry.getName();
				case 2 : return entry.getVisibility();
				default : throw new IllegalArgumentException("Unknown column " + columnIndex);
			}
		}
		
		@Override
		public String getColumnName(int arg0) {
			return this.columnNames[arg0];
		}
}
