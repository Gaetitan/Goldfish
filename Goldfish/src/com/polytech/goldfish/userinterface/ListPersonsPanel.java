package com.polytech.goldfish.userinterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

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
					System.out.println(personFacade.findPersonByEmail(myTableModel.getValueAt(row, 3).toString()).getId() + " " + personFacade.findPersonByEmail(myTableModel.getValueAt(row, 3).toString()).getEmail());
					new UpdatePersonFrame(personFacade.findPersonByEmail(myTableModel.getValueAt(row, 3).toString()).getId());
				}
			}
		});
		
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}
	
}
