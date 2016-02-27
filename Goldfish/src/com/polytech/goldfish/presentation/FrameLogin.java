package com.polytech.goldfish.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FrameLogin extends JFrame implements ActionListener
{
    JLabel l1, l2, l3;
    JTextField tf1;
    JButton btn1;
    JPasswordField p1;
 
    FrameLogin()
    {
        setTitle("Login");
        setVisible(true);
        setSize(800, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        l1 = new JLabel("Login :");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
 
        l2 = new JLabel("Enter Email:");
        l3 = new JLabel("Enter Password:");
        tf1 = new JTextField();
        p1 = new JPasswordField();
        btn1 = new JButton("Connection");
 
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        p1.setBounds(300, 110, 200, 30);
        btn1.setBounds(150, 160, 100, 30);
 
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(p1);
        add(btn1);
        btn1.addActionListener(this);
    }
 
    public void actionPerformed(ActionEvent e)
    {
        showData();
    }
 
    public void showData()
    {
        JFrame f1 = new JFrame();
        JLabel l, l0;
 
        String str1 = tf1.getText();
        char[] p = p1.getPassword();
        String str2 = new String(p);
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe", "sandeep", "welcome");
            PreparedStatement ps = con.prepareStatement("select name from reg where email=? and pass=?");
            ps.setString(1, str1);
            ps.setString(2, str2);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                f1.setVisible(true);
                f1.setSize(600, 600);
                f1.setLayout(null);
                l = new JLabel();
                l0 = new JLabel("you are succefully logged in..");
                l0.setForeground(Color.blue);
                l0.setFont(new Font("Serif", Font.BOLD, 30));
                l.setBounds(60, 50, 400, 30);
                l0.setBounds(60, 100, 400, 40);
 
                f1.add(l);
                f1.add(l0);
                l.setText("Welcome " + rs.getString(1));
                l.setForeground(Color.red);
                l.setFont(new Font("Serif", Font.BOLD, 30));
 
            } else
            {
                JOptionPane.showMessageDialog(null,
                   "Incorrect email-Id or password..Try Again with correct detail");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
 
    public static void main(String arr[])
    {
        new FrameLogin();
    }
}







/*
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrameLogin extends JDialog implements ActionListener {
	
	public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("bob") && password.equals("secret")) {
            return true;
        }
        return false;
    }
	
        final JFrame frame = new JFrame();
 
        // Create OK button
        JButton btnOK = new JButton("OK");
        // Add event handler for OK button
    
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub	
		}
        btnOK.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame,
                                "You've clicked OK button"
                                );
                    }
                });
        // Create Cancel button
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame,
                                "You've clicked Cancel button"
                                );
                    }
                });
 
        // Add buttons to a panel
        JPanel buttonPanel = new JPanel( );
        buttonPanel.add(btnOK);
        buttonPanel.add(btnCancel);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane( ).add(buttonPanel,BorderLayout.SOUTH);
        frame.setVisible(true);
    }
	
    public static void main(String[] args) {
    	
   	 final JFrame frame = new JFrame("JTextField Demo");
   	 
        JLabel lblFName = new JLabel("First Name:");
        JTextField tfFName = new JTextField(20);
        lblFName.setLabelFor(tfFName);
 
        JLabel lblLName = new JLabel("Last Name:");
        JTextField tfLName = new JTextField(20);
        lblLName.setLabelFor(tfLName);
 
        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());
 
        panel.add(lblFName);
        panel.add(tfFName);
        panel.add(lblLName);
        panel.add(tfLName);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
   }

}

*/