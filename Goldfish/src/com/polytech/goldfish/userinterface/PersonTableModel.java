package com.polytech.goldfish.userinterface;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import com.polytech.goldfish.businesslogic.business.Person;

public class PersonTableModel extends AbstractTableModel {
	
	// Attributes
	private static final long serialVersionUID = 1L;
	
	private final Collection <Person> data;
	private final String[] columnNames = {"Surname", "Name", "Phone number", "Email"};
	
	// Constructor
	public PersonTableModel(Collection <Person> data){
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
		Person user = (Person) data.toArray()[rowIndex];
		switch(columnIndex){
			case 0 : return user.getSurname();
			case 1 : return user.getName();
			case 2 : return user.getPhone_number();
			case 3 : return user.getEmail();
			default : throw new IllegalArgumentException("Unknown column " + columnIndex);
		}
	}
	
	@Override
	public String getColumnName(int arg0) {
		return this.columnNames[arg0];
	}

}
