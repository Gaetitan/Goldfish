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

public class CreateCommentPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final CommentFacade commentFacade;

	private final JTextField tfConcernedID;
	private final JTextField tfText;

	/**
	 * Constructor of class PanelCratePerson
	 */
	public CreateCommentPanel(final Integer idPerson) {
		commentFacade = new CommentFacade();

		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewComment = new JLabel("Add a new comment");
		panelNorth.add(lblNewComment);

		JPanel panelCenter = new JPanel();
		mainPanel.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));

		JPanel panelInfo = new JPanel();
		panelCenter.add(panelInfo, BorderLayout.NORTH);
		panelInfo.setLayout(new BorderLayout(0, 0));

		JPanel panelLabelInfo = new JPanel();
		panelInfo.add(panelLabelInfo, BorderLayout.WEST);
		panelLabelInfo.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblConcernedIdPerson = new JLabel("Email of concerned person:");
		panelLabelInfo.add(lblConcernedIdPerson);

		JLabel lblComment = new JLabel("Comment:");
		panelLabelInfo.add(lblComment);

		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));

		tfConcernedID = new JTextField();
		tfConcernedID.setColumns(20);
		panelTextInfo.add(tfConcernedID);

		tfText = new JTextField();
		panelTextInfo.add(tfText);


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
						if(!(tfConcernedID.getText().isEmpty() || tfText.getText().isEmpty() )){	
							try {
								id = commentFacade.createComment(tfText.getText(), idPerson, tfConcernedID.getText());
								JOptionPane.showMessageDialog(null, "Comment has been created.", "Comment created.",JOptionPane.INFORMATION_MESSAGE);
								reinitPanel();
							} catch (GoldfishException e1) {
								JOptionPane.showMessageDialog(null, e1.toString(),
										"Error.", JOptionPane.ERROR_MESSAGE);
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
	}

	public void reinitPanel(){
		tfConcernedID.setText("");
		tfText.setText("");
	}
}