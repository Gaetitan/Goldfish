package com.polytech.goldfish.userinterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.polytech.goldfish.businesslogic.facade.ShoppingCartFacade;

public class ShoppingCartPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final ShoppingCartFacade shoppingCartFacade;
	
	private final ShoppingCartTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ShoppingCartPanel(){
	
		shoppingCartFacade = new ShoppingCartFacade();
		myTableModel = new ShoppingCartTableModel(shoppingCartFacade.findAllProductsOfAShoppingCart(2));
		myTable = new JTable(myTableModel);
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}

}
