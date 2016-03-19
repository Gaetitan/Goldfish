package com.polytech.goldfish.userinterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.polytech.goldfish.businesslogic.facade.ProductFacade;

public class ListProductsPanel extends JPanel{
	
	private final ProductFacade productFacade;
	
	private final PersonTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListProductsPanel(){
	
		productFacade = new ProductFacade();
		
		myTableModel = new ProductTableModel(productFacade.findAllProducts());
		myTable = new JTable(myTableModel);
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}

}
