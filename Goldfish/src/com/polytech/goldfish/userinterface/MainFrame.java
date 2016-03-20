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
	public MainFrame(Integer idPerson) {
		personFacade = new PersonFacade();
		
		window = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Goldfish");
		setSize(new Dimension(1024, 600));

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

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

		JButton btnMyAccount = new JButton("My account");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyAccount, 10,
				SpringLayout.NORTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyAccount, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyAccount, 40,
				SpringLayout.NORTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyAccount, -10,
				SpringLayout.EAST, sidePanel);
		sidePanel.add(btnMyAccount);
		btnMyAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("account "); // TRACE
				// Update user pop up or window
			}
		});

		JButton btnMyOrders = new JButton("My orders");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyOrders, 50,
				SpringLayout.SOUTH, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyOrders, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyOrders, 80,
				SpringLayout.SOUTH, btnMyAccount);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyOrders, -10,
				SpringLayout.EAST, sidePanel);
		sidePanel.add(btnMyOrders);
		btnMyOrders.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("own orders "); // TRACE
				// List of own orders pop up
			}
		});

		if (this.personFacade.isUser(idPerson)) { // C'est un user clasique

			JButton btnMyProducts = new JButton("My products");
			sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyProducts, 10,
					SpringLayout.SOUTH, btnMyOrders);
			sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyProducts, 10,
					SpringLayout.WEST, sidePanel);
			sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyProducts, 40,
					SpringLayout.SOUTH, btnMyOrders);
			sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyProducts, -10,
					SpringLayout.EAST, sidePanel);
			sidePanel.add(btnMyProducts);
			btnMyProducts.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("own product "); // TRACE
					// List of own product
				}
			});

			JButton btnMyDiary = new JButton("My diary");
			sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyDiary, 10,
					SpringLayout.SOUTH, btnMyProducts);
			sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyDiary, 10,
					SpringLayout.WEST, sidePanel);
			sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyDiary, 40,
					SpringLayout.SOUTH, btnMyProducts);
			sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyDiary, -10,
					SpringLayout.EAST, sidePanel);
			sidePanel.add(btnMyDiary);
			btnMyDiary.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("own diary"); // TRACE
					// List of own diary entrys
				}
			});
		}

		if (this.personFacade.isAdministrator(idPerson)) { // Si c'est un admin
			JButton btnMyActivities = new JButton("My activities");
			sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyActivities, 10,
					SpringLayout.SOUTH, btnMyAccount);
			sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyActivities, 10,
					SpringLayout.WEST, sidePanel);
			sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyActivities, -10,
					SpringLayout.EAST, sidePanel);
			sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyActivities, 40,
					SpringLayout.SOUTH, btnMyAccount);
			sidePanel.add(btnMyActivities);
			btnMyActivities.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("own activity "); // TRACE
					// List of own activity
				}
			});
		}

		JButton btnMyNotifications = new JButton("My notifications");
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnMyNotifications, 10,
				SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnMyNotifications, -10,
				SpringLayout.EAST, sidePanel);
		sidePanel.add(btnMyNotifications);
		btnMyNotifications.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("own notif "); // TRACE
				//  List of own notifications
			}
		});

		JButton btnLogoff = new JButton("Log Out");
		sl_sidePanel.putConstraint(SpringLayout.NORTH, btnMyNotifications, -40,
				SpringLayout.NORTH, btnLogoff);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnLogoff, -10,
				SpringLayout.SOUTH, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnMyNotifications, -10,
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

		JButton btnHome = new JButton("Home");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnHome, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnHome, 10,
				SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnHome, 40,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnHome, 110,
				SpringLayout.WEST, menuPanel);
		menuPanel.add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultContent();
			}
		});

		JButton btnActivities = new JButton("Activities");
		btnActivities.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // Peut etre inutile
				System.out.println("activities "); // TRACE
				// Activitys window or pop up
			}
		});
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnActivities, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnActivities, 10,
				SpringLayout.EAST, btnHome);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnActivities, 40,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnActivities, 110,
				SpringLayout.EAST, btnHome);
		menuPanel.add(btnActivities);
		btnActivities.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("activities 2 "); // TRACE
				// Activitys window or pop up
			}
		});

		JButton btnGoals = new JButton("Goals");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnGoals, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnGoals, 10,
				SpringLayout.EAST, btnActivities);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnGoals, 40,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnGoals, 110,
				SpringLayout.EAST, btnActivities);
		menuPanel.add(btnGoals);
		btnGoals.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Goals "); // TRACE
				contentPanel.removeAll(); // Les 4 lignes sont le "squelette" de ce qu'il
				contentPanel.add(new CreatePersonPanel()); // faut faire pour
				contentPanel.revalidate();  // pour charger un panel
				contentPanel.repaint(); // dans la home page 
			}
		});

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
		menuPanel.add(btnShop);

		if (this.personFacade.isAdministrator(idPerson)) {

			JButton btnUsers = new JButton("Users");
			sl_menuPanel.putConstraint(SpringLayout.NORTH, btnUsers, 10,
					SpringLayout.NORTH, menuPanel);
			sl_menuPanel.putConstraint(SpringLayout.WEST, btnUsers, 10,
					SpringLayout.EAST, btnShop);
			sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnUsers, 40,
					SpringLayout.NORTH, menuPanel);
			sl_menuPanel.putConstraint(SpringLayout.EAST, btnUsers, 110,
					SpringLayout.EAST, btnShop);
			menuPanel.add(btnUsers);
			btnUsers.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("List of users "); // TRACE
					contentPanel.removeAll(); // Les 4 lignes sont le "squelette" de ce qu'il
					contentPanel.add(new ListPersonsPanel()); // faut faire pour
					contentPanel.revalidate();  // pour charger un panel
					contentPanel.repaint(); // dans la home page 
				}
			});

/*			JButton btnWish = new JButton("wishList");
			sl_menuPanel.putConstraint(SpringLayout.NORTH, btnWish, 10,
					SpringLayout.NORTH, menuPanel);
			sl_menuPanel.putConstraint(SpringLayout.WEST, btnWish, 10,
					SpringLayout.EAST, btnUsers);
			sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnWish, 40,
					SpringLayout.NORTH, menuPanel);
			sl_menuPanel.putConstraint(SpringLayout.EAST, btnWish, 110,
					SpringLayout.EAST, btnUsers);
			btnWish.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//
				}
			});
			menuPanel.add(btnWish);
*/

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
					// Categorys of the person 
				}
			});
			sidePanel.add(btnCategories);

			JButton btnManageOrders = new JButton("Manage Orders");
			sl_sidePanel.putConstraint(SpringLayout.NORTH, btnManageOrders,
					210, SpringLayout.SOUTH, btnMyAccount);
			sl_sidePanel.putConstraint(SpringLayout.WEST, btnManageOrders, 0,
					SpringLayout.WEST, btnMyAccount);
			sl_sidePanel.putConstraint(SpringLayout.SOUTH, btnManageOrders,
					240, SpringLayout.SOUTH, btnMyAccount);
			sl_sidePanel.putConstraint(SpringLayout.EAST, btnManageOrders, 0,
					SpringLayout.EAST, btnMyAccount);
			btnManageOrders.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("My orders "); // TRACE
					// Own orders and posibility to manage them 
				}
			});
			sidePanel.add(btnManageOrders);
		}

		JButton btnCart = new JButton("Cart");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnCart, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnCart, -110,
				SpringLayout.EAST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnCart, 40,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnCart, -10,
				SpringLayout.EAST, menuPanel);
		menuPanel.add(btnCart);

		contentPanel = new JPanel();
		getContentPane().add(contentPanel);

		setDefaultContent();

		setVisible(true);

		btnCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("My cart"); // TRACE
				// Create or update new cart
			}
		});
	}

	/**
	 * Close.
	 */
	public void close() {
		this.dispose();
	}

	/* (non-Javadoc)
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
	 * @param av the new content
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
