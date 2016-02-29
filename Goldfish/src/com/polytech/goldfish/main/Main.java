package com.polytech.goldfish.main;

import javax.swing.JFrame;

import com.polytech.goldfish.presentation.MainFrame;

public class Main {

	public static void main(String[] args) {
		MainFrame myFrame = new MainFrame();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setTitle("Goldfish project");
		myFrame.setSize(600, 500);
		myFrame.setVisible(true);
	}

}
