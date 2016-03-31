package com.polytech.goldfish.userinterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.polytech.goldfish.businesslogic.business.ShoppingCart;
import com.polytech.goldfish.businesslogic.facade.PersonFacade;
import com.polytech.goldfish.businesslogic.facade.ProductFacade;
import com.polytech.goldfish.businesslogic.facade.ShoppingCartFacade;

public class ListProductsPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final ProductFacade productFacade;
	private final ShoppingCartFacade shoppingCartFacade;
	private final ProductTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	private final PersonFacade personFacade;

	
	public ListProductsPanel(final Integer idPerson){
	
		productFacade = new ProductFacade();
		shoppingCartFacade = new ShoppingCartFacade();
		personFacade = new PersonFacade();

		myTableModel = new ProductTableModel(productFacade.findAllProducts());
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
					ShoppingCart shopCart = shoppingCartFacade.findShoppingCartOfAnUser(idPerson);
					//System.out.println(productCategoryFacade.findProductCategoryById(myTableModel.getValueAt(row, 0)) + " " + productCategoryFacade.findproductCategoryByEmail(myTableModel.getValueAt(row, 3).toString()).getEmail());
					if (personFacade.isUser(idPerson)){
						new AddProductShoppingFrame(shopCart.getId(),Integer.parseInt((myTableModel.getValueAt(row, 0)).toString()));
					}
					else if(personFacade.isAdministrator(idPerson)){
						new UpdateProductFrame(Integer.parseInt((myTableModel.getValueAt(row, 0)).toString()));
					}
				}
			}
		});
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);

	}

}
