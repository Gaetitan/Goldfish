package com.polytech.goldfish.userinterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.polytech.goldfish.businesslogic.facade.PersonFacade;

public class ListPersonsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final PersonFacade personFacade;
	
	private final PersonTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListPersonsPanel(){
	
		personFacade = new PersonFacade();
		
		myTableModel = new PersonTableModel(personFacade.findAllPersons());
		myTable = new JTable(myTableModel);
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}
	
}
