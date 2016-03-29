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

import com.polytech.goldfish.businesslogic.facade.ActivityCategoryFacade;
import com.polytech.goldfish.util.GoldfishException;

public class DeleteActivityCategoryPanel extends JPanel  {
	
	private static final long serialVersionUID = 1L;

	private final ActivityCategoryFacade activityCategoryFacade;

	private final JTextField tfName;
	private final JTextField tfShortDescription;
	private final JTextField tfDetailledDescription;
	
	/**
	 * Constructor of class PanelDeleteActivityCategory
	 */
	public DeleteActivityCategoryPanel() {
		activityCategoryFacade = new ActivityCategoryFacade();
		
		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblWelcome = new JLabel("Delete an activity category");
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
		
		JLabel lblShortDescription = new JLabel("Short Description:");
		panelLabelInfo.add(lblShortDescription);
		
		JLabel lblDetailledDescription = new JLabel("Detailled Description:");
		panelLabelInfo.add(lblDetailledDescription);
		
		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		tfName = new JTextField();
		tfName.setColumns(20);
		tfName.setText(activityCategoryFacade.findActivityCategoryById(1).getName());
		panelTextInfo.add(tfName);
		
		tfShortDescription = new JTextField();
		tfShortDescription.setText(activityCategoryFacade.findActivityCategoryById(1).getShort_description());
		panelTextInfo.add(tfShortDescription);
		
		tfDetailledDescription = new JTextField();
		tfDetailledDescription.setText(activityCategoryFacade.findActivityCategoryById(1).getDetailed_description());
		panelTextInfo.add(tfDetailledDescription);
		
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
							Integer id;
							try {
								id = activityCategoryFacade.deleteActivityCategory(1);
								JOptionPane.showMessageDialog(null,"The activity category has been deleted.",
										"Activity category deleted.",JOptionPane.INFORMATION_MESSAGE);
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
		tfShortDescription.setText("");
		tfDetailledDescription.setText("");
		//this.setVisible(false);
	}

}