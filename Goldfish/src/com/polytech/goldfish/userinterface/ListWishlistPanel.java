package com.polytech.goldfish.userinterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.polytech.goldfish.businesslogic.facade.WishlistFacade;

public class ListWishlistPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private final WishlistFacade wishlistFacade;
	
	private final WishlistTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListWishlistPanel(){
	
		wishlistFacade = new WishlistFacade();
		
		myTableModel = new WishlistTableModel(wishlistFacade.findAllWishlists());
		myTable = new JTable(myTableModel);
		myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//myTable.removeColumn(myTable.getColumnModel().getColumn(0));
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
					//System.out.println(productCategoryFacade.findProductCategoryById(myTableModel.getValueAt(row, 0)) + " " + productCategoryFacade.findproductCategoryByEmail(myTableModel.getValueAt(row, 3).toString()).getEmail());
					//new UpdateWishlistFrame(Integer.parseInt((myTableModel.getValueAt(row, 0)).toString()));
				}
			}
		});
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);
	}
	
	public ListWishlistPanel(Integer id){
		
		wishlistFacade = new WishlistFacade();
		
		myTableModel = new WishlistTableModel(wishlistFacade.findWishlistByIdPerson(id));
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
					//System.out.println(productCategoryFacade.findProductCategoryById(myTableModel.getValueAt(row, 0)) + " " + productCategoryFacade.findproductCategoryByEmail(myTableModel.getValueAt(row, 3).toString()).getEmail());
					//new UpdateWishlistFrame(Integer.parseInt((myTableModel.getValueAt(row, 0)).toString()));
				}
			}
		});
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);
	}
	
}
