package com.polytech.goldfish.userinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import org.w3c.dom.views.AbstractView;
import org.w3c.dom.views.DocumentView;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeUI.
 *
 * 
 */
/**
 * @author RedaM
 * 
 */
public class MainFrameAdministrator extends JFrame implements AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The content panel. */
	private JPanel contentPanel;
	/** The window. */
	private final MainFrameAdministrator window;

	/** The spring layout. */
	private final SpringLayout springLayout;

	/** The menu panel. */
	private final JPanel menuPanel;

	/** The side panel. */
	private final JPanel sidePanel;

	/**
	 * Instantiates a new home ui.
	 */
	/**
	 * @param idPerson
	 */
	public MainFrameAdministrator(final Integer idPerson) {

		// creation of the window
		window = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Goldfish");
		setSize(new Dimension(1024, 600));

		// dimensions
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		// sidePanel
		sidePanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, sidePanel, 10,
				SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, sidePanel, 10,
				SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, sidePanel, -10,
				SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, sidePanel, 200,
				SpringLayout.WEST, getContentPane());
		sidePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(sidePanel);
		SpringLayout sl_sidePanel = new SpringLayout();
		sidePanel.setLayout(sl_sidePanel);

		// menuPanel
		menuPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, menuPanel, 10,
				SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, menuPanel, 10,
				SpringLayout.EAST, sidePanel);
		springLayout.putConstraint(SpringLayout.SOUTH, menuPanel, 60,
				SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, menuPanel, -10,
				SpringLayout.EAST, getContentPane());
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(menuPanel);
		SpringLayout sl_menuPanel = new SpringLayout();

		menuPanel.setLayout(sl_menuPanel);

		// Buttons
		// My account
		JButton btnHome = new JButton("Home");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnHome, 10,
				SpringLayout.NORTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnHome, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnHome, 40,
				SpringLayout.NORTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnHome, -10,
				SpringLayout.EAST, sidePanel);
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultContent();
			}
		});
		
		// Home
		JButton btnMyAccount = new JButton("My account");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyAccount, 50,
				SpringLayout.NORTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyAccount, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyAccount, 80,
				SpringLayout.NORTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyAccount, -10,
				SpringLayout.EAST, sidePanel);
		btnMyAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Administrator account"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new UpdatePersonPanel(idPerson));
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});

		// Create Person
		JButton btnCreatePerson = new JButton("Create person");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnCreatePerson, 100,
				SpringLayout.NORTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnCreatePerson, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnCreatePerson, 140,
				SpringLayout.NORTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnCreatePerson, -10,
				SpringLayout.EAST, sidePanel);
		btnCreatePerson.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
				contentPanel.add(new CreatePersonPanel());
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});

		// Create activity category
		JButton btnCreateActivityCategory = new JButton(
				"Create activity category");
		sl_sidePanel.putConstraint(SpringLayout.NORTH,
				btnCreateActivityCategory, 150, SpringLayout.NORTH,
				sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST,
				btnCreateActivityCategory, 10, SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST,
				btnCreateActivityCategory, -10, SpringLayout.EAST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH,
				btnCreateActivityCategory, 190, SpringLayout.NORTH,
				sidePanel);
		btnCreateActivityCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Create activity category"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new CreateActivityCategoryPanel());
				contentPanel.revalidate();
				contentPanel.repaint();
				// List of own activity
			}
		});

		// Create product category
		JButton btnCreateProductCategory = new JButton(
				"Create product category");
		sl_sidePanel.putConstraint(SpringLayout.NORTH,
				btnCreateProductCategory, 200, SpringLayout.NORTH,
				sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnCreateProductCategory,
				10, SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH,
				btnCreateProductCategory, 240, SpringLayout.NORTH,
				sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnCreateProductCategory,
				-10, SpringLayout.EAST, sidePanel);
		btnCreateProductCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Create product category"); // TRACE
			}
		});
		
		// Delete activity category
				JButton btnDeleteActivityCategory = new JButton(
						"Delete activity category");
				sl_sidePanel.putConstraint(SpringLayout.NORTH,
						btnDeleteActivityCategory, 250, SpringLayout.NORTH,
						sidePanel);
				sl_sidePanel.putConstraint(SpringLayout.WEST, btnDeleteActivityCategory,
						10, SpringLayout.WEST, sidePanel);
				sl_sidePanel.putConstraint(SpringLayout.SOUTH,
						btnDeleteActivityCategory, 290, SpringLayout.NORTH,
						sidePanel);
				sl_sidePanel.putConstraint(SpringLayout.EAST, btnDeleteActivityCategory,
						-10, SpringLayout.EAST, sidePanel);
				btnDeleteActivityCategory.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Delete activity category"); // TRACE
						contentPanel.removeAll();
						contentPanel.add(new DeleteActivityCategoryPanel());
						contentPanel.revalidate();
						contentPanel.repaint();
					}
				});
				

		// logout
		JButton btnLogout = new JButton("Log out");
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnLogout, -10,
				SpringLayout.SOUTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnLogout, -40,
				SpringLayout.SOUTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnLogout, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnLogout, -10,
				SpringLayout.EAST, sidePanel);
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("user logged off "); // TRACE
				// Log off the user
				JOptionPane.showMessageDialog(null,
						"You have been successfully logged out.");
				dispose();
			}
		});

		// MENU PANEL

		// Home
		JButton btnListWishlist = new JButton("Wishlists");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnListWishlist, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnListWishlist, 10,
				SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnListWishlist, -10,
				SpringLayout.SOUTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnListWishlist, 110,
				SpringLayout.WEST, menuPanel);
		btnListWishlist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("List Wishlists"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new ListWishlistPanel());
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});

		// List persons
		JButton btnListPersons = new JButton("Persons");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnListPersons, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnListPersons, 120,
				SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnListPersons, -10,
				SpringLayout.SOUTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnListPersons, 220,
				SpringLayout.WEST, menuPanel);
		btnListPersons.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("list persons"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new ListPersonsPanel());
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});

		// List of activities categories
		JButton btnListActivityCategory = new JButton(
				"Activities categories");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnListActivityCategory,
				10, SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnListActivityCategory,
				230, SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnListActivityCategory,
				-10, SpringLayout.SOUTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnListActivityCategory,
				400, SpringLayout.WEST, menuPanel);
		btnListActivityCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("List of activities categories"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new ListActivitiesCategoriesPanel());
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});

		// List of product categories
		JButton btnListCategoryProducts = new JButton("Products categories");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnListCategoryProducts,
				10, SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnListCategoryProducts,
				410, SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnListCategoryProducts,
				-10, SpringLayout.SOUTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnListCategoryProducts,
				560, SpringLayout.WEST, menuPanel);
		btnListCategoryProducts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Product categories"); // TRACE
			}
		});

		// Manage comments
		JButton btnManageComments = new JButton("Manage comments");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnManageComments, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnManageComments, -10,
				SpringLayout.SOUTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnManageComments, 570,
				SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnManageComments, 720,
				SpringLayout.WEST, menuPanel);
		btnManageComments.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Manage comments"); // TRACE
				// TODO
			}
		});

		contentPanel = new JPanel();
		getContentPane().add(contentPanel);

		setDefaultContent();

		setVisible(true);

		// Adding buttons to panels
		sidePanel.add(btnHome);
		sidePanel.add(btnMyAccount);
		sidePanel.add(btnCreatePerson);
		sidePanel.add(btnCreateActivityCategory);
		sidePanel.add(btnCreateProductCategory);
		sidePanel.add(btnDeleteActivityCategory);
		sidePanel.add(btnLogout);

		menuPanel.add(btnListWishlist);
		menuPanel.add(btnListPersons);
		menuPanel.add(btnListActivityCategory);
		menuPanel.add(btnListCategoryProducts);
		menuPanel.add(btnManageComments);
		
	}

	/**
	 * Close.
	 */
	public void close() {
		this.dispose();
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

	/**
	 * Sets the content.
	 * 
	 * @param av
	 *            the new content
	 */
	public void setContent(JPanel av) {
		getContentPane().remove(contentPanel);
		contentPanel = av;
		springLayout.putConstraint(SpringLayout.NORTH, contentPanel, 10,
				SpringLayout.SOUTH, menuPanel);
		springLayout.putConstraint(SpringLayout.WEST, contentPanel, 0,
				SpringLayout.WEST, menuPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, contentPanel, -10,
				SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, contentPanel, 0,
				SpringLayout.EAST, menuPanel);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel);
		repaint();
		revalidate();
	}

	/**
	 * Sets the default content.
	 */
	public void setDefaultContent() {
		getContentPane().remove(contentPanel);
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		JLabel logo = new JLabel(new ImageIcon("src/logo.png"));
		contentPanel.add(logo, BorderLayout.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, contentPanel, 10,
				SpringLayout.SOUTH, menuPanel);
		springLayout.putConstraint(SpringLayout.WEST, contentPanel, 0,
				SpringLayout.WEST, menuPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, contentPanel, -10,
				SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, contentPanel, 0,
				SpringLayout.EAST, menuPanel);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel);
		repaint();
		revalidate();
	}

	@Override
	public DocumentView getDocument() {
		// TODO Auto-generated method stub
		return null;
	}
}