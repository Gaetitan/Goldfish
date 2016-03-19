package com.polytech.goldfish.userinterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.polytech.goldfish.businesslogic.facade.PersonFacade;
import com.polytech.goldfish.util.GoldfishException;

public class CreatePersonPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final PersonFacade personFacade;

	private final JTextField tfName;
	private final JTextField tfSurname;
	private final JTextField tfPhoneNumber;
	private final JTextField tfEmail;
	private final JPasswordField tfPassword;
	private final JTextField tfStreetNumber;
	private final JTextField tfStreet;
	private final JTextField tfZipCode;
	private final JTextField tfCity;
	
	/**
	 * Constructor of class PanelCratePerson
	 */
	public CreatePersonPanel() {
		personFacade = new PersonFacade();
		
		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblWelcome = new JLabel("Add a new person");
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
			
		JLabel lblTypePerson = new JLabel("Type:");
		panelLabelInfo.add(lblTypePerson);
		
		JLabel lblSurname = new JLabel("Surname:");
		panelLabelInfo.add(lblSurname);
		
		JLabel lblName = new JLabel("Name:");
		panelLabelInfo.add(lblName);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		panelLabelInfo.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email:");
		panelLabelInfo.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		panelLabelInfo.add(lblPassword);
		
		JLabel lblStreetNumber = new JLabel("Street number:");
		panelLabelInfo.add(lblStreetNumber);
		
		JLabel lblStreet = new JLabel("Street:");
		panelLabelInfo.add(lblStreet);
		
		JLabel lblZipCode = new JLabel("Zip code:");
		panelLabelInfo.add(lblZipCode);
		
		JLabel lblCity = new JLabel("City:");
		panelLabelInfo.add(lblCity);
		
		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		final JComboBox<String> cbTypePerson = new JComboBox<>();
		cbTypePerson.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrator",  "User"}));
		cbTypePerson.setSelectedIndex(1);
		panelTextInfo.add(cbTypePerson);
		
		tfSurname = new JTextField();
		tfSurname.setColumns(20);
		panelTextInfo.add(tfSurname);
		
		tfName = new JTextField();
		panelTextInfo.add(tfName);

		tfPhoneNumber = new JTextField();
		panelTextInfo.add(tfPhoneNumber);
		
		tfEmail = new JTextField();
		panelTextInfo.add(tfEmail);
	
		tfPassword = new JPasswordField();
		panelTextInfo.add(tfPassword);
		
		tfStreetNumber = new JTextField();
		panelTextInfo.add(tfStreetNumber);
		
		tfStreet = new JTextField();
		panelTextInfo.add(tfStreet);
		
		tfZipCode = new JTextField();
		panelTextInfo.add(tfZipCode);
		
		tfCity = new JTextField();
		panelTextInfo.add(tfCity);
		
		JPanel panelSouth = new JPanel();
		mainPanel.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelButton = new JPanel();
		panelSouth.add(panelButton);
		panelButton.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnOk = new JButton("Create");
		btnOk.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Integer idPerson = null;
							
							if(!(tfSurname.getText().isEmpty() || tfName.getText().isEmpty() || tfPhoneNumber.getText().isEmpty() || tfEmail.getText().isEmpty() || tfPassword.getText().isEmpty() 
									|| tfStreet.getText().isEmpty() || tfStreetNumber.getText().isEmpty() || tfZipCode.getText().isEmpty() || tfCity.getText().isEmpty())){
								try {
									idPerson = personFacade.createPerson(cbTypePerson.getSelectedItem(), tfSurname.getText(), tfName.getText(), tfPhoneNumber.getText(), tfEmail.getText(), tfPassword.getText(), tfStreet.getText(), tfStreetNumber.getText(), tfZipCode.getText(), tfCity.getText());
									JOptionPane.showMessageDialog(null, personFacade.findPersonById(idPerson).getSurname() + " " + personFacade.findPersonById(idPerson).getName() + " has been created.",
											"Person created.",JOptionPane.INFORMATION_MESSAGE);
									reinitPanel();
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
	}
	
	public void reinitPanel(){
		tfCity.setText("");
		tfEmail.setText("");
		tfName.setText("");
		tfPassword.setText("");
		tfPhoneNumber.setText("");
		tfStreet.setText("");
		tfStreetNumber.setText("");
		tfSurname.setText("");
		tfZipCode.setText("");
	}
}
