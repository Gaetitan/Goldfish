package com.polytech.goldfish.userinterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.polytech.goldfish.businesslogic.facade.DiaryFacade;
import com.polytech.goldfish.util.GoldfishException;

public class CreateDiaryEntryPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final DiaryFacade diaryEntryFacade;

	private final JTextField tfName;
	
	/**
	 * Constructor of class PanelCreateWishlist
	 */
	public CreateDiaryEntryPanel(final Integer idPerson) {
		diaryEntryFacade = new DiaryFacade();
		
		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblWelcome = new JLabel("Add a new diary entry");
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
		
		final JCheckBox visibilityCheckBox = new JCheckBox("Visible ?");
		panelLabelInfo.add(visibilityCheckBox);
		visibilityCheckBox.setSelected(false);
		
		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		tfName = new JTextField();
		tfName.setColumns(20);
		panelTextInfo.add(tfName);
				
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
							int id;
							try {
								id = diaryEntryFacade.createEntry(idPerson, tfName.getText(), visibilityCheckBox.isSelected());
								JOptionPane.showMessageDialog(null, tfName.getText() + " has been created.",
										"Entry created.",JOptionPane.INFORMATION_MESSAGE);
							} catch (GoldfishException e1) {
								JOptionPane.showMessageDialog(null, e1.toString(),
										"Error.", JOptionPane.ERROR_MESSAGE);
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
		
	}

}
