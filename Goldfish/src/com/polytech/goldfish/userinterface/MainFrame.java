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

import com.polytech.goldfish.businesslogic.facade.PersonFacade;

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
public class MainFrame extends JFrame implements AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final PersonFacade personFacade;

	/** The content panel. */
	private JPanel contentPanel;
	/** The window. */
	private final MainFrame window;

	/** The spring layout. */
	private final SpringLayout springLayout;

	/** The menu panel. */
	private final JPanel menuPanel;

	/** The side panel. */
	private final JPanel sidePanel;

	/**
	 * Instantiates a new home ui.
	 */
	public MainFrame(final Integer idPerson) {
		personFacade = new PersonFacade();

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

		// Buttons
		// My account
		JButton btnMyAccount = new JButton("My account");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyAccount, 10,
				SpringLayout.NORTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyAccount, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyAccount, 40,
				SpringLayout.NORTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyAccount, -10,
				SpringLayout.EAST, sidePanel);
		btnMyAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("account "); // TRACE
				contentPanel.removeAll(); // Les 4 lignes sont le "squelette" de
											// ce qu'il
				contentPanel.add(new UpdatePersonPanel(idPerson)); // faut faire
																	// pour
				contentPanel.revalidate(); // pour charger un panel
				contentPanel.repaint(); // dans la home page
				// Update user pop up or window
			}
		});

		// My orders
		JButton btnMyOrders = new JButton("My orders");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyOrders, 50,
				SpringLayout.SOUTH, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyOrders, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyOrders, 80,
				SpringLayout.SOUTH, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyOrders, -10,
				SpringLayout.EAST, sidePanel);
		btnMyOrders.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("own orders "); // TRACE
			}
		});

		// Create Person
		JButton btnCreatePerson = new JButton("Create person");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnCreatePerson, 50,
				SpringLayout.SOUTH, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnCreatePerson, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnCreatePerson, 80,
				SpringLayout.SOUTH, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnCreatePerson, -10,
				SpringLayout.EAST, sidePanel);
		btnCreatePerson.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll(); // Les 4 lignes sont le "squelette" de
				// ce qu'il
				contentPanel.add(new CreatePersonPanel()); // faut faire pour
				contentPanel.revalidate(); // pour charger un panel
				contentPanel.repaint(); // dans la home page
			}
		});

		// My products
		JButton btnMyProducts = new JButton("My products");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyProducts, 10,
				SpringLayout.SOUTH, btnMyOrders);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyProducts, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyProducts, 40,
				SpringLayout.SOUTH, btnMyOrders);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyProducts, -10,
				SpringLayout.EAST, sidePanel);
		btnMyProducts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("own product "); // TRACE
				// List of own product
			}
		});

		// List persons
		JButton btnListPersons = new JButton("List all persons");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnListPersons, 10,
				SpringLayout.SOUTH, btnMyOrders);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnListPersons, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnListPersons, 40,
				SpringLayout.SOUTH, btnMyOrders);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnListPersons, -10,
				SpringLayout.EAST, sidePanel);
		btnListPersons.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("list persons"); // TRACE
				contentPanel.removeAll(); // Les 4 lignes sont le "squelette" de
				// ce qu'il
				contentPanel.add(new ListPersonsPanel()); // faut faire pour
				contentPanel.revalidate(); // pour charger un panel
				contentPanel.repaint(); // dans la home page
			}
		});

		// My diary
		JButton btnMyDiary = new JButton("My diary");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyDiary, 10,
				SpringLayout.SOUTH, btnMyProducts);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyDiary, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyDiary, 40,
				SpringLayout.SOUTH, btnMyProducts);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyDiary, -10,
				SpringLayout.EAST, sidePanel);
		btnMyDiary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("own diary"); // TRACE
				// List of own diary entrys
			}
		});

		// My activities
		JButton btnMyActivities = new JButton("Create activity category");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyActivities, 10,
				SpringLayout.SOUTH, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyActivities, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyActivities, -10,
				SpringLayout.EAST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyActivities, 40,
				SpringLayout.SOUTH, btnMyAccount);
		btnMyActivities.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("own activity "); // TRACE
				// List of own activity
			}
		});

		// My comments
		JButton btnMyComments = new JButton("My comments");
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyComments, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyComments, -10,
				SpringLayout.EAST, sidePanel);
		btnMyComments.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("own comments "); // TRACE
				contentPanel.removeAll(); // Les 4 lignes sont le "squelette" de
											// ce qu'il
				contentPanel.add(new CommentPanel()); // faut faire pour
				contentPanel.revalidate(); // pour charger un panel
				contentPanel.repaint(); // dans la home page
			}
		});

		JButton btnLogoff = new JButton("Log Out");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyComments, -40,
				SpringLayout.NORTH, btnLogoff);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnLogoff, -10,
				SpringLayout.SOUTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyComments, -10,
				SpringLayout.NORTH, btnLogoff);
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnLogoff, -40,
				SpringLayout.SOUTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnLogoff, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnLogoff, -10,
				SpringLayout.EAST, sidePanel);
		sidePanel.add(btnLogoff);
		btnLogoff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("user logged off "); // TRACE
				// Log off the user
				JOptionPane.showMessageDialog(null,
						"You have been successfully logged out.");
				dispose();
			}
		});

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

		// Home
		JButton btnHome = new JButton("Home");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnHome, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnHome, 10,
				SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnHome, 40,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnHome, 110,
				SpringLayout.WEST, menuPanel);
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultContent();
			}
		});

		// Activities
		JButton btnActivities = new JButton("Activities");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnActivities, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnActivities, 10,
				SpringLayout.EAST, btnHome);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnActivities, 40,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnActivities, 110,
				SpringLayout.EAST, btnHome);
		btnActivities.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("activities 2 "); // TRACE
				// Activities window or pop up
			}
		});

		// My goals
		JButton btnGoals = new JButton("Goals");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnGoals, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnGoals, 10,
				SpringLayout.EAST, btnActivities);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnGoals, 40,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnGoals, 110,
				SpringLayout.EAST, btnActivities);
		btnGoals.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Goals "); // TRACE
				// Liste de tous les goals
			}
		});

		// Shop
		JButton btnShop = new JButton("Shop");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnShop, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnShop, 10,
				SpringLayout.EAST, btnGoals);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnShop, 40,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnShop, 110,
				SpringLayout.EAST, btnGoals);
		btnShop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("I want to shop "); // TRACE
				// He want to shop so cart or however
			}
		});

		// Users
		JButton btnUsers = new JButton("Users");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnUsers, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnUsers, 10,
				SpringLayout.EAST, btnShop);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnUsers, 40,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnUsers, 110,
				SpringLayout.EAST, btnShop);
		btnUsers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("List of users "); // TRACE
			}
		});

		
		 JButton btnWish = new JButton("wishList");
		 sl_menuPanel.putConstraint(SpringLayout.NORTH, btnWish, 10,
		 SpringLayout.NORTH, menuPanel);
		 sl_menuPanel.putConstraint(SpringLayout.WEST, btnWish, 10,
		 SpringLayout.EAST, btnUsers);
		 sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnWish, 40,
		 SpringLayout.NORTH, menuPanel);
		 sl_menuPanel.putConstraint(SpringLayout.EAST, btnWish, 110,
		 SpringLayout.EAST, btnUsers); btnWish.addActionListener(new
		 ActionListener() {
		 
		 @Override public void actionPerformed(ActionEvent e) { 
			 
			 System.out.println("Wishlist "); // TRACE
				contentPanel.removeAll(); // Les 4 lignes sont le
											// "squelette" de ce qu'il
				if (personFacade.isAdministrator(idPerson)){
				contentPanel.add(new ListWishlistPanel());}
				else{
					contentPanel.add(new ListWishlistPanel(idPerson));// faut faire pour
				}
				contentPanel.revalidate(); // pour charger un panel
				contentPanel.repaint(); // dans la home page
			 
		 } });
		 menuPanel.add(btnWish);
		 

		// Categories
		JButton btnCategories = new JButton("My categories");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnCategories, 170,
				SpringLayout.SOUTH, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnCategories, 0,
				SpringLayout.WEST, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnCategories, 200,
				SpringLayout.SOUTH, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnCategories, 0,
				SpringLayout.EAST, btnMyAccount);
		btnCategories.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("My categories "); // TRACE
				// Categories of the person
			}
		});

		// Manage orders
		JButton btnManageOrders = new JButton("Manage Orders");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnManageOrders, 210,
				SpringLayout.SOUTH, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnManageOrders, 0,
				SpringLayout.WEST, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnManageOrders, 240,
				SpringLayout.SOUTH, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnManageOrders, 0,
				SpringLayout.EAST, btnMyAccount);
		btnManageOrders.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("My orders "); // TRACE
				// Own orders and posibility to manage them
			}
		});

		// Cart
		JButton btnCart = new JButton("Cart");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnCart, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnCart, -110,
				SpringLayout.EAST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnCart, 40,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnCart, -10,
				SpringLayout.EAST, menuPanel);
		btnCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("My cart"); // TRACE
				// Create or update new cart
			}
		});

		contentPanel = new JPanel();
		getContentPane().add(contentPanel);

		setDefaultContent();

		setVisible(true);

		// Adding the buttons to the panels
		if (this.personFacade.isUser(idPerson)) {
			sidePanel.add(btnMyAccount);
			sidePanel.add(btnMyOrders);
			sidePanel.add(btnMyProducts);
			sidePanel.add(btnMyDiary);
			sidePanel.add(btnMyActivities);
			sidePanel.add(btnMyComments);
			menuPanel.add(btnHome);
			menuPanel.add(btnActivities);
			menuPanel.add(btnGoals);
			menuPanel.add(btnShop);
			menuPanel.add(btnUsers);
			sidePanel.add(btnCategories);
			sidePanel.add(btnManageOrders);
			menuPanel.add(btnCart);
		}

		if (this.personFacade.isAdministrator(idPerson)) {
			sidePanel.add(btnMyAccount);
			sidePanel.add(btnCreatePerson);
			sidePanel.add(btnListPersons);
			sidePanel.add(btnMyDiary);
			sidePanel.add(btnMyActivities);
			sidePanel.add(btnMyComments);
			menuPanel.add(btnHome);
			menuPanel.add(btnActivities);
			menuPanel.add(btnGoals);
			menuPanel.add(btnShop);
			menuPanel.add(btnUsers);
			sidePanel.add(btnCategories);
			sidePanel.add(btnManageOrders);
			menuPanel.add(btnCart);
		}
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