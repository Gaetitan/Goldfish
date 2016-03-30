package com.polytech.goldfish.userinterface;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import com.polytech.goldfish.businesslogic.business.Wishlist;

public class WishlistTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Collection <Wishlist> data;
	private final String[] columnNames = {"ID","Name", "Quantity"};
	
	// Constructor
	public WishlistTableModel(Collection<Wishlist> data){
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
		Wishlist wishlist = (Wishlist) data.toArray()[rowIndex];
		switch(columnIndex){
			case 0 : return wishlist.getId();
			case 1 : return wishlist.getName();
			case 2 : return wishlist.getQuantity();
			default : throw new IllegalArgumentException("Unknown column " + columnIndex);
		}
	}
	
	@Override
	public String getColumnName(int arg0) {
		return this.columnNames[arg0];
	}

}
