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

	JPanel panelLabelInfo;
	JPanel panelTextInfo;
	
	private final JTextField tfName;
	private final JTextField tfSurname;
	private final JTextField tfPhoneNumber;
	private final JTextField tfEmail;
	private final JPasswordField tfPassword;
	private final JTextField tfStreetNumber;
	private final JTextField tfStreet;
	private final JTextField tfZipCode;
	private final JTextField tfCity;
	private final JTextField tfShopname;
	private final JTextField tfDescription;
	private final JTextField tfSiret;
	private final JTextField tfActivitydomain;
	private final JTextField tfWebAddress;
	
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
		
		panelLabelInfo = new JPanel();
		panelInfo.add(panelLabelInfo, BorderLayout.WEST);
		panelLabelInfo.setLayout(new GridLayout(0, 1, 0, 0));
			
		final JLabel lblTypePerson = new JLabel("Type:");
		panelLabelInfo.add(lblTypePerson);
		
		final JLabel lblSurname = new JLabel("Surname:");
		panelLabelInfo.add(lblSurname);
		
		final JLabel lblName = new JLabel("Name:");
		panelLabelInfo.add(lblName);
		
		final JLabel lblPhoneNumber = new JLabel("Phone number:");
		panelLabelInfo.add(lblPhoneNumber);
		
		final JLabel lblEmail = new JLabel("Email:");
		panelLabelInfo.add(lblEmail);
		
		final JLabel lblPassword = new JLabel("Password:");
		panelLabelInfo.add(lblPassword);
		
		final JLabel lblStreetNumber = new JLabel("Street number:");
		panelLabelInfo.add(lblStreetNumber);
		
		final JLabel lblStreet = new JLabel("Street:");
		panelLabelInfo.add(lblStreet);
		
		final JLabel lblZipCode = new JLabel("Zip code:");
		panelLabelInfo.add(lblZipCode);
		
		final JLabel lblCity = new JLabel("City:");
		panelLabelInfo.add(lblCity);
		
		panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		final JComboBox<String> cbTypePerson = new JComboBox<>();
		cbTypePerson.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrator", "Seller", "User"}));
		cbTypePerson.setSelectedIndex(2);
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
		
		// For a seller
		final JLabel lblShopname = new JLabel("Shop name:");
		final JLabel lblDescription = new JLabel("Description:");
		final JLabel lblSiret = new JLabel("SIRET:");
		final JLabel lblActivitydomain = new JLabel("Activity domain:");
		final JLabel lblWebAddress = new JLabel("Web address:");
		tfShopname = new JTextField();
		tfDescription = new JTextField();
		tfSiret = new JTextField();
		tfActivitydomain = new JTextField();
		tfWebAddress = new JTextField();
		
		cbTypePerson.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(cbTypePerson.getSelectedItem().equals("Seller")){
							panelLabelInfo.add(lblTypePerson);
							panelLabelInfo.add(lblSurname);
							panelLabelInfo.add(lblName);
							panelLabelInfo.add(lblPhoneNumber);
							panelLabelInfo.add(lblEmail);
							panelLabelInfo.add(lblPassword);
							panelLabelInfo.add(lblStreetNumber);
							panelLabelInfo.add(lblStreet);
							panelLabelInfo.add(lblZipCode);
							panelLabelInfo.add(lblCity);
							panelLabelInfo.add(lblShopname);
							panelLabelInfo.add(lblDescription);
							panelLabelInfo.add(lblSiret);
							panelLabelInfo.add(lblActivitydomain);
							panelLabelInfo.add(lblWebAddress);
							panelTextInfo.add(cbTypePerson);
							tfSurname.setColumns(20);
							panelTextInfo.add(tfSurname);
							panelTextInfo.add(tfName);
							panelTextInfo.add(tfPhoneNumber);
							panelTextInfo.add(tfEmail);
							panelTextInfo.add(tfPassword);
							panelTextInfo.add(tfStreetNumber);
							panelTextInfo.add(tfStreet);
							panelTextInfo.add(tfZipCode);
							panelTextInfo.add(tfCity);
							panelTextInfo.add(tfShopname);
							panelTextInfo.add(tfDescription);
							panelTextInfo.add(tfSiret);
							panelTextInfo.add(tfActivitydomain);
							panelTextInfo.add(tfWebAddress);
							
							panelLabelInfo.revalidate();
							panelLabelInfo.repaint();
							panelTextInfo.revalidate();
							panelTextInfo.repaint();
						}
						else {
							panelLabelInfo.add(lblTypePerson);
							panelLabelInfo.add(lblSurname);
							panelLabelInfo.add(lblName);
							panelLabelInfo.add(lblPhoneNumber);
							panelLabelInfo.add(lblEmail);
							panelLabelInfo.add(lblPassword);
							panelLabelInfo.add(lblStreetNumber);
							panelLabelInfo.add(lblStreet);
							panelLabelInfo.add(lblZipCode);
							panelLabelInfo.add(lblCity);
							panelTextInfo.add(cbTypePerson);
							panelLabelInfo.remove(lblShopname);
							panelLabelInfo.remove(lblDescription);
							panelLabelInfo.remove(lblSiret);
							panelLabelInfo.remove(lblActivitydomain);
							panelLabelInfo.remove(lblWebAddress);
							panelTextInfo.add(cbTypePerson);
							tfSurname.setColumns(20);
							panelTextInfo.add(tfSurname);
							panelTextInfo.add(tfName);
							panelTextInfo.add(tfPhoneNumber);
							panelTextInfo.add(tfEmail);
							panelTextInfo.add(tfPassword);
							panelTextInfo.add(tfStreetNumber);
							panelTextInfo.add(tfStreet);
							panelTextInfo.add(tfZipCode);
							panelTextInfo.add(tfCity);
							panelTextInfo.remove(tfShopname);
							panelTextInfo.remove(tfDescription);
							panelTextInfo.remove(tfSiret);
							panelTextInfo.remove(tfActivitydomain);
							panelTextInfo.remove(tfWebAddress);
							
							panelLabelInfo.revalidate();
							panelLabelInfo.repaint();
							panelTextInfo.revalidate();
							panelTextInfo.repaint();
						}
						
					}
				});
		
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
							if(cbTypePerson.getSelectedItem().equals("Seller")){
								if(!(tfSurname.getText().isEmpty() || tfName.getText().isEmpty() || tfPhoneNumber.getText().isEmpty() || tfEmail.getText().isEmpty() || tfPassword.getText().isEmpty() 
										|| tfStreet.getText().isEmpty() || tfStreetNumber.getText().isEmpty() || tfZipCode.getText().isEmpty() || tfCity.getText().isEmpty()
										|| tfShopname.getText().isEmpty() || tfDescription.getText().isEmpty() || tfSiret.getText().isEmpty() || tfActivitydomain.getText().isEmpty() || tfWebAddress.getText().isEmpty())){
									try {
										idPerson = personFacade.createPerson(cbTypePerson.getSelectedItem(), tfSurname.getText(), tfName.getText(), tfPhoneNumber.getText(), tfEmail.getText(), tfPassword.getText(), tfStreet.getText(), tfStreetNumber.getText(), tfZipCode.getText(), tfCity.getText(),
												tfShopname.getText(), tfDescription.getText(), tfSiret.getText(), tfActivitydomain.getText(), tfWebAddress.getText());
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
							else{
								if(!(tfSurname.getText().isEmpty() || tfName.getText().isEmpty() || tfPhoneNumber.getText().isEmpty() || tfEmail.getText().isEmpty() || tfPassword.getText().isEmpty() 
										|| tfStreet.getText().isEmpty() || tfStreetNumber.getText().isEmpty() || tfZipCode.getText().isEmpty() || tfCity.getText().isEmpty())){
									try {
										idPerson = personFacade.createPerson(cbTypePerson.getSelectedItem(), tfSurname.getText(), tfName.getText(), tfPhoneNumber.getText(), tfEmail.getText(), tfPassword.getText(), tfStreet.getText(), tfStreetNumber.getText(), tfZipCode.getText(), tfCity.getText(),
												null, null, null, null, null);
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
		tfShopname.setText("");
		tfDescription.setText("");
		tfSiret.setText("");
		tfActivitydomain.setText("");
		tfWebAddress.setText("");
	}
}
