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
	private final CreateActivityPanel panelCreateActivity;

	public MainFrame(){
		panelLogin = new LoginPanel();
		panelCreateActivity = new CreateActivityPanel();
		this.getContentPane().add(panelLogin);
	}
	
}
