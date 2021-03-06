package com.polytech.goldfish.userinterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.polytech.goldfish.businesslogic.facade.PersonFacade;
import com.polytech.goldfish.businesslogic.facade.ProductCategoryFacade;
import com.polytech.goldfish.util.GoldfishException;


/**
 * Class for a frame used to sign up
 * 
 * @author
 */
public class UpdateProductCategoryFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private final ProductCategoryFacade productCategoryFacade;
	private final PersonFacade personFacade;
	private final JTextField tfName;
	private final JPasswordField tfPassword;
	
	/**
	 * Instantiates a new frame to sign up.
	 */
	public UpdateProductCategoryFrame(final Integer idProductCategory, final Integer idPerson) {
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Update Product Category");

		getContentPane().setPreferredSize(new Dimension(300, 250));
		getContentPane().setLayout(null);
		pack();
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		
		setResizable(false);

		productCategoryFacade = new ProductCategoryFacade();
		personFacade = new PersonFacade();
		
		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblWelcome = new JLabel("Product Category");
		panelNorth.add(lblWelcome);
		
		JPanel panelCenter = new JPanel();
		mainPanel.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInfo = new JPanel();
		panelCenter.add(panelInfo, BorderLayout.NORTH);
		panelInfo.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLabelInfo = new JPanel();
		panelInfo.add(panelLabelInfo, BorderLayout.WEST);
		panelLabelInfo.setLayout(new GridLayout(0, 1, 0, 0));
				
		JLabel lblName = new JLabel("Name:");
		panelLabelInfo.add(lblName);
		
		JLabel lblPassword = new JLabel("Type your password to validate:");
		panelLabelInfo.add(lblPassword);
		
		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		tfName = new JTextField();
		tfName.setText(productCategoryFacade.findProductCategoryById(idProductCategory).getName());
		panelTextInfo.add(tfName);

		tfPassword = new JPasswordField();
		panelTextInfo.add(tfPassword);
		
		JPanel panelSouth = new JPanel();
		mainPanel.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelButton = new JPanel();
		panelSouth.add(panelButton);
		panelButton.setLayout(new GridLayout(2, 0, 0, 0));
		
		JButton btnOk = new JButton("Update my information");
		btnOk.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Integer id = null;
							if(!(tfName.getText().isEmpty() || tfPassword.getText().isEmpty())){	
								try {
									personFacade.verifyPasswordById(idPerson, tfPassword.getText());
									id = productCategoryFacade.updateProductCategory(idProductCategory, tfName.getText());
									JOptionPane.showMessageDialog(null, productCategoryFacade.findProductCategoryById(id).getName() + ", your information has been updated.",
											"Information updated.",JOptionPane.INFORMATION_MESSAGE);
								} 
								catch (GoldfishException e1) {
									JOptionPane.showMessageDialog(null, e1.toString(),
											"Error.",JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Please fill all the fields.",
										"Blank fields.",JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				);
		 
		panelButton.add(btnOk);
		
		JButton btnDel = new JButton("Delete this Product Category");
		btnDel.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Integer id = null;
							if(!(tfName.getText().isEmpty() || tfPassword.getText().isEmpty())){	
								try {
									personFacade.verifyPasswordById(idPerson, tfPassword.getText());
									id = productCategoryFacade.deleteProductCategory(idProductCategory);
									JOptionPane.showMessageDialog(null, "Product Category has been deleted.",
											"Information updated.",JOptionPane.INFORMATION_MESSAGE);
								} 
								catch (GoldfishException e1) {
									JOptionPane.showMessageDialog(null, e1.toString(),
											"Error.",JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Please fill all the fields.",
										"Blank fields.",JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				);
		 
		panelButton.add(btnDel);
		
		setContentPane(mainPanel);
		setVisible(true);
	}
	
	public void reinitPanel(){
		tfName.setText("");
		tfPassword.setText("");
	}
}

