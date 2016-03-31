package com.polytech.goldfish.userinterface;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import com.polytech.goldfish.businesslogic.business.ActivityCategory;

public class ActivityCategoryTableModel extends AbstractTableModel {
	
			// Attributes
			private static final long serialVersionUID = 1L;
			
			private final Collection <ActivityCategory> data;
			private final String[] columnNames = {"Id", "Name", "Short Description", "Detailled Description"};
			
			// Constructor
			public ActivityCategoryTableModel(Collection <ActivityCategory> data){
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
				ActivityCategory activityCategory = (ActivityCategory) data.toArray()[rowIndex];
				switch(columnIndex){
					case 0: return activityCategory.getId();
					case 1 : return activityCategory.getName();
					case 2 : return activityCategory.getShort_description();
					case 3 : return activityCategory.getDetailed_description();
					default : throw new IllegalArgumentException("Unknown column " + columnIndex);
				}
			}
			
			@Override
			public String getColumnName(int arg0) {
				return this.columnNames[arg0];
			}

}