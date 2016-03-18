package com.polytech.goldfish.userinterface;

import javax.swing.JFrame;

/**
 * Main frame of our application
 * 
 * @author Ga�tan FRAN�OIS
 * 
 */
public class MainFrameOLD extends JFrame {

	private static final long serialVersionUID = 1L;
	private final LoginPanel loginPanel;
	private final CreatePersonPanel createPersonPanel;
	private final ListPersonsPanel listPersonsPanel;
	private final UpdatePersonPanel updatePersonPanel;

	public MainFrameOLD() {
		loginPanel = new LoginPanel();
		createPersonPanel = new CreatePersonPanel();
		listPersonsPanel = new ListPersonsPanel();
		updatePersonPanel = new UpdatePersonPanel();
		this.getContentPane().add(loginPanel);
	}

}