package com.polytech.goldfish.userinterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.polytech.goldfish.businesslogic.facade.WishlistFacade;

public class ListWishlistPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private final WishlistFacade wishlitFacade;
	
	private final WishlistTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListWishlistPanel(){
	
		wishlitFacade = new WishlistFacade();
		
		myTableModel = new WishlistTableModel(wishlitFacade.findAllWishlists());
		myTable = new JTable(myTableModel);
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);
	}
	
	public ListWishlistPanel(Integer id){
		
		wishlitFacade = new WishlistFacade();
		
		myTableModel = new WishlistTableModel(wishlitFacade.findWishlistById(id));
		myTable = new JTable(myTableModel);
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);
	}
	
}
