package com.polytech.goldfish.userinterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.polytech.goldfish.businesslogic.facade.ActivityCategoryFacade;

public class ListGoalPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final ActivityCategoryFacade activityCategoryFacade;
	
	private final ActivityCategoryTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListGoalPanel(){
	
		activityCategoryFacade = new ActivityCategoryFacade();
		
		myTableModel = new ActivityCategoryTableModel(activityCategoryFacade.findAllActivitiesCategories());
		myTable = new JTable(myTableModel);
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}


}
