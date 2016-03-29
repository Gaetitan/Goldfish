package com.polytech.goldfish.userinterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.polytech.goldfish.businesslogic.facade.ActivityFacade;
import com.polytech.goldfish.util.GoldfishException;

public class CreateActivityPanel extends JPanel {

	private final ActivityFacade activityFacade;
	
	private final JTextField tfName;
	private final JTextField tfDescription;
	
	/**
	 * Constructor of class PanelCreateActivity
	 */
	public CreateActivityPanel() {
		activityFacade = new ActivityFacade();
		
		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblWelcome = new JLabel("Add a new activity");
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
		
		JLabel lblName = new JLabel("Name:");
		panelLabelInfo.add(lblName);
		
		JLabel lblDescription = new JLabel("Description:");
		panelLabelInfo.add(lblDescription);
		
		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		tfName = new JTextField();
		tfName.setColumns(20);
		panelTextInfo.add(tfName);
		
		tfDescription = new JTextField();
		panelTextInfo.add(tfDescription);
		
		JPanel panelSouth = new JPanel();
		mainPanel.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelButton = new JPanel();
		panelSouth.add(panelButton);
		panelButton.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Integer idActivity = null;
							try {
								idActivity = activityFacade.createActivity(tfName.getText(), tfDescription.getText(), 1);
								JOptionPane.showMessageDialog(null,"The activity " + activityFacade.findActivityById(idActivity).getName() + " has been created.",
										"Activity created.",JOptionPane.INFORMATION_MESSAGE);
							} catch (GoldfishException blankFields) {
								JOptionPane.showMessageDialog(null, blankFields.toString(),
										"Blank fields.",JOptionPane.INFORMATION_MESSAGE);
							}
							
						}
					}
				);

		panelButton.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							reinitPanel();
						}
					}
				);

		panelButton.add(btnCancel);
	}
	
	public void reinitPanel(){
		tfName.setText("");
		tfDescription.setText("");
		//this.setVisible(false);
	}
}

