package com.polytech.goldfish.userinterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.polytech.goldfish.businesslogic.business.ShoppingCart;
import com.polytech.goldfish.businesslogic.facade.ShoppingCartFacade;

public class ShoppingCartPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private final ShoppingCartFacade shoppingCartFacade;
	
	private final ShoppingCartTableModel myTableModel;
	private final JTable myTable;
	private final JScrollPane myScrollPane;
	private final ShoppingCart shopCart;
	
	public ShoppingCartPanel(final Integer idPerson){
		shoppingCartFacade = new ShoppingCartFacade();
		shopCart = shoppingCartFacade.findShoppingCartOfAnUser(idPerson);
		myTableModel = new ShoppingCartTableModel(shoppingCartFacade.findAllProductsOfAShoppingCart(shopCart.getId()));
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
					new UpdateShoppingCartFrame(shopCart.getId(), (Integer)myTableModel.getValueAt(row, 0), idPerson);
				}
			}
		});
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);
		
		// Empty Shopping Cart
		JButton btnEmptyShoppingCart = new JButton("Empty ShoppingCart");
			btnEmptyShoppingCart.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Integer id = null;
					id = shoppingCartFacade.emptyShoppingCart(shopCart.getId());
					JOptionPane.showMessageDialog(null, "The shopping cart has been emptied.","Shopping cart emptied.",JOptionPane.INFORMATION_MESSAGE);
				}
			});
			
		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSouth = new JPanel();
		mainPanel.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));	
		
		JPanel panelButton = new JPanel();
		panelSouth.add(panelButton);
		panelButton.setLayout(new GridLayout(2, 0, 0, 0));
		
		panelButton.add(btnEmptyShoppingCart);

		setVisible(true);
	}

}