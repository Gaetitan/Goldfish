/*
 * 
 */

package com.polytech.goldfish.userinterface;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginPopup.
 *
 * @author Florent
 */
public class LoginPopup extends JFrame implements ActionListener,
		KeyListener {
	
	private final String pass = "true";
	
	/** The password field password. */
	private final JPasswordField passwordFieldPassword;
	
	/** The text field login. */
	private final JTextField textFieldLogin;
	
	/** The btn login. */
	private final JButton btnLogin;

	/**
	 * Instantiates a new login popup.
	 */
	public LoginPopup() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Log In");

		getContentPane().setPreferredSize(new Dimension(400, 130));
		getContentPane().setLayout(null);
		pack();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(120, 10, 210, 30);
		getContentPane().add(textFieldLogin);
		textFieldLogin.addKeyListener(this);
		textFieldLogin.setColumns(10);

		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(120, 50, 210, 30);
		passwordFieldPassword.addKeyListener(this);
		getContentPane().add(passwordFieldPassword);
		passwordFieldPassword.setColumns(10);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(120, 90, 100, 25);
		btnLogin.addActionListener(this);
		getContentPane().add(btnLogin);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(230, 90, 100, 25);
		btnRegister.addActionListener(this);
		getContentPane().add(btnRegister);

		ImageIcon logo = new ImageIcon(new ImageIcon("src/logo.png").getImage()
				.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		JLabel lblLogo = new JLabel(logo);
		lblLogo.setBounds(10, 10, 100, 100);
		getContentPane().add(lblLogo);

		setVisible(true);

		textFieldLogin.setText("test");
		passwordFieldPassword.setText("test");
		// btnLogin.doClick();

		setResizable(false);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getText().equals("Login")
				&& textFieldLogin.getText().length() > 0
				&& passwordFieldPassword.getPassword().length > 0) {
			if (pass == "true") { // TODO real password and login to check
				dispose();
				new MainFrame();
			} else {
				JOptionPane.showMessageDialog(null, "Bad login or password",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (((JButton) e.getSource()).getText().equals("Register")) {
			dispose();
			// register pop up to display here
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Views.AbstractView#display()
	 */
	public void display() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Views.AbstractView#hide()
	 */
	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			btnLogin.doClick();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}
