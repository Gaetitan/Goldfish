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
	private final PanelLogin panelLogin;

	public MainFrame(){
		panelLogin = new PanelLogin();
		this.getContentPane().add(panelLogin);
	}
	
}
