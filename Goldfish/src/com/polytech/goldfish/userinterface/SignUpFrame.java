package com.polytech.goldfish.userinterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.polytech.goldfish.businesslogic.facade.PersonFacade;
import com.polytech.goldfish.util.GoldfishException;


/**
 * Class for a frame used to sign up
 * 
 * @author Ga�tan FRAN�OIS
 */
public class SignUpFrame extends JFrame implements ActionListener, KeyListener {

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
	private final JButton btnOk;

	/**
	 * Instantiates a new frame to sign up.
	 */
	public SignUpFrame() {
		personFacade = new PersonFacade();
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Sign up");

		getContentPane().setPreferredSize(new Dimension(300, 250));
		getContentPane().setLayout(null);
		pack();
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		
		setResizable(false);
		
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
		
		btnOk = new JButton("Create");
		btnOk.addActionListener(this);

		panelButton.add(btnOk);
		
		setContentPane(mainPanel);
		setVisible(true);
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk) {
			Integer idPerson = null;
			
			if(!(tfSurname.getText().isEmpty() || tfName.getText().isEmpty() || tfPhoneNumber.getText().isEmpty() || tfEmail.getText().isEmpty() || tfPassword.getText().isEmpty() 
					|| tfStreet.getText().isEmpty() || tfStreetNumber.getText().isEmpty() || tfZipCode.getText().isEmpty() || tfCity.getText().isEmpty())){
				try {
					idPerson = personFacade.createPerson("User", tfSurname.getText(), tfName.getText(), tfPhoneNumber.getText(), tfEmail.getText(), tfPassword.getText(), tfStreet.getText(), tfStreetNumber.getText(), tfZipCode.getText(), tfCity.getText(),
							null, null, null, null, null);
					JOptionPane.showMessageDialog(null, personFacade.findPersonById(idPerson).getSurname() + " " + personFacade.findPersonById(idPerson).getName() + " has been created.",
							"Person created.",JOptionPane.INFORMATION_MESSAGE);
					reinitPanel();
					this.dispose();
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

