package com.polytech.goldfish.userinterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.polytech.goldfish.businesslogic.facade.ProductCategoryFacade;

public class ListProductsCategoriesPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final ProductCategoryFacade ProductCategoryFacade;
	
	private final ProductCategoryTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	
	public ListProductsCategoriesPanel(){
	
		ProductCategoryFacade = new ProductCategoryFacade();
		
		myTableModel = new ProductCategoryTableModel(ProductCategoryFacade.findAllProductCategories());
		myTable = new JTable(myTableModel);
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}


}
