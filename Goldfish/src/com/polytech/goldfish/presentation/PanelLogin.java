package com.polytech.goldfish.presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.polytech.goldfish.application.Login;

/**
 * Class for the login user interface
 * @author Gaetitano
 */
public class PanelLogin extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private final Login ctrlLogin;

	private final JTextField tfEmail;
	private final JPasswordField tfPassword;

	
	/**
	 * Constructor of class PanelLogin
	 */
	public PanelLogin(){
		ctrlLogin = new Login();
		
		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblWelcome = new JLabel("Welcome to Goldfish!");
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
		
		JLabel lblEmail = new JLabel("Email :");
		panelLabelInfo.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password :");
		panelLabelInfo.add(lblPassword);
		
		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		tfEmail = new JTextField();
		tfEmail.setToolTipText("Your email");
		panelTextInfo.add(tfEmail);
		
		tfPassword = new JPasswordField();
		tfPassword.setToolTipText("Your password");
		panelTextInfo.add(tfPassword);
		
		JPanel panelSouth = new JPanel();
		mainPanel.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelButton = new JPanel();
		panelSouth.add(panelButton);
		panelButton.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(ctrlLogin.authenticate(tfEmail.getText(), tfPassword.getText())) {
								System.out.println("OK PELO POMPELOP");
							}
							else{
								System.out.println("TA MERE");
							}
						}
					}
				);

		panelButton.add(btnLogin);
	}
	
}
