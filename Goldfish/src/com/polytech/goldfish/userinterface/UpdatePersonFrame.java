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

import com.polytech.goldfish.businesslogic.facade.AddressFacade;
import com.polytech.goldfish.businesslogic.facade.PersonFacade;
import com.polytech.goldfish.businesslogic.facade.SellerFacade;
import com.polytech.goldfish.util.GoldfishException;

/**
 * Class for a frame used to sign up
 * 
 * @author Gaëtan FRANÇOIS
 */
public class UpdatePersonFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private final PersonFacade personFacade;
	private final AddressFacade addressFacade;
	private final SellerFacade sellerFacade;

	private final JTextField tfName;
	private final JTextField tfSurname;
	private final JTextField tfPhoneNumber;
	private final JTextField tfEmail;
	private final JPasswordField tfPassword;
	private final JTextField tfStreetNumber;
	private final JTextField tfStreet;
	private final JTextField tfZipCode;
	private final JTextField tfCity;
	private JTextField tfShopname;
	private JTextField tfDescription;
	private JTextField tfSiret;
	private JTextField tfActivitydomain;
	private JTextField tfWebaddress;

	/**
	 * Instantiates a new frame to update or delete a Person
	 */
	public UpdatePersonFrame(final Integer idAdministrator, final Integer idPerson) {

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Update/Delete a person.");

		getContentPane().setPreferredSize(new Dimension(350, 375));
		getContentPane().setLayout(null);
		pack();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);

		setResizable(false);

		personFacade = new PersonFacade();
		addressFacade = new AddressFacade();
		sellerFacade = new SellerFacade();

		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JPanel panelNorth = new JPanel();
		mainPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblWelcome = new JLabel("Person's information");
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

		JLabel lblSurname = new JLabel("Surname:");
		panelLabelInfo.add(lblSurname);

		JLabel lblName = new JLabel("Name:");
		panelLabelInfo.add(lblName);

		JLabel lblPhoneNumber = new JLabel("Phone number:");
		panelLabelInfo.add(lblPhoneNumber);

		JLabel lblEmail = new JLabel("Email:");
		panelLabelInfo.add(lblEmail);

		JLabel lblStreetNumber = new JLabel("Street number:");
		panelLabelInfo.add(lblStreetNumber);

		JLabel lblStreet = new JLabel("Street:");
		panelLabelInfo.add(lblStreet);

		JLabel lblZipCode = new JLabel("Zip code:");
		panelLabelInfo.add(lblZipCode);

		JLabel lblCity = new JLabel("City:");
		panelLabelInfo.add(lblCity);

		JLabel lblPassword = new JLabel("Type your password to validate:");

		final JLabel lblShopname = new JLabel("Shopname:");
		final JLabel lblDescription = new JLabel("Description:");
		final JLabel lblSiret = new JLabel("SIRET:");
		final JLabel lblActivitydomain = new JLabel("Activity domain:");
		final JLabel lblWebaddress = new JLabel("Web address:");

		JPanel panelTextInfo = new JPanel();
		panelInfo.add(panelTextInfo, BorderLayout.CENTER);
		panelTextInfo.setLayout(new GridLayout(0, 1, 0, 0));

		tfSurname = new JTextField();
		tfSurname.setColumns(20);
		tfSurname.setText(personFacade.findPersonById(idPerson).getSurname());
		panelTextInfo.add(tfSurname);

		tfName = new JTextField();
		tfName.setText(personFacade.findPersonById(idPerson).getName());
		panelTextInfo.add(tfName);

		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setText(personFacade.findPersonById(idPerson)
				.getPhone_number());
		panelTextInfo.add(tfPhoneNumber);

		tfEmail = new JTextField();
		tfEmail.setText(personFacade.findPersonById(idPerson).getEmail());
		panelTextInfo.add(tfEmail);

		tfStreetNumber = new JTextField();
		tfStreetNumber.setText(addressFacade.findAddressOfAPerson(idPerson)
				.getStreet_number().toString());
		panelTextInfo.add(tfStreetNumber);

		tfStreet = new JTextField();
		tfStreet.setText(addressFacade.findAddressOfAPerson(idPerson)
				.getStreet());
		panelTextInfo.add(tfStreet);

		tfZipCode = new JTextField();
		tfZipCode.setText(addressFacade.findAddressOfAPerson(idPerson)
				.getZip_code().toString());
		panelTextInfo.add(tfZipCode);

		tfCity = new JTextField();
		tfCity.setText(addressFacade.findAddressOfAPerson(idPerson).getCity());
		panelTextInfo.add(tfCity);

		tfPassword = new JPasswordField();

		if (personFacade.isSeller(idPerson)) {
			panelLabelInfo.add(lblShopname);
			panelLabelInfo.add(lblDescription);
			panelLabelInfo.add(lblSiret);
			panelLabelInfo.add(lblActivitydomain);
			panelLabelInfo.add(lblWebaddress);

			tfShopname = new JTextField();
			tfShopname.setText(sellerFacade.getSellerById(idPerson)
					.getShop_name());
			tfDescription = new JTextField();
			tfDescription.setText(sellerFacade.getSellerById(idPerson)
					.getDescription());
			tfSiret = new JTextField();
			tfSiret.setText(sellerFacade.getSellerById(idPerson).getSiret()
					.toString());
			tfActivitydomain = new JTextField();
			tfActivitydomain.setText(sellerFacade.getSellerById(idPerson)
					.getActivity_domain());
			tfWebaddress = new JTextField();
			tfWebaddress.setText(sellerFacade.getSellerById(idPerson)
					.getWeb_adress());

			panelTextInfo.add(tfShopname);
			panelTextInfo.add(tfDescription);
			panelTextInfo.add(tfSiret);
			panelTextInfo.add(tfActivitydomain);
			panelTextInfo.add(tfWebaddress);
		}

		// Password
		panelLabelInfo.add(lblPassword);
		panelTextInfo.add(tfPassword);

		JPanel panelSouth = new JPanel();
		mainPanel.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panelButton = new JPanel();
		panelSouth.add(panelButton);
		panelButton.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnOk = new JButton("Update");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer id = null;
				if (personFacade.isSeller(idPerson)) {
					if (!(tfSurname.getText().isEmpty()
							|| tfName.getText().isEmpty()
							|| tfPhoneNumber.getText().isEmpty()
							|| tfEmail.getText().isEmpty()
							|| tfPassword.getText().isEmpty()
							|| tfStreet.getText().isEmpty()
							|| tfStreetNumber.getText().isEmpty()
							|| tfZipCode.getText().isEmpty()
							|| tfCity.getText().isEmpty()
							|| tfShopname.getText().isEmpty()
							|| tfDescription.getText().isEmpty()
							|| tfSiret.getText().isEmpty()
							|| tfActivitydomain.getText().isEmpty() || tfWebaddress
							.getText().isEmpty())) {
						try {
							personFacade.verifyPasswordById(idAdministrator,
									tfPassword.getText());
							id = personFacade.updatePerson(idPerson,
									tfSurname.getText(), tfName.getText(),
									tfPhoneNumber.getText(), tfEmail.getText(),
									tfPassword.getText(), tfStreet.getText(),
									tfStreetNumber.getText(),
									tfZipCode.getText(), tfCity.getText(),
									tfShopname.getText(),
									tfDescription.getText(), tfSiret.getText(),
									tfActivitydomain.getText(),
									tfWebaddress.getText());
							JOptionPane.showMessageDialog(null, personFacade
									.findPersonById(id).getSurname()
									+ " "
									+ personFacade.findPersonById(id).getName()
									+ "'s information has been updated.",
									"Information updated.",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (GoldfishException e1) {
							JOptionPane.showMessageDialog(null, e1.toString(),
									"Error.", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Please fill all the fields.", "Blank fields.",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					if (!(tfSurname.getText().isEmpty()
							|| tfName.getText().isEmpty()
							|| tfPhoneNumber.getText().isEmpty()
							|| tfEmail.getText().isEmpty()
							|| tfPassword.getText().isEmpty()
							|| tfStreet.getText().isEmpty()
							|| tfStreetNumber.getText().isEmpty()
							|| tfZipCode.getText().isEmpty() || tfCity
							.getText().isEmpty())) {
						try {
							personFacade.verifyPasswordById(idAdministrator,
									tfPassword.getText());
							id = personFacade.updatePerson(idPerson,
									tfSurname.getText(), tfName.getText(),
									tfPhoneNumber.getText(), tfEmail.getText(),
									tfPassword.getText(), tfStreet.getText(),
									tfStreetNumber.getText(),
									tfZipCode.getText(), tfCity.getText(),
									null, null, null, null, null);
							JOptionPane.showMessageDialog(null, personFacade
									.findPersonById(id).getSurname()
									+ " "
									+ personFacade.findPersonById(id).getName()
									+ "'s information has been updated.",
									"Information updated.",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (GoldfishException e1) {
							JOptionPane.showMessageDialog(null, e1.toString(),
									"Error.", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Please fill all the fields.", "Blank fields.",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		panelButton.add(btnOk);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer id = null;
				try {
					personFacade.verifyPasswordById(idAdministrator,
							tfPassword.getText());
					personFacade.deletePerson(idPerson);
					JOptionPane.showMessageDialog(null, "This person has been deleted.",
							"Person deleted.",
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
		tfCity.setText("");
		tfEmail.setText("");
		tfName.setText("");
		tfPassword.setText("");
		tfPhoneNumber.setText("");
		tfStreet.setText("");
		tfStreetNumber.setText("");
		tfSurname.setText("");
		tfZipCode.setText("");
	}
}
