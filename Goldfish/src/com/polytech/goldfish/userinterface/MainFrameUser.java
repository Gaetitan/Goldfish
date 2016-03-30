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
public class MainFrameUser extends JFrame implements AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The content panel. */
	private JPanel contentPanel;
	/** The window. */
	private final MainFrameUser window;

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
	public MainFrameUser(final Integer idPerson) {

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
		// Home
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

		// My account
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
				System.out.println("User account"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new UpdatePersonPanel(idPerson));
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});

		// Create activity
		JButton btnCreateActivityCategory = new JButton("Create activity");
		sl_sidePanel.putConstraint(SpringLayout.NORTH,
				btnCreateActivityCategory, 90, SpringLayout.NORTH,sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST,
				btnCreateActivityCategory, 10, SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST,
				btnCreateActivityCategory, -10, SpringLayout.EAST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH,
				btnCreateActivityCategory, 120, SpringLayout.NORTH,sidePanel);
		btnCreateActivityCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Create activity"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new CreateActivityPanel(idPerson));
				contentPanel.revalidate();
				contentPanel.repaint();
				// Create activity
			}
		});

		// Create wishlist
		JButton btnCreateWishlist = new JButton("Create wishlist");
		sl_sidePanel.putConstraint(SpringLayout.NORTH,btnCreateWishlist, 130, SpringLayout.NORTH,sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnCreateWishlist,10, SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH,btnCreateWishlist, 160, SpringLayout.NORTH,sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnCreateWishlist,-10, SpringLayout.EAST, sidePanel);
		btnCreateWishlist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Create WIshlist"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new CreateWishlistPanel());
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});

		// Create Diary Entry
		JButton btnCreateDiaryEntry = new JButton("Create diary entry");
		sl_sidePanel.putConstraint(SpringLayout.NORTH,btnCreateDiaryEntry, 210, SpringLayout.NORTH,sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnCreateDiaryEntry,10, SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH,btnCreateDiaryEntry, 240, SpringLayout.NORTH,sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnCreateDiaryEntry,-10, SpringLayout.EAST, sidePanel);
		btnCreateDiaryEntry.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Create Diary Entry"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new CreateDiaryEntryPanel());
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});

		// Create Goal
		JButton btnCreateGoal = new JButton("Create goal");
		sl_sidePanel.putConstraint(SpringLayout.NORTH,btnCreateGoal, 250, SpringLayout.NORTH,sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnCreateGoal,10, SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH,btnCreateGoal, 280, SpringLayout.NORTH,sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnCreateGoal,-10, SpringLayout.EAST, sidePanel);
		btnCreateGoal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Create Goal"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new CreateGoalPanel());
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});


		// Create comment
		JButton btnCreateComment = new JButton("Create comment");
		sl_sidePanel.putConstraint(SpringLayout.NORTH,btnCreateComment, 250, SpringLayout.NORTH,sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.WEST, btnCreateComment,10, SpringLayout.WEST, sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.SOUTH,btnCreateComment, 280, SpringLayout.NORTH,sidePanel);
		sl_sidePanel.putConstraint(SpringLayout.EAST, btnCreateComment,-10, SpringLayout.EAST, sidePanel);
		btnCreateComment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Create comment"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new NewCommentPanel(idPerson));
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

		// List Wishlist
		JButton btnListWishlist = new JButton("My Wishlists");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnListWishlist, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnListWishlist, 10,
				SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnListWishlist, -10,
				SpringLayout.SOUTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnListWishlist, 130,
				SpringLayout.WEST, menuPanel);
		btnListWishlist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("list persons"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new ListWishlistPanel(idPerson));
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});

		// List activities
		JButton btnListActivities = new JButton("My Activities");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnListActivities, 10,
				SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnListActivities, 140,
				SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnListActivities, -10,
				SpringLayout.SOUTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnListActivities, 260,
				SpringLayout.WEST, menuPanel);
		btnListActivities.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("list persons"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new ListMyActivitiesPanel(idPerson));
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});

		// My Shopping Cart
		JButton btnMyShoppingCart = new JButton(
				"My Shopping Cart");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnMyShoppingCart,
				10, SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnMyShoppingCart,
				270, SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnMyShoppingCart,
				-10, SpringLayout.SOUTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnMyShoppingCart,
				410, SpringLayout.WEST, menuPanel);
		btnMyShoppingCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("My Shopping Cart"); // TRACE
				contentPanel.removeAll();
				contentPanel.add(new ShoppingCartPanel());
				contentPanel.revalidate();
				contentPanel.repaint();
			}
		});

		/*// List of product categories
		JButton btnListCategoryProducts = new JButton("Products categories");
		sl_menuPanel.putConstraint(SpringLayout.NORTH, btnListCategoryProducts,
				10, SpringLayout.NORTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnListCategoryProducts,
				390, SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.SOUTH, btnListCategoryProducts,
				-10, SpringLayout.SOUTH, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnListCategoryProducts,
				540, SpringLayout.WEST, menuPanel);
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
		sl_menuPanel.putConstraint(SpringLayout.WEST, btnManageComments, 550,
				SpringLayout.WEST, menuPanel);
		sl_menuPanel.putConstraint(SpringLayout.EAST, btnManageComments, 700,
				SpringLayout.WEST, menuPanel);
		btnManageComments.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Manage comments"); // TRACE
				// TODO
			}
		});*/

		contentPanel = new JPanel();
		getContentPane().add(contentPanel);

		setDefaultContent();

		setVisible(true);

		// Adding buttons to panels
		sidePanel.add(btnHome);
		sidePanel.add(btnMyAccount);
		sidePanel.add(btnCreateActivityCategory);
		sidePanel.add(btnCreateWishlist);
		sidePanel.add(btnCreateDiaryEntry);
		sidePanel.add(btnCreateGoal);
		sidePanel.add(btnLogout);

		menuPanel.add(btnListWishlist);
		menuPanel.add(btnListActivities);
		menuPanel.add(btnMyShoppingCart);
		/*menuPanel.add(btnListCategoryProducts);
		menuPanel.add(btnManageComments);*/
		
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