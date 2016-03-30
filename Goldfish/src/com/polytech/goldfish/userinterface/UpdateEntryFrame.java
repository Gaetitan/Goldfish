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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.polytech.goldfish.businesslogic.facade.DiaryFacade;
import com.polytech.goldfish.util.GoldfishException;


/**
 * Class for a frame used to sign up
 * 
 * @author
 */
public class UpdateEntryFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private final DiaryFacade diaryFacade;

	private final JTextField tfNewName;
	private final JCheckBox NewVisibilityCheckBox;

	/**
	 * Instantiates a new frame to update an activity.
	 */
	public UpdateEntryFrame(final Integer idEntry) {

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Update a diary entry");

		getContentPane().setPreferredSize(new Dimension(300, 250));
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

		JLabel lblWelcome = new JLabel("Entry informations");
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

		JLabel lblName = new JLabel("New name:");
		panelLabelInfo.add(lblName);

		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));

		tfNewName = new JTextField();
		panelTextInfo.add(tfNewName);

		NewVisibilityCheckBox = new JCheckBox("Visible ?");
		panelLabelInfo.add(NewVisibilityCheckBox);
		NewVisibilityCheckBox.setSelected(false);

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
						if(!(tfNewName.getText().isEmpty())){	
							try {
								id = diaryFacade.updateEntry(idEntry, tfNewName.getText(), NewVisibilityCheckBox.isSelected());
								JOptionPane.showMessageDialog(null, "Entry has been updated.",
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

		JButton btnDel = new JButton("Delete this entry");
		btnDel.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Integer id = null;
						try {
							id = diaryFacade.deleteEntry(idEntry);
							JOptionPane.showMessageDialog(null, "The entry has been deleted.",
									"Activity deleted.",JOptionPane.INFORMATION_MESSAGE);
						} 
						catch (GoldfishException e1) {
							JOptionPane.showMessageDialog(null, e1.toString(),
									"Error.",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				);

		panelButton.add(btnDel);

		setContentPane(mainPanel);
		setVisible(true);
	}

	public void reinitPanel(){
		tfNewName.setText("");
	}
}


