/*
 * 
 */

package com.polytech.goldfish.userinterface;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import com.polytech.goldfish.businesslogic.business.Comment;
import com.polytech.goldfish.businesslogic.facade.CommentFacade;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationsUI.
 *
 * 
 */
public class CommentPanel extends JPanel{
	
	int noComment = 1;
	private final CommentFacade commentFacade ; 
	/** The list notif. */
	private final JPanel listComment = new JPanel();
	
	/** The liste notifs. */
	private final Collection<Comment> listComments;
	
	/** The scrollable pane layout. */
	private final SpringLayout scrollablePaneLayout;

	/** The offset. */
	public int offset;

	/** The text field date. */
	private JTextField textFieldDate;
	private JTextField textFieldNoComment;
	
	/** The text field subject. */
	private JTextField textFieldSubject;

	/**
	 * Instantiates a new notifications ui.
	 */
	public CommentPanel() {
		commentFacade = new CommentFacade();
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		JScrollPane scrollPane = new JScrollPane();

		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 0,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0,
				SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0,
				SpringLayout.EAST, this);
		add(scrollPane);

		scrollablePaneLayout = new SpringLayout();
		scrollPane.setViewportView(listComment);
		listComment.setLayout(new BoxLayout(listComment, BoxLayout.Y_AXIS));

		listComments = commentFacade.findAllComments();
		if(!(listComments.isEmpty())){
			noComment = 0;
		}

		display();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Views.AbstractView#display()
	 */
	public void display() {
		if(noComment == 1){
			JPanel panel = new JPanel();
			panel.setBorder(UIManager.getBorder("Tree.editorBorder"));
			panel.setPreferredSize(new Dimension(400, 130));
			panel.setBounds(6, 47, 432, 62);
			listComment.add(panel);
			panel.setLayout(null);
			
			textFieldNoComment = new JTextField();
			textFieldNoComment.setEditable(false);
			textFieldNoComment.setBounds(126, 5, 350, 28);
			panel.add(textFieldNoComment);
			textFieldNoComment.setColumns(10);
			textFieldNoComment.setText("You have no comments.");
		}
		for (Comment ac : listComments) {
			JPanel panel = new JPanel();
			panel.setBorder(UIManager.getBorder("Tree.editorBorder"));
			panel.setPreferredSize(new Dimension(400, 130));
			panel.setBounds(6, 47, 432, 62);
			listComment.add(panel);
			panel.setLayout(null);

			JLabel lblDate = new JLabel("Date of dispatch :");
			lblDate.setBounds(10, 6, 106, 23);
			panel.add(lblDate);

			JLabel lblConcerned = new JLabel("Concerned : ");
			lblConcerned.setBounds(10, 33, 106, 23);
			panel.add(lblConcerned);

			textFieldDate = new JTextField();
			textFieldDate.setEditable(false);
			textFieldDate.setBounds(126, 5, 350, 28);
			panel.add(textFieldDate);
			textFieldDate.setColumns(10);
			if (ac.getDate() != null) {
				textFieldDate.setText(ac.getDate().toString());
			}

			textFieldSubject = new JTextField();
			textFieldSubject.setEditable(false);
			textFieldSubject.setBounds(126, 34, 350, 28);
			textFieldSubject.setColumns(10);
			panel.add(textFieldSubject);
			textFieldSubject.setText((ac.getConcerned()).toString());

			JTextPane textPaneComment = new JTextPane();
			textPaneComment.setEditable(false);
			textPaneComment.setBounds(10, 72, 420, 52);
			panel.add(textPaneComment);
			textPaneComment.setText(ac.getText());

			JPanel panelButton = new JPanel();
			panel.add(panelButton);
			panelButton.setLayout(new GridLayout(1, 0, 0, 0));
			
			JButton btnOk = new JButton("New comment");
			panelButton.add(btnOk);
			
			panel.add(Box.createRigidArea(new Dimension(0, 5)));
			
		}
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
}