package com.polytech.goldfish.userinterface;

import javax.swing.JFrame;

/**
 * Main frame of our application
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final LoginPanel panelLogin;
	private final CreatePersonPanel panelCreatePerson;

	public MainFrame(){
		panelLogin = new LoginPanel();
		panelCreatePerson = new CreatePersonPanel();
		this.getContentPane().add(panelLogin);
	}
	
}
