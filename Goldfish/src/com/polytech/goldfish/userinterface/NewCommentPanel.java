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

import com.polytech.goldfish.businesslogic.facade.CommentFacade;
import com.polytech.goldfish.util.GoldfishException;

public class NewCommentPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final CommentFacade commentFacade;

	private final JTextField tfConcernedID;
	private final JTextField tfText;
	private final JTextField tfYourID;
	
	/**
	 * Constructor of class PanelCratePerson
	 */
	public NewCommentPanel() {
		commentFacade = new CommentFacade();
		
		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblWelcome = new JLabel("Add a new comment");
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
				
		JLabel lblSurname = new JLabel("ID of concerned person:");
		panelLabelInfo.add(lblSurname);
		
		JLabel lblName = new JLabel("Comment:");
		panelLabelInfo.add(lblName);
		
		JLabel lblPhoneNumber = new JLabel("Your ID:");
		panelLabelInfo.add(lblPhoneNumber);
		
		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		tfConcernedID = new JTextField();
		tfConcernedID.setColumns(20);
		//tfSurname.setText(personFacade.findPersonById(5).getSurname());
		panelTextInfo.add(tfConcernedID);
		
		tfText = new JTextField();
		//tfName.setText(personFacade.findPersonById(5).getName());
		panelTextInfo.add(tfText);

		tfYourID = new JTextField();
		//tfYourID.setText((personFacade.findPersonById(5).getId()).toString());
		panelTextInfo.add(tfYourID);

		
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
							if(!(tfConcernedID.getText().isEmpty() || tfText.getText().isEmpty() || tfYourID.getText().isEmpty())){	
								try {
									id = commentFacade.createComment(tfText.getText(), Integer.parseInt(tfConcernedID.getText()) , Integer.parseInt(tfYourID.getText()));
								} catch (NumberFormatException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (GoldfishException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(null, "Comment has been created.", "Comment created.",JOptionPane.INFORMATION_MESSAGE);
								reinitPanel();
							}
							else {
								JOptionPane.showMessageDialog(null, "Please fill all the fields.",
										"Blank fields.",JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				);
		 
		panelButton.add(btnOk);
	}
	
	public void reinitPanel(){
		tfConcernedID.setText("");
		tfText.setText("");
		tfYourID.setText("");
	}
}
