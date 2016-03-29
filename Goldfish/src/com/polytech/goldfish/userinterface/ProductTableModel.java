package com.polytech.goldfish.userinterface;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import com.polytech.goldfish.businesslogic.business.Product;

public class ProductTableModel extends AbstractTableModel {

	// Attributes
		private static final long serialVersionUID = 1L;
		
		private final Collection <Product> data;
		private final String[] columnNames = {"ID","Name", "Description"};
		
		// Constructor
		public ProductTableModel(Collection<Product> data){
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
			Product product = (Product) data.toArray()[rowIndex];
			switch(columnIndex){
				case 0 : return product.getId();
				case 1 : return product.getName();
				case 2 : return product.getDescription();
				default : throw new IllegalArgumentException("Unknown column " + columnIndex);
			}
		}
		
		@Override
		public String getColumnName(int arg0) {
			return this.columnNames[arg0];
		}
}
