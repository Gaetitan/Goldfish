package com.polytech.goldfish.userinterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.polytech.goldfish.businesslogic.facade.DiaryFacade;
import com.polytech.goldfish.util.GoldfishException;

/**
 * Class for a frame used to sign up
 * 
 * @author Ga�tan FRAN�OIS
 */
public class UpdateEntryFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private final DiaryFacade diaryFacade;

	private final JTextArea tfText;

	/**
	 * Instantiates a new frame to update or delete a comment
	 */

	public UpdateEntryFrame(final Integer idEntry) {

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Update/Delete an entry.");

		getContentPane().setPreferredSize(new Dimension(500, 200));
		getContentPane().setLayout(null);
		pack();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);

		setResizable(false);

		diaryFacade = new DiaryFacade();

		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblWelcome = new JLabel("Entry");
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

		JLabel lblNewText = new JLabel("New name of entry:");
		panelLabelInfo.add(lblNewText);

		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));

		tfText = new JTextArea(5, 20);
		tfText.setColumns(20);
		tfText.setText(diaryFacade.findEntryById(idEntry).getName());
		panelTextInfo.add(tfText);
		
		final JCheckBox visibilityCheckBox = new JCheckBox("Visible ?");
		panelLabelInfo.add(visibilityCheckBox);
		visibilityCheckBox.setSelected(false);

		JPanel panelSouth = new JPanel();
		mainPanel.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panelButton = new JPanel();
		panelSouth.add(panelButton);
		panelButton.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnOk = new JButton("Update");
		btnOk.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Integer id;
							try {
								id = diaryFacade.updateEntry(idEntry, tfText.getText(), visibilityCheckBox.isSelected());
								JOptionPane.showMessageDialog(null,"The entry has been updated.",
										"entry updated.",JOptionPane.INFORMATION_MESSAGE);
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
					diaryFacade.deleteEntry(idEntry);
					JOptionPane.showMessageDialog(null, "This entry has been deleted.",
							"entry deleted.",
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
