package com.polytech.goldfish.userinterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.polytech.goldfish.businesslogic.facade.ActivityFacade;

public class ListMyActivitiesPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private static final String Integer = null;
	
	private final ActivityFacade activityFacade;
	
	private final ActivityTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListMyActivitiesPanel(){
	
		activityFacade = new ActivityFacade();
		myTableModel = new ActivityTableModel(activityFacade.findAllActivitiesOfAnUser(1));
		myTable = new JTable(myTableModel);
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}

}
