package hotel.management.system;

import java.awt.Color;


import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{

	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	Login(){
		l1 = new JLabel("UserName");
		l1.setBounds(40,30,100,30);
		add(l1);
		
		l2 = new JLabel("Password");
		l2.setBounds(40,80,100,30);
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(150,30,150,30);
		add(t1);
		
		t2 = new JPasswordField();
		t2.setBounds(150,80,150,30);
		add(t2);
		
		b1 = new JButton("LOGIN");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(40,160,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("CANCEL");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(180,160,120,30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.png"));
		JLabel l3 = new JLabel(i1);
		l3.setBounds(350,10,219,230);
		add(l3);
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setBounds(360,200,600,300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			String username = t1.getText();
			@SuppressWarnings("deprecation")
			String password = t2.getText();
			String str = "select * from login where username = '"+username+"' and password = '"+password+"' ";
			Connectiontosql c = new Connectiontosql();
			try {
				ResultSet rs =  c.s.executeQuery(str);
				if(rs.next()) {
					new Dashboard().setVisible(true);
					this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid username or password");
					this.setVisible(false);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(ae.getSource()==b2) {
			System.exit(0);
		}
	}
	
	public static void main(String args[])
	{
		new Login();
	}
}
