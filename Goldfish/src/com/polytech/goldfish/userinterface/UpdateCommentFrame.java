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
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.polytech.goldfish.businesslogic.facade.CommentFacade;
import com.polytech.goldfish.util.GoldfishException;

/**
 * Class for a frame used to sign up
 * 
 * @author Ga�tan FRAN�OIS
 */
public class UpdateCommentFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private final CommentFacade commentFacade;

	private final JTextArea tfText;

	/**
	 * Instantiates a new frame to update or delete a comment
	 */

	public UpdateCommentFrame(final Integer idComment, final Integer idUser) {

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Update/Delete a comment.");

		getContentPane().setPreferredSize(new Dimension(500, 200));
		getContentPane().setLayout(null);
		pack();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);

		setResizable(false);

		commentFacade = new CommentFacade();

		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblWelcome = new JLabel("Comment");
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

		JLabel lblNewText = new JLabel("New text of comment:");
		panelLabelInfo.add(lblNewText);

		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));

		tfText = new JTextArea(5, 20);
		tfText.setColumns(20);
		tfText.setText(commentFacade.findCommentById(idComment).getText());
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
							try {
								id = commentFacade.updateComment(idComment, tfText.getText());
								JOptionPane.showMessageDialog(null,"The comment has been updated.",
										"Comment updated.",JOptionPane.INFORMATION_MESSAGE);
							} catch (GoldfishException blankFields) {
								JOptionPane.showMessageDialog(null, blankFields.toString(),
										"Blank fields.",JOptionPane.INFORMATION_MESSAGE);
							}
							
						}
					}
				);
		 
		panelButton.add(btnOk);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer id = null;
				try {
					commentFacade.deleteComment(idComment);
					JOptionPane.showMessageDialog(null, "This comment has been deleted.",
							"comment deleted.",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				catch (GoldfishException e1) {
					JOptionPane.showMessageDialog(null, e1.toString(),
							"Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		panelButton.add(btnDelete);

		setContentPane(mainPanel);
		setVisible(true);
	}

	public void reinitPanel() {
		tfText.setText("");
	}
}
