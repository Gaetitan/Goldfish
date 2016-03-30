package com.polytech.goldfish.userinterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.polytech.goldfish.businesslogic.facade.ActivityFacade;
import com.polytech.goldfish.businesslogic.facade.PersonFacade;
import com.polytech.goldfish.util.GoldfishException;


/**
 * Class for a frame used to update and delete an activity
 * 
 * @author
 */
public class UpdateActivityFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private final ActivityFacade activityFacade;
	private final PersonFacade personFacade;
	private final JTextField tfName;
	private final JTextField tfDescription;
	private final JPasswordField tfPassword;
	
	/**
	 * Instantiates a new frame to update an activity.
	 */
	public UpdateActivityFrame(final Integer idActivity, final Integer idPerson) {
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Update an activity");

		getContentPane().setPreferredSize(new Dimension(500, 250));
		getContentPane().setLayout(null);
		pack();
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		
		setResizable(false);

		activityFacade = new ActivityFacade();
		personFacade = new PersonFacade();
		
		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblWelcome = new JLabel("Activity information");
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
		
		JLabel lblPassword = new JLabel("Type your password to validate:");
		panelLabelInfo.add(lblPassword);
		
		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		tfName = new JTextField();
		tfName.setText(activityFacade.findActivityById(idActivity).getName());
		panelTextInfo.add(tfName);
		
		tfDescription = new JTextField();
		tfDescription.setText(activityFacade.findActivityById(idActivity).getDescription());
		panelTextInfo.add(tfDescription);

		tfPassword = new JPasswordField();
		panelTextInfo.add(tfPassword);
		
		JPanel panelSouth = new JPanel();
		mainPanel.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelButton = new JPanel();
		panelSouth.add(panelButton);
		panelButton.setLayout(new GridLayout(2, 0, 0, 0));
		
		JButton btnOk = new JButton("Update the activity");
		btnOk.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Integer id = null;
							if(!(tfName.getText().isEmpty() || tfDescription.getText().isEmpty() || tfPassword.getText().isEmpty())){	
								try {
									personFacade.verifyPasswordById(idPerson, tfPassword.getText());
									id = activityFacade.updateActivity(idActivity, tfName.getText(),tfDescription.getText());
									JOptionPane.showMessageDialog(null, activityFacade.findActivityById(id).getName() + " has been updated.",
											"Activity updated.",JOptionPane.INFORMATION_MESSAGE);
								} 
								catch (GoldfishException e1) {
									JOptionPane.showMessageDialog(null, e1.toString(),
											"Error.",JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Please fill all the fields.",
										"Blank fields.",JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				);
		 
		panelButton.add(btnOk);
		
		JButton btnDel = new JButton("Delete this activity");
		btnDel.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Integer id = null;
							if(!(tfName.getText().isEmpty() || tfDescription.getText().isEmpty() || tfPassword.getText().isEmpty())){	
								try {
									personFacade.verifyPasswordById(idPerson, tfPassword.getText());
									id = activityFacade.deleteActivity(idActivity);
									JOptionPane.showMessageDialog(null, "The activity has been deleted.",
											"Activity deleted.",JOptionPane.INFORMATION_MESSAGE);
								} 
								catch (GoldfishException e1) {
									JOptionPane.showMessageDialog(null, e1.toString(),
											"Error.",JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Please fill all the fields.",
										"Blank fields.",JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				);
		 
		panelButton.add(btnDel);
		
		setContentPane(mainPanel);
		setVisible(true);
	}
	
	public void reinitPanel(){
		tfName.setText("");
		tfDescription.setText("");
		tfPassword.setText("");
	}
}