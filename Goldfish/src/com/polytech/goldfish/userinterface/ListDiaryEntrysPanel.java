package com.polytech.goldfish.userinterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.polytech.goldfish.businesslogic.facade.DiaryFacade;

public class ListDiaryEntrysPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final DiaryFacade diaryEntryFacade;
	
	private final DiaryEntryTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListDiaryEntrysPanel(){
	
		diaryEntryFacade = new DiaryFacade();
		
		myTableModel = new DiaryEntryTableModel(diaryEntryFacade.findAllEntrys());
		myTable = new JTable(myTableModel);
		myTable.removeColumn(myTable.getColumnModel().getColumn(0));
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}


}
