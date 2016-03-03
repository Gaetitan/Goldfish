package com.polytech.goldfish.main;

import javax.swing.JFrame;

import com.polytech.goldfish.userinterface.MainFrame;

/**
 * Main class of our application
 *
 * @author Gaëtan FRANÇOIS
 *
 */
public class Main {

	public static void main(String[] args) {
		MainFrame myFrame = new MainFrame();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setTitle("Goldfish");
		myFrame.setSize(600, 500);
		myFrame.setVisible(true);
	}

}
