package com.polytech.goldfish.presentation;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelLogin panelLogin;

	public MainFrame(){
		panelLogin = new PanelLogin();
		this.getContentPane().add(panelLogin);
	}
	
}
