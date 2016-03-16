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
	private final LoginPanel loginPanel;
	private final CreatePersonPanel createPersonPanel;
	private final ListPersonsPanel listPersonsPanel;
	
	public MainFrame(){
		loginPanel = new LoginPanel();
		createPersonPanel = new CreatePersonPanel();
		listPersonsPanel = new ListPersonsPanel();
		this.getContentPane().add(listPersonsPanel);
	}
	
}
