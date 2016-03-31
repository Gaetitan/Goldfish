package com.polytech.goldfish.userinterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.polytech.goldfish.businesslogic.facade.GoalFacade;

public class ListGoalPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final GoalFacade goalFacade;
	
	private final GoalTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListGoalPanel(){
	
		goalFacade = new GoalFacade();
		
		myTableModel = new GoalTableModel(goalFacade.findAllGoals());
		myTable = new JTable(myTableModel);
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}


}
