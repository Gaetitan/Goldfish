package com.polytech.goldfish.userinterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.polytech.goldfish.businesslogic.facade.DiaryFacade;

public class ListMyEntrysPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private static final String Integer = null;
	
	private final DiaryFacade diaryFacade;
	
	private final EntryTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListMyEntrysPanel(final Integer idPerson){
	
		diaryFacade = new DiaryFacade();
		myTableModel = new EntryTableModel(diaryFacade.findEntryByPersonId(idPerson));
		myTable = new JTable(myTableModel);
		myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		myTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){	//double click
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					new UpdateEntryFrame((Integer)myTableModel.getValueAt(row, 0));
				}
			}
		});
		
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}

}