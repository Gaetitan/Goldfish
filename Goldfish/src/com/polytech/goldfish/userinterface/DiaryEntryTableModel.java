package com.polytech.goldfish.userinterface;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import com.polytech.goldfish.businesslogic.business.DiaryEntry;

public class DiaryEntryTableModel extends AbstractTableModel {
	
			// Attributes
			private static final long serialVersionUID = 1L;
			
			private final Collection <DiaryEntry> data;
			private final String[] columnNames = {"Owner", "Name", "Date", "Visibility"};
			
			// Constructor
			public DiaryEntryTableModel(Collection <DiaryEntry> data){
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
				DiaryEntry diaryEntry = (DiaryEntry) data.toArray()[rowIndex];
				switch(columnIndex){
					case 0 : return diaryEntry.getIdPerson();
					case 1 : return diaryEntry.getName();
					case 2 : return diaryEntry.getDate();
					case 3 : return diaryEntry.getVisibility();
					default : throw new IllegalArgumentException("Unknown column " + columnIndex);
				}
			}
			
			@Override
			public String getColumnName(int arg0) {
				return this.columnNames[arg0];
			}

}
