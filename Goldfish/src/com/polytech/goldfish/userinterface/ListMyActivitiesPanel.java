package com.polytech.goldfish.userinterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.polytech.goldfish.businesslogic.facade.ActivityFacade;

public class ListMyActivitiesPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private static final String Integer = null;
	
	private final ActivityFacade activityFacade;
	
	private final ActivityTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListMyActivitiesPanel(final Integer idPerson){
	
		activityFacade = new ActivityFacade();
		myTableModel = new ActivityTableModel(activityFacade.findAllActivitiesOfAnUser(idPerson));
		myTable = new JTable(myTableModel);
		myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myTable.removeColumn(myTable.getColumnModel().getColumn(0));
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
					new UpdateActivityCategoryFrame((Integer)myTableModel.getValueAt(row, 0), idPerson);
				}
			}
		});
		
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}

}