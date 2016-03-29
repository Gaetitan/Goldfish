package com.polytech.goldfish.userinterface;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import com.polytech.goldfish.businesslogic.business.ProductCategory;

public class ProductCategoryTableModel extends AbstractTableModel {
	
			// Attributes
			private static final long serialVersionUID = 1L;
			
			private final Collection <ProductCategory> data;
			private final String[] columnNames = {"ID","Name"};
			
			// Constructor
			public ProductCategoryTableModel(Collection <ProductCategory> data){
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
				ProductCategory ProductCategory = (ProductCategory) data.toArray()[rowIndex];
				switch(columnIndex){
					case 0 : return ProductCategory.getId();
					case 1 : return ProductCategory.getName();
					default : throw new IllegalArgumentException("Unknown column " + columnIndex);
				}
			}
			
			@Override
			public String getColumnName(int arg0) {
				return this.columnNames[arg0];
			}

}
