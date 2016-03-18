package com.polytech.goldfish.userinterface;

import javax.swing.JFrame;

/**
 * Main frame of our application
 * 
 * @author Ga�tan FRAN�OIS
 *
 */
public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final LoginPanel panelLogin;

	public LoginFrame(){
		panelLogin = new LoginPanel();
		this.getContentPane().add(panelLogin);
	}
	
}
